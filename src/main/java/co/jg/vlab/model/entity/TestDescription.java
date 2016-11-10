package co.jg.vlab.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.postgresql.util.PGInterval;

import co.jg.vlab.model.IntervalConverter;


/**
 * The persistent class for the test_description database table.
 * 
 */
@Entity
@Table(name="test_description")
public class TestDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TEST_DESCRIPTION_ID_GENERATOR", sequenceName="SC_TEST_DESCRIPTION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TEST_DESCRIPTION_ID_GENERATOR")
	private Integer id;

	@Column(name="avg_result_time")
	@Convert(converter = IntervalConverter.class)
	private String avgResultTime;

	private String description;

	@Column(name="ica_acronym")
	private String icaAcronym;

	@Column(name="invoice_code")
	private String invoiceCode;

	@Column(name="save_in_bank")
	private Boolean saveInBank;

	@Column(name="show_reference_value")
	private Boolean showReferenceValue;

	@Column(name="we_do_it")
	private Boolean weDoIt;

	//bi-directional many-to-one association to AssemblyControl
	@OneToMany(mappedBy="testDescriptionBean")
	private Set<AssemblyControl> assemblyControls;

	//bi-directional many-to-one association to PricesByTestDesc
	@OneToMany(mappedBy="testDescriptionBean")
	private Set<PricesByTestDesc> pricesByTestDescs;

	//bi-directional many-to-one association to ResultFactor
	@OneToMany(mappedBy="testDescriptionBean")
	private Set<ResultFactor> resultFactors;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="testDescriptionBean")
	private Set<Test> tests;

	//bi-directional many-to-one association to AssemblyType
    @ManyToOne
	@JoinColumn(name="assembly_type")
	private AssemblyType assemblyTypeBean;

	//bi-directional many-to-one association to LabArea
    @ManyToOne
	@JoinColumn(name="lab_area")
	private LabArea labAreaBean;

	//bi-directional many-to-one association to SampleType
    @ManyToOne
	@JoinColumn(name="sample_type")
	private SampleType sampleTypeBean;

	//bi-directional many-to-many association to Profile
    @ManyToMany
	@JoinTable(
		name="test_description_profile"
		, joinColumns={
			@JoinColumn(name="test_description")
			}
		, inverseJoinColumns={
			@JoinColumn(name="profile")
			}
		)
	private Set<Profile> profiles;

    public TestDescription() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAvgResultTime() {
		return this.avgResultTime;
	}

	public void setAvgResultTime(String avgResultTime) {
		this.avgResultTime = avgResultTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcaAcronym() {
		return this.icaAcronym;
	}

	public void setIcaAcronym(String icaAcronym) {
		this.icaAcronym = icaAcronym;
	}

	public String getInvoiceCode() {
		return this.invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public Boolean getSaveInBank() {
		return this.saveInBank;
	}

	public void setSaveInBank(Boolean saveInBank) {
		this.saveInBank = saveInBank;
	}

	public Boolean getShowReferenceValue() {
		return this.showReferenceValue;
	}

	public void setShowReferenceValue(Boolean showReferenceValue) {
		this.showReferenceValue = showReferenceValue;
	}

	public Boolean getWeDoIt() {
		return this.weDoIt;
	}

	public void setWeDoIt(Boolean weDoIt) {
		this.weDoIt = weDoIt;
	}

	public Set<AssemblyControl> getAssemblyControls() {
		return this.assemblyControls;
	}

	public void setAssemblyControls(Set<AssemblyControl> assemblyControls) {
		this.assemblyControls = assemblyControls;
	}
	
	public Set<PricesByTestDesc> getPricesByTestDescs() {
		return this.pricesByTestDescs;
	}

	public void setPricesByTestDescs(Set<PricesByTestDesc> pricesByTestDescs) {
		this.pricesByTestDescs = pricesByTestDescs;
	}
	
	public Set<ResultFactor> getResultFactors() {
		return this.resultFactors;
	}

	public void setResultFactors(Set<ResultFactor> resultFactors) {
		this.resultFactors = resultFactors;
	}
	
	public Set<Test> getTests() {
		return this.tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	public AssemblyType getAssemblyTypeBean() {
		return this.assemblyTypeBean;
	}

	public void setAssemblyTypeBean(AssemblyType assemblyTypeBean) {
		this.assemblyTypeBean = assemblyTypeBean;
	}
	
	public LabArea getLabAreaBean() {
		return this.labAreaBean;
	}

	public void setLabAreaBean(LabArea labAreaBean) {
		this.labAreaBean = labAreaBean;
	}
	
	public SampleType getSampleTypeBean() {
		return this.sampleTypeBean;
	}

	public void setSampleTypeBean(SampleType sampleTypeBean) {
		this.sampleTypeBean = sampleTypeBean;
	}
	
	public Set<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
}