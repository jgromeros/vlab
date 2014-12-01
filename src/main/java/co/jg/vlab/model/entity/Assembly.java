package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the assembly database table.
 * 
 */
@Entity
public class Assembly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSEMBLY_ID_GENERATOR", sequenceName="SC_ASSEMBLY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSEMBLY_ID_GENERATOR")
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="assembly_date")
	private Date assemblyDate;

	@Column(name="init_col")
	private Integer initCol;

	@Column(name="init_row")
	private Integer initRow;

	//bi-directional many-to-one association to AssemblyType
    @ManyToOne
	@JoinColumn(name="assembly_type")
	private AssemblyType assemblyTypeBean;

	//bi-directional many-to-one association to AssemblyTest
	@OneToMany(mappedBy="assemblyBean")
	private Set<AssemblyTest> assemblyTests;

    public Assembly() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAssemblyDate() {
		return this.assemblyDate;
	}

	public void setAssemblyDate(Date assemblyDate) {
		this.assemblyDate = assemblyDate;
	}

	public Integer getInitCol() {
		return this.initCol;
	}

	public void setInitCol(Integer initCol) {
		this.initCol = initCol;
	}

	public Integer getInitRow() {
		return this.initRow;
	}

	public void setInitRow(Integer initRow) {
		this.initRow = initRow;
	}

	public AssemblyType getAssemblyTypeBean() {
		return this.assemblyTypeBean;
	}

	public void setAssemblyTypeBean(AssemblyType assemblyTypeBean) {
		this.assemblyTypeBean = assemblyTypeBean;
	}
	
	public Set<AssemblyTest> getAssemblyTests() {
		return this.assemblyTests;
	}

	public void setAssemblyTests(Set<AssemblyTest> assemblyTests) {
		this.assemblyTests = assemblyTests;
	}
	
}