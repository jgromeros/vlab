package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the test_profile database table.
 * 
 */
@Entity
@Table(name="test_profile")
public class TestProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEST_PROFILE_ID_GENERATOR", sequenceName="SC_TEST_PROFILE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_PROFILE_ID_GENERATOR")
	private Integer id;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="testProfileBean")
	private Set<Test> tests;

	//bi-directional many-to-one association to Profile
    @ManyToOne
	@JoinColumn(name="profile")
	private Profile profileBean;

    public TestProfile() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Test> getTests() {
		return this.tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	public Profile getProfileBean() {
		return this.profileBean;
	}

	public void setProfileBean(Profile profileBean) {
		this.profileBean = profileBean;
	}
	
}