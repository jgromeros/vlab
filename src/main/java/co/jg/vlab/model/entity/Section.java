package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sections database table.
 * 
 */
@Entity
@Table(name="sections")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SECTIONS_ID_GENERATOR", sequenceName="SC_SECTIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SECTIONS_ID_GENERATOR")
	private Integer id;

	private String name;

	private String url;

	//bi-directional many-to-one association to Section
    @ManyToOne
	@JoinColumn(name="parent_section")
	private Section section;

	//bi-directional many-to-one association to Section
	@OneToMany(mappedBy="section")
	private Set<Section> sections;

	//bi-directional many-to-many association to Role
    @ManyToMany
	@JoinTable(
		name="sections_roles"
		, joinColumns={
			@JoinColumn(name="section")
			}
		, inverseJoinColumns={
			@JoinColumn(name="role")
			}
		)
	private Set<Role> roles;

    public Section() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public Set<Section> getSections() {
		return this.sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}
	
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}