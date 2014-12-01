package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the prices_by_test_desc database table.
 * 
 */
@Entity
@Table(name="prices_by_test_desc")
public class PricesByTestDesc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRICES_BY_TEST_DESC_ID_GENERATOR", sequenceName="SC_PRICES_BY_TEST_DESC")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRICES_BY_TEST_DESC_ID_GENERATOR")
	private Integer id;

	private BigDecimal price;

	private BigDecimal tax;

    @Temporal( TemporalType.DATE)
	@Column(name="valid_from")
	private Date validFrom;

    @Temporal( TemporalType.DATE)
	@Column(name="valid_until")
	private Date validUntil;

	//bi-directional many-to-one association to Profile
    @ManyToOne
	@JoinColumn(name="profile")
	private Profile profileBean;

	//bi-directional many-to-one association to TestDescription
    @ManyToOne
	@JoinColumn(name="test_description")
	private TestDescription testDescriptionBean;

    public PricesByTestDesc() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidUntil() {
		return this.validUntil;
	}

	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}

	public Profile getProfileBean() {
		return this.profileBean;
	}

	public void setProfileBean(Profile profileBean) {
		this.profileBean = profileBean;
	}
	
	public TestDescription getTestDescriptionBean() {
		return this.testDescriptionBean;
	}

	public void setTestDescriptionBean(TestDescription testDescriptionBean) {
		this.testDescriptionBean = testDescriptionBean;
	}
	
}