package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

import java.util.Set;


/**
 * The persistent class for the application_owner database table.
 * 
 */
@Entity
@Table(name="application_owner")
public class ApplicationOwner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APPLICATION_OWNER_ID_GENERATOR", sequenceName="SC_APPLICATION_OWNER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPLICATION_OWNER_ID_GENERATOR")
	private Integer id;

	private String address;

	@Column(name="authorized_tests")
	private String authorizedTests;

	private String fax;

	private String name;

	private String nit;

	private String phone;

	private String webpage;

	//bi-directional many-to-one association to AuthorizationCode
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="applicationOwner")
	private Set<AuthorizationCode> authorizationCodes;

	//bi-directional many-to-one association to LabProfessional
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="applicationOwner")
	private Set<LabProfessional> labProfessionals;

    public ApplicationOwner() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAuthorizedTests() {
		return this.authorizedTests;
	}

	public void setAuthorizedTests(String authorizedTests) {
		this.authorizedTests = authorizedTests;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return this.nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebpage() {
		return this.webpage;
	}

	public void setWebpage(String webpage) {
		this.webpage = webpage;
	}

	public Set<AuthorizationCode> getAuthorizationCodes() {
		return this.authorizationCodes;
	}

	public void setAuthorizationCodes(Set<AuthorizationCode> authorizationCodes) {
		this.authorizationCodes = authorizationCodes;
	}
	
	public Set<LabProfessional> getLabProfessionals() {
		return this.labProfessionals;
	}

	public void setLabProfessionals(Set<LabProfessional> labProfessionals) {
		this.labProfessionals = labProfessionals;
	}
	
}