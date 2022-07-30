package sd.wekala.model;


import javax.persistence.*;

@Entity
@Table(name = "permission")
public class PermissionEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "roles")
	@Enumerated(EnumType.STRING)
	private Roles roles;

	@Basic
	private String workspace;

	@Basic
	private Boolean isread = Boolean.FALSE;

	@Basic
	private Boolean iswrite = Boolean.FALSE;

	@Basic
	private Boolean isdelete = Boolean.FALSE;

	public PermissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissionEntity(Roles roles, String workspace, Boolean isread, Boolean iswrite, Boolean isdelete) {
		super();
		this.roles = roles;
		this.workspace = workspace;
		this.isread = isread;
		this.iswrite = iswrite;
		this.isdelete = isdelete;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public Boolean getIsread() {
		return isread;
	}

	public void setIsread(Boolean isread) {
		this.isread = isread;
	}

	public Boolean getIswrite() {
		return iswrite;
	}

	public void setIswrite(Boolean iswrite) {
		this.iswrite = iswrite;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}
}
