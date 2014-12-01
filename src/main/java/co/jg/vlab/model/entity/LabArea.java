package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the lab_area database table.
 * 
 */
@Entity
@Table(name="lab_area")
public class LabArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LAB_AREA_ID_GENERATOR", sequenceName="SC_LAB_AREA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LAB_AREA_ID_GENERATOR")
	private Integer id;

	private String description;

	//bi-directional many-to-one association to TestDescription
	@OneToMany(mappedBy="labAreaBean")
	private Set<TestDescription> testDescriptions;

    public LabArea() {
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

	public Set<TestDescription> getTestDescriptions() {
		return this.testDescriptions;
	}

	public void setTestDescriptions(Set<TestDescription> testDescriptions) {
		this.testDescriptions = testDescriptions;
	}
	
}