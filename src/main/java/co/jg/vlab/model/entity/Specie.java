package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the specie database table.
 * 
 */
@Entity
public class Specie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPECIE_ID_GENERATOR", sequenceName="SC_SPECIE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECIE_ID_GENERATOR")
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Race
	@OneToMany(mappedBy="specieBean")
	private Set<Race> races;

	//bi-directional many-to-one association to ReferenceValue
	@OneToMany(mappedBy="specieBean")
	private Set<ReferenceValue> referenceValues;

    public Specie() {
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

	public Set<Race> getRaces() {
		return this.races;
	}

	public void setRaces(Set<Race> races) {
		this.races = races;
	}
	
	public Set<ReferenceValue> getReferenceValues() {
		return this.referenceValues;
	}

	public void setReferenceValues(Set<ReferenceValue> referenceValues) {
		this.referenceValues = referenceValues;
	}
	
}