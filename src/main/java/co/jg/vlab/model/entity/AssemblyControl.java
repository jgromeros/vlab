package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the assembly_control database table.
 * 
 */
@Entity
@Table(name="assembly_control")
public class AssemblyControl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSEMBLY_CONTROL_ID_GENERATOR", sequenceName="SC_ASSEMBLY_CONTROL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSEMBLY_CONTROL_ID_GENERATOR")
	private Integer id;

	//bi-directional many-to-one association to AssemblyDescriptor
    @ManyToOne
	@JoinColumn(name="assembly_descriptor")
	private AssemblyDescriptor assemblyDescriptorBean;

	//bi-directional many-to-one association to Result
    @ManyToOne
	@JoinColumn(name="result")
	private Result resultBean;

	//bi-directional many-to-one association to TestDescription
    @ManyToOne
	@JoinColumn(name="test_description")
	private TestDescription testDescriptionBean;

	//bi-directional many-to-one association to AssemblyTest
	@OneToMany(mappedBy="assemblyControl")
	private Set<AssemblyTest> assemblyTests;

    public AssemblyControl() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AssemblyDescriptor getAssemblyDescriptorBean() {
		return this.assemblyDescriptorBean;
	}

	public void setAssemblyDescriptorBean(AssemblyDescriptor assemblyDescriptorBean) {
		this.assemblyDescriptorBean = assemblyDescriptorBean;
	}
	
	public Result getResultBean() {
		return this.resultBean;
	}

	public void setResultBean(Result resultBean) {
		this.resultBean = resultBean;
	}
	
	public TestDescription getTestDescriptionBean() {
		return this.testDescriptionBean;
	}

	public void setTestDescriptionBean(TestDescription testDescriptionBean) {
		this.testDescriptionBean = testDescriptionBean;
	}
	
	public Set<AssemblyTest> getAssemblyTests() {
		return this.assemblyTests;
	}

	public void setAssemblyTests(Set<AssemblyTest> assemblyTests) {
		this.assemblyTests = assemblyTests;
	}
	
}