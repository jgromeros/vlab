package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the assembly_descriptor database table.
 * 
 */
@Entity
@Table(name="assembly_descriptor")
public class AssemblyDescriptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSEMBLY_DESCRIPTOR_ID_GENERATOR", sequenceName="SC_ASSEMBLY_DESCRIPTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSEMBLY_DESCRIPTOR_ID_GENERATOR")
	private Integer id;

	private Integer col;

	private String name;

	private Integer row;

	//bi-directional many-to-one association to AssemblyControl
	@OneToMany(mappedBy="assemblyDescriptorBean")
	private Set<AssemblyControl> assemblyControls;

	//bi-directional many-to-one association to AssemblyType
    @ManyToOne
	@JoinColumn(name="assembly_type")
	private AssemblyType assemblyTypeBean;

    public AssemblyDescriptor() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCol() {
		return this.col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRow() {
		return this.row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Set<AssemblyControl> getAssemblyControls() {
		return this.assemblyControls;
	}

	public void setAssemblyControls(Set<AssemblyControl> assemblyControls) {
		this.assemblyControls = assemblyControls;
	}
	
	public AssemblyType getAssemblyTypeBean() {
		return this.assemblyTypeBean;
	}

	public void setAssemblyTypeBean(AssemblyType assemblyTypeBean) {
		this.assemblyTypeBean = assemblyTypeBean;
	}
	
}