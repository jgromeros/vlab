package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the bill_detail database table.
 * 
 */
@Entity
@Table(name="bill_detail")
public class BillDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BILL_DETAIL_ID_GENERATOR", sequenceName="SC_BILL_DETAIL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILL_DETAIL_ID_GENERATOR")
	private Integer id;

	private BigDecimal price;

	private BigDecimal tax;

	@Column(name="test_profile")
	private Integer testProfile;

	//bi-directional many-to-one association to Bill
    @ManyToOne
	@JoinColumn(name="bill")
	private Bill billBean;

	//bi-directional many-to-one association to Test
    @ManyToOne
	@JoinColumn(name="test")
	private Test testBean;

    public BillDetail() {
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

	public Integer getTestProfile() {
		return this.testProfile;
	}

	public void setTestProfile(Integer testProfile) {
		this.testProfile = testProfile;
	}

	public Bill getBillBean() {
		return this.billBean;
	}

	public void setBillBean(Bill billBean) {
		this.billBean = billBean;
	}
	
	public Test getTestBean() {
		return this.testBean;
	}

	public void setTestBean(Test testBean) {
		this.testBean = testBean;
	}
	
}