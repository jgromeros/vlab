package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the assembly_type database table.
 * 
 */
@Entity
@Table(name="assembly_type")
public class AssemblyType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSEMBLY_TYPE_ID_GENERATOR", sequenceName="SC_ASSEMBLY_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSEMBLY_TYPE_ID_GENERATOR")
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Assembly
	@OneToMany(mappedBy="assemblyTypeBean")
	private Set<Assembly> assemblies;

	//bi-directional many-to-one association to AssemblyDescriptor
	@OneToMany(mappedBy="assemblyTypeBean")
	private Set<AssemblyDescriptor> assemblyDescriptors;

	//bi-directional many-to-one association to TestDescription
	@OneToMany(mappedBy="assemblyTypeBean")
	private Set<TestDescription> testDescriptions;

    public AssemblyType() {
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

	public Set<Assembly> getAssemblies() {
		return this.assemblies;
	}

	public void setAssemblies(Set<Assembly> assemblies) {
		this.assemblies = assemblies;
	}
	
	public Set<AssemblyDescriptor> getAssemblyDescriptors() {
		return this.assemblyDescriptors;
	}

	public void setAssemblyDescriptors(Set<AssemblyDescriptor> assemblyDescriptors) {
		this.assemblyDescriptors = assemblyDescriptors;
	}
	
	public Set<TestDescription> getTestDescriptions() {
		return this.testDescriptions;
	}

	public void setTestDescriptions(Set<TestDescription> testDescriptions) {
		this.testDescriptions = testDescriptions;
	}
	
}