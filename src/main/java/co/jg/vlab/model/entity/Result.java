package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESULT_ID_GENERATOR", sequenceName="SC_RESULT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESULT_ID_GENERATOR")
	private Integer id;

	@Column(name="relative_value")
	private String relativeValue;

    @Temporal( TemporalType.DATE)
	@Column(name="result_date")
	private Date resultDate;

	@Column(name="string_value")
	private String stringValue;

	//bi-directional many-to-one association to AssemblyControl
	@OneToMany(mappedBy="resultBean")
	private Set<AssemblyControl> assemblyControls;

	//bi-directional many-to-one association to AssemblyTest
    @ManyToOne
	@JoinColumn(name="assembly_test")
	private AssemblyTest assemblyTestBean;

	//bi-directional many-to-one association to LabProfessional
    @ManyToOne
	@JoinColumn(name="lab_professional")
	private LabProfessional labProfessionalBean;

	//bi-directional many-to-one association to ResultFactor
    @ManyToOne
	@JoinColumn(name="result_factor")
	private ResultFactor resultFactorBean;

	//bi-directional many-to-one association to Test
    @ManyToOne
	@JoinColumn(name="test")
	private Test testBean;

    public Result() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRelativeValue() {
		return this.relativeValue;
	}

	public void setRelativeValue(String relativeValue) {
		this.relativeValue = relativeValue;
	}

	public Date getResultDate() {
		return this.resultDate;
	}

	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}

	public String getStringValue() {
		return this.stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public Set<AssemblyControl> getAssemblyControls() {
		return this.assemblyControls;
	}

	public void setAssemblyControls(Set<AssemblyControl> assemblyControls) {
		this.assemblyControls = assemblyControls;
	}
	
	public AssemblyTest getAssemblyTestBean() {
		return this.assemblyTestBean;
	}

	public void setAssemblyTestBean(AssemblyTest assemblyTestBean) {
		this.assemblyTestBean = assemblyTestBean;
	}
	
	public LabProfessional getLabProfessionalBean() {
		return this.labProfessionalBean;
	}

	public void setLabProfessionalBean(LabProfessional labProfessionalBean) {
		this.labProfessionalBean = labProfessionalBean;
	}
	
	public ResultFactor getResultFactorBean() {
		return this.resultFactorBean;
	}

	public void setResultFactorBean(ResultFactor resultFactorBean) {
		this.resultFactorBean = resultFactorBean;
	}
	
	public Test getTestBean() {
		return this.testBean;
	}

	public void setTestBean(Test testBean) {
		this.testBean = testBean;
	}
	
}