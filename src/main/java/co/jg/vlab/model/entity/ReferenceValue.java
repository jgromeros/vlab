package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the reference_value database table.
 * 
 */
@Entity
@Table(name="reference_value")
public class ReferenceValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REFERENCE_VALUE_ID_GENERATOR", sequenceName="SC_REFERENCE_VALUE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REFERENCE_VALUE_ID_GENERATOR")
	private Integer id;

	private String description;

	@Column(name="max_abs_ref_value")
	private BigDecimal maxAbsRefValue;

	@Column(name="max_rel_ref_value")
	private BigDecimal maxRelRefValue;

	@Column(name="min_abs_ref_value")
	private BigDecimal minAbsRefValue;

	@Column(name="min_rel_ref_value")
	private BigDecimal minRelRefValue;

	private String unit;

	//bi-directional many-to-one association to ResultFactor
    @ManyToOne
	@JoinColumn(name="result_factor")
	private ResultFactor resultFactorBean;

	//bi-directional many-to-one association to Specie
    @ManyToOne
	@JoinColumn(name="specie")
	private Specie specieBean;

    public ReferenceValue() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMaxAbsRefValue() {
		return this.maxAbsRefValue;
	}

	public void setMaxAbsRefValue(BigDecimal maxAbsRefValue) {
		this.maxAbsRefValue = maxAbsRefValue;
	}

	public BigDecimal getMaxRelRefValue() {
		return this.maxRelRefValue;
	}

	public void setMaxRelRefValue(BigDecimal maxRelRefValue) {
		this.maxRelRefValue = maxRelRefValue;
	}

	public BigDecimal getMinAbsRefValue() {
		return this.minAbsRefValue;
	}

	public void setMinAbsRefValue(BigDecimal minAbsRefValue) {
		this.minAbsRefValue = minAbsRefValue;
	}

	public BigDecimal getMinRelRefValue() {
		return this.minRelRefValue;
	}

	public void setMinRelRefValue(BigDecimal minRelRefValue) {
		this.minRelRefValue = minRelRefValue;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public ResultFactor getResultFactorBean() {
		return this.resultFactorBean;
	}

	public void setResultFactorBean(ResultFactor resultFactorBean) {
		this.resultFactorBean = resultFactorBean;
	}
	
	public Specie getSpecieBean() {
		return this.specieBean;
	}

	public void setSpecieBean(Specie specieBean) {
		this.specieBean = specieBean;
	}
	
}