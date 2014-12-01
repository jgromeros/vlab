package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the authorization_codes database table.
 * 
 */
@Entity
@Table(name="authorization_codes")
public class AuthorizationCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHORIZATION_CODES_ID_GENERATOR", sequenceName="SC_AUTHORIZATION_CODES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHORIZATION_CODES_ID_GENERATOR")
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="begin_date")
	private Date beginDate;

	private String code;

    @Temporal( TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	//bi-directional many-to-one association to ApplicationOwner
    @ManyToOne
	@JoinColumn(name="owner")
	private ApplicationOwner applicationOwner;

    public AuthorizationCode() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ApplicationOwner getApplicationOwner() {
		return this.applicationOwner;
	}

	public void setApplicationOwner(ApplicationOwner applicationOwner) {
		this.applicationOwner = applicationOwner;
	}
	
}