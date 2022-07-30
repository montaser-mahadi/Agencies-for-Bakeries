package sd.wekala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.PermissionEntity;
import sd.wekala.model.Roles;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
	List<PermissionEntity> findByRolesAndWorkspaceIn(Roles roles, String... workspace);
}
