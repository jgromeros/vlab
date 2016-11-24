package co.jg.vlab.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

/**
 * The persistent class for the labcase database table.
 * 
 */
@Entity
@NamedQuery(name = "Labcase.findByCode", query = "select l from Labcase l where l.code = :code")
public class Labcase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LABCASE_ID_GENERATOR", sequenceName="SC_LABCASE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LABCASE_ID_GENERATOR")
	private Integer id;

	@Column(name="analysis_purpose")
	private String analysisPurpose;

	private String code;

	private String farm;

	private String observations;

	private String owner;

    @Temporal( TemporalType.DATE)
	@Column(name="reception_date")
	private Date receptionDate;

	@Column(name="reproductive_problem")
	private String reproductiveProblem;

	@Column(name="results_number")
	private Integer resultsNumber;

	private String sender;

	private String state;

	private String zone;

	//bi-directional many-to-one association to Animal
	@JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="labcaseBean")
	private Set<Animal> animals;

	//bi-directional many-to-one association to Enterprise
    @ManyToOne
	@JoinColumn(name="enterprise")
	private Enterprise enterpriseBean;

	//bi-directional many-to-one association to LabProfessional
    @ManyToOne
	@JoinColumn(name="technical_director")
	private LabProfessional labProfessional;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="city")
	private Place place;

    public Labcase() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnalysisPurpose() {
		return this.analysisPurpose;
	}

	public void setAnalysisPurpose(String analysisPurpose) {
		this.analysisPurpose = analysisPurpose;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFarm() {
		return this.farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getReceptionDate() {
		return this.receptionDate;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
	}

	public String getReproductiveProblem() {
		return this.reproductiveProblem;
	}

	public void setReproductiveProblem(String reproductiveProblem) {
		this.reproductiveProblem = reproductiveProblem;
	}

	public Integer getResultsNumber() {
		return this.resultsNumber;
	}

	public void setResultsNumber(Integer resultsNumber) {
		this.resultsNumber = resultsNumber;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public Set<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}
	
	public Enterprise getEnterpriseBean() {
		return this.enterpriseBean;
	}

	public void setEnterpriseBean(Enterprise enterpriseBean) {
		this.enterpriseBean = enterpriseBean;
	}
	
	public LabProfessional getLabProfessional() {
		return this.labProfessional;
	}

	public void setLabProfessional(LabProfessional labProfessional) {
		this.labProfessional = labProfessional;
	}
	
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}