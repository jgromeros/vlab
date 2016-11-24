package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the enterprise database table.
 * 
 */
@Entity
public class Enterprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENTERPRISE_ID_GENERATOR", sequenceName="SC_ENTERPRISE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENTERPRISE_ID_GENERATOR")
	private Integer id;

	private String address;

	private BigDecimal dni;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="numero_ica")
	private String numeroIca;

	private String phone;

	//bi-directional many-to-one association to Bill
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="enterprise")
	private Set<Bill> bills;

	//bi-directional many-to-one association to Labcase
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="enterpriseBean")
	private Set<Labcase> labcases;

    public Enterprise() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getDni() {
		return this.dni;
	}

	public void setDni(BigDecimal dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getNumeroIca() {
		return this.numeroIca;
	}

	public void setNumeroIca(String numeroIca) {
		this.numeroIca = numeroIca;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Bill> getBills() {
		return this.bills;
	}

	public void setBills(Set<Bill> bills) {
		this.bills = bills;
	}
	
	public Set<Labcase> getLabcases() {
		return this.labcases;
	}

	public void setLabcases(Set<Labcase> labcases) {
		this.labcases = labcases;
	}
	
}