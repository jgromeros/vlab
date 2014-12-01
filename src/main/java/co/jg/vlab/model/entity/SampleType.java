package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the sample_type database table.
 * 
 */
@Entity
@Table(name="sample_type")
public class SampleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SAMPLE_TYPE_ID_GENERATOR", sequenceName="SC_SAMPLE_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SAMPLE_TYPE_ID_GENERATOR")
	private Integer id;

	private String description;

	//bi-directional many-to-one association to TestDescription
	@OneToMany(mappedBy="sampleTypeBean")
	private Set<TestDescription> testDescriptions;

    public SampleType() {
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