package sd.wekala.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionCheck {

	String[] workspace() default {};

	boolean read() default false;

	boolean write() default false;

	boolean delete() default false;
}
