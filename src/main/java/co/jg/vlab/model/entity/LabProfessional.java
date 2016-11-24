package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

import java.util.Set;


/**
 * The persistent class for the lab_professional database table.
 * 
 */
@Entity
@Table(name="lab_professional")
public class LabProfessional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LAB_PROFESSIONAL_ID_GENERATOR", sequenceName="SC_LAB_PROFESSIONAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LAB_PROFESSIONAL_ID_GENERATOR")
	private Integer id;

	private String dni;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String status;

	@Column(name="technical_director")
	private Boolean technicalDirector;

	//bi-directional many-to-one association to ApplicationOwner
    @ManyToOne
	@JoinColumn(name="lab")
	private ApplicationOwner applicationOwner;

	//bi-directional many-to-one association to Labcase
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="labProfessional")
	private Set<Labcase> labcases;

	//bi-directional many-to-one association to Result
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="labProfessionalBean")
	private Set<Result> results;

    public LabProfessional() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getTechnicalDirector() {
		return this.technicalDirector;
	}

	public void setTechnicalDirector(Boolean technicalDirector) {
		this.technicalDirector = technicalDirector;
	}

	public ApplicationOwner getApplicationOwner() {
		return this.applicationOwner;
	}

	public void setApplicationOwner(ApplicationOwner applicationOwner) {
		this.applicationOwner = applicationOwner;
	}
	
	public Set<Labcase> getLabcases() {
		return this.labcases;
	}

	public void setLabcases(Set<Labcase> labcases) {
		this.labcases = labcases;
	}
	
	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
}