package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLES_ROLENAME_GENERATOR", sequenceName="SC_ROLES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_ROLENAME_GENERATOR")
	@Column(name="role_name")
	private String roleName;

	@Column(name="role_description")
	private String roleDescription;

	//bi-directional many-to-many association to Section
	@ManyToMany(mappedBy="roles")
	private Set<Section> sections;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

    public Role() {
    }

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<Section> getSections() {
		return this.sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}