package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the race database table.
 * 
 */
@Entity
public class Race implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RACE_ID_GENERATOR", sequenceName="SC_RACE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RACE_ID_GENERATOR")
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="raceBean")
	private Set<Animal> animals;

	//bi-directional many-to-one association to Specie
    @ManyToOne
	@JoinColumn(name="specie")
	private Specie specieBean;

    public Race() {
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

	public Set<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}
	
	public Specie getSpecieBean() {
		return this.specieBean;
	}

	public void setSpecieBean(Specie specieBean) {
		this.specieBean = specieBean;
	}
	
}