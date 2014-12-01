package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the bank_place database table.
 * 
 */
@Entity
@Table(name="bank_place")
public class BankPlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BANK_PLACE_ID_GENERATOR", sequenceName="SC_BANK_PLACE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BANK_PLACE_ID_GENERATOR")
	private Integer id;

	private Integer level;

	@Column(name="long_description")
	private String longDescription;

	private String name;

	private Integer position;

	//bi-directional many-to-one association to Animal
    @ManyToOne
	@JoinColumn(name="animal")
	private Animal animalBean;

	//bi-directional many-to-one association to BankPlace
    @ManyToOne
	@JoinColumn(name="placed_in")
	private BankPlace bankPlace;

	//bi-directional many-to-one association to BankPlace
	@OneToMany(mappedBy="bankPlace")
	private Set<BankPlace> bankPlaces;

    public BankPlace() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLongDescription() {
		return this.longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Animal getAnimalBean() {
		return this.animalBean;
	}

	public void setAnimalBean(Animal animalBean) {
		this.animalBean = animalBean;
	}
	
	public BankPlace getBankPlace() {
		return this.bankPlace;
	}

	public void setBankPlace(BankPlace bankPlace) {
		this.bankPlace = bankPlace;
	}
	
	public Set<BankPlace> getBankPlaces() {
		return this.bankPlaces;
	}

	public void setBankPlaces(Set<BankPlace> bankPlaces) {
		this.bankPlaces = bankPlaces;
	}
	
}