package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_USERNAME_GENERATOR", sequenceName="SC_USERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERNAME_GENERATOR")
	@Column(name="user_name")
	private String userName;

	private Boolean active;

	@Column(name="user_pass")
	private String userPass;

	//bi-directional many-to-many association to Role
    @ManyToMany
	@JoinTable(
		name="user_roles"
		, joinColumns={
			@JoinColumn(name="user_name")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role_name")
			}
		)
	private Set<Role> roles;

    public User() {
    }

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}