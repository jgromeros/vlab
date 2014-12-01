package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFILE_ID_GENERATOR", sequenceName="SC_PROFILE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFILE_ID_GENERATOR")
	private Integer id;

	private String description;

	//bi-directional many-to-one association to PricesByTestDesc
	@OneToMany(mappedBy="profileBean")
	private Set<PricesByTestDesc> pricesByTestDescs;

	//bi-directional many-to-many association to TestDescription
	@ManyToMany(mappedBy="profiles")
	private Set<TestDescription> testDescriptions;

	//bi-directional many-to-one association to TestProfile
	@OneToMany(mappedBy="profileBean")
	private Set<TestProfile> testProfiles;

    public Profile() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PricesByTestDesc> getPricesByTestDescs() {
		return this.pricesByTestDescs;
	}

	public void setPricesByTestDescs(Set<PricesByTestDesc> pricesByTestDescs) {
		this.pricesByTestDescs = pricesByTestDescs;
	}
	
	public Set<TestDescription> getTestDescriptions() {
		return this.testDescriptions;
	}

	public void setTestDescriptions(Set<TestDescription> testDescriptions) {
		this.testDescriptions = testDescriptions;
	}
	
	public Set<TestProfile> getTestProfiles() {
		return this.testProfiles;
	}

	public void setTestProfiles(Set<TestProfile> testProfiles) {
		this.testProfiles = testProfiles;
	}
	
}