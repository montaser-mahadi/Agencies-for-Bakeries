package sd.wekala.service;

import org.springframework.security.core.authority.AuthorityUtils;

import sd.wekala.model.Roles;

public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Roles roles;

	public SecurityUserDetails(Long id, String userName, String password, Roles roles) {
		super(userName, password, AuthorityUtils.createAuthorityList(roles.getRoleName()));
		this.id = id;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public Roles getRoles() {
		return roles;
	}
}
