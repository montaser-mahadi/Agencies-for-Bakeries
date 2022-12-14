package sd.wekala.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import sd.wekala.model.PermissionEntity;
import sd.wekala.repository.PermissionRepository;
import sd.wekala.util.SecurityUtil;

import java.util.List;
import java.util.function.Function;

@Aspect
@Component
public class PermissionAspect {

	@Autowired
	private PermissionRepository permissionRepository;

	@Around("execution(@sd.wekala.aspect.PermissionCheck * *(..)) && @annotation(permissionCheck)")
	public Object doSomething(ProceedingJoinPoint pjp, PermissionCheck permissionCheck) throws Throwable {
		if (permissionCheck.workspace().length > 0 && SecurityUtil.getUser() != null) {
			List<PermissionEntity> permissionList = permissionRepository
					.findByRolesAndWorkspaceIn(SecurityUtil.getUser().getRoles(), permissionCheck.workspace());

			Function<PermissionEntity, Boolean> permissionFunction = new Function<PermissionEntity, Boolean>() {
				@Override
				public Boolean apply(PermissionEntity permissionEntity) {
					if (permissionCheck.read() && permissionEntity.getIsread()) {
						return true;
					}
					if (permissionCheck.write() && permissionEntity.getIswrite()) {
						return true;
					}
					if (permissionCheck.delete() && permissionEntity.getIsdelete()) {
						return true;
					}
					return false;
				}
			};

			final boolean[] hasPermission = { false };
			permissionList.forEach(permissionEntity -> {
				hasPermission[0] = permissionFunction.apply(permissionEntity);
				if (hasPermission[0]) {
					return;
				}
			});

			if (!hasPermission[0]) {
				throw new AccessDeniedException("Do not has permission");
			}

		}
		return pjp.proceed();
	}
}
