package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANIMAL_ID_GENERATOR", sequenceName="SC_ANIMAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANIMAL_ID_GENERATOR")
	private Integer id;

	private String age;

	private String gender;

	@Column(name="medical_history")
	private String medicalHistory;

	private String name;

	private String observations;

	private Integer position;

	//bi-directional many-to-one association to Labcase
    @ManyToOne
	@JoinColumn(name="labcase")
	private Labcase labcaseBean;

	//bi-directional many-to-one association to Race
    @ManyToOne
	@JoinColumn(name="race")
	private Race raceBean;

	//bi-directional many-to-one association to BankPlace
	@OneToMany(mappedBy="animalBean")
	private Set<BankPlace> bankPlaces;

	//bi-directional many-to-one association to Test
	@OneToMany(mappedBy="animalBean")
	private Set<Test> tests;

    public Animal() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMedicalHistory() {
		return this.medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Labcase getLabcaseBean() {
		return this.labcaseBean;
	}

	public void setLabcaseBean(Labcase labcaseBean) {
		this.labcaseBean = labcaseBean;
	}
	
	public Race getRaceBean() {
		return this.raceBean;
	}

	public void setRaceBean(Race raceBean) {
		this.raceBean = raceBean;
	}
	
	public Set<BankPlace> getBankPlaces() {
		return this.bankPlaces;
	}

	public void setBankPlaces(Set<BankPlace> bankPlaces) {
		this.bankPlaces = bankPlaces;
	}
	
	public Set<Test> getTests() {
		return this.tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
}