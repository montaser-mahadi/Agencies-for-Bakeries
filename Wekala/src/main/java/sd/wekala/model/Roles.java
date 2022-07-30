package sd.wekala.model;


public enum Roles {
	Admin("ROLE_ADMIN"), User("ROLE_USER");

	private String roleName;

	Roles(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}
}

