package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the assembly_test database table.
 * 
 */
@Entity
@Table(name="assembly_test")
public class AssemblyTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSEMBLY_TEST_ID_GENERATOR", sequenceName="SC_ASSEMBLY_TEST")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSEMBLY_TEST_ID_GENERATOR")
	private Integer id;

	private Integer col;

	private Integer plaque;

	private Integer position;

	private Integer row;

	//bi-directional many-to-one association to Assembly
    @ManyToOne
	@JoinColumn(name="assembly")
	private Assembly assemblyBean;

	//bi-directional many-to-one association to AssemblyControl
    @ManyToOne
	@JoinColumn(name="control")
	private AssemblyControl assemblyControl;

	//bi-directional many-to-one association to Test
    @ManyToOne
	@JoinColumn(name="test")
	private Test testBean;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="assemblyTestBean")
	private Set<Result> results;

    public AssemblyTest() {
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

	public Integer getPlaque() {
		return this.plaque;
	}

	public void setPlaque(Integer plaque) {
		this.plaque = plaque;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getRow() {
		return this.row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Assembly getAssemblyBean() {
		return this.assemblyBean;
	}

	public void setAssemblyBean(Assembly assemblyBean) {
		this.assemblyBean = assemblyBean;
	}
	
	public AssemblyControl getAssemblyControl() {
		return this.assemblyControl;
	}

	public void setAssemblyControl(AssemblyControl assemblyControl) {
		this.assemblyControl = assemblyControl;
	}
	
	public Test getTestBean() {
		return this.testBean;
	}

	public void setTestBean(Test testBean) {
		this.testBean = testBean;
	}
	
	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
}