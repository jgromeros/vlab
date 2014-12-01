package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the bill database table.
 * 
 */
@Entity
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BILL_ID_GENERATOR", sequenceName="SC_BILL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILL_ID_GENERATOR")
	private Integer id;

    @Temporal( TemporalType.DATE)
	@Column(name="bill_date")
	private Date billDate;

	@Column(name="bill_number")
	private Integer billNumber;

	private String status;

	@Column(name="total_after_taxes")
	private BigDecimal totalAfterTaxes;

	@Column(name="total_before_taxes")
	private BigDecimal totalBeforeTaxes;

	//bi-directional many-to-one association to Enterprise
    @ManyToOne
	@JoinColumn(name="client")
	private Enterprise enterprise;

	//bi-directional many-to-one association to BillDetail
	@OneToMany(mappedBy="billBean")
	private Set<BillDetail> billDetails;

    public Bill() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBillDate() {
		return this.billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Integer getBillNumber() {
		return this.billNumber;
	}

	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getTotalAfterTaxes() {
		return this.totalAfterTaxes;
	}

	public void setTotalAfterTaxes(BigDecimal totalAfterTaxes) {
		this.totalAfterTaxes = totalAfterTaxes;
	}

	public BigDecimal getTotalBeforeTaxes() {
		return this.totalBeforeTaxes;
	}

	public void setTotalBeforeTaxes(BigDecimal totalBeforeTaxes) {
		this.totalBeforeTaxes = totalBeforeTaxes;
	}

	public Enterprise getEnterprise() {
		return this.enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	public Set<BillDetail> getBillDetails() {
		return this.billDetails;
	}

	public void setBillDetails(Set<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}
	
}