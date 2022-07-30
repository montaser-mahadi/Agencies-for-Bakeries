package sd.wekala.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "username", length = 64, nullable = false, unique = true)
	private String username;

	@Column(name = "password", length = 64, nullable = false)
	private String password;

	@Column(name = "roles")
	@Enumerated(value = EnumType.STRING)
	private Roles roles;

	@Column(name = "createDate")
	private Date createDate;

	@Column(name = "lastInDate")
	private Date lastInDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastInDate() {
		return lastInDate;
	}

	public void setLastInDate(Date lastInDate) {
		this.lastInDate = lastInDate;
	}
}
