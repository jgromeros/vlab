package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the test database table.
 * 
 */
@Entity
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEST_ID_GENERATOR", sequenceName="SC_TEST")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_ID_GENERATOR")
	private Integer id;

	@Column(name="apply_discount")
	private Boolean applyDiscount;

	@Column(name="counter_sample")
	private Boolean counterSample;

	private String observations;

	private String status;

	//bi-directional many-to-one association to AssemblyTest
	@OneToMany(mappedBy="testBean")
	private Set<AssemblyTest> assemblyTests;

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="testBean")
	private Set<BillDetail> billDetails;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="testBean")
	private Set<Result> results;

	//bi-directional many-to-one association to Animal
    @ManyToOne
	@JoinColumn(name="animal")
	private Animal animalBean;

	//bi-directional many-to-one association to TestDescription
    @ManyToOne
	@JoinColumn(name="test_description")
	private TestDescription testDescriptionBean;

	//bi-directional many-to-one association to TestProfile
    @ManyToOne
	@JoinColumn(name="test_profile")
	private TestProfile testProfileBean;

    public Test() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getApplyDiscount() {
		return this.applyDiscount;
	}

	public void setApplyDiscount(Boolean applyDiscount) {
		this.applyDiscount = applyDiscount;
	}

	public Boolean getCounterSample() {
		return this.counterSample;
	}

	public void setCounterSample(Boolean counterSample) {
		this.counterSample = counterSample;
	}

	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<AssemblyTest> getAssemblyTests() {
		return this.assemblyTests;
	}

	public void setAssemblyTests(Set<AssemblyTest> assemblyTests) {
		this.assemblyTests = assemblyTests;
	}
	
	public Set<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(Set<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}
	
	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
	public Animal getAnimalBean() {
		return this.animalBean;
	}

	public void setAnimalBean(Animal animalBean) {
		this.animalBean = animalBean;
	}
	
	public TestDescription getTestDescriptionBean() {
		return this.testDescriptionBean;
	}

	public void setTestDescriptionBean(TestDescription testDescriptionBean) {
		this.testDescriptionBean = testDescriptionBean;
	}
	
	public TestProfile getTestProfileBean() {
		return this.testProfileBean;
	}

	public void setTestProfileBean(TestProfile testProfileBean) {
		this.testProfileBean = testProfileBean;
	}
	
}