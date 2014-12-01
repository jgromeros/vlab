package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the result_factor database table.
 * 
 */
@Entity
@Table(name="result_factor")
public class ResultFactor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESULT_FACTOR_ID_GENERATOR", sequenceName="SC_RESULT_FACTOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESULT_FACTOR_ID_GENERATOR")
	private Integer id;

	@Column(name="_group")
	private String group;

	private Boolean calculated;

	@Column(name="computed_value")
	private Boolean computedValue;

	private String name;

	@Column(name="number_order")
	private Integer numberOrder;

	private String unit;

	@Column(name="value_type")
	private String valueType;

	//bi-directional many-to-one association to ReferenceValue
	@OneToMany(mappedBy="resultFactorBean")
	private Set<ReferenceValue> referenceValues;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="resultFactorBean")
	private Set<Result> results;

	//bi-directional many-to-one association to TestDescription
    @ManyToOne
	@JoinColumn(name="test_description")
	private TestDescription testDescriptionBean;

    public ResultFactor() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Boolean getCalculated() {
		return this.calculated;
	}

	public void setCalculated(Boolean calculated) {
		this.calculated = calculated;
	}

	public Boolean getComputedValue() {
		return this.computedValue;
	}

	public void setComputedValue(Boolean computedValue) {
		this.computedValue = computedValue;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOrder() {
		return this.numberOrder;
	}

	public void setNumberOrder(Integer numberOrder) {
		this.numberOrder = numberOrder;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public Set<ReferenceValue> getReferenceValues() {
		return this.referenceValues;
	}

	public void setReferenceValues(Set<ReferenceValue> referenceValues) {
		this.referenceValues = referenceValues;
	}
	
	public Set<Result> getResults() {
		return this.results;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}
	
	public TestDescription getTestDescriptionBean() {
		return this.testDescriptionBean;
	}

	public void setTestDescriptionBean(TestDescription testDescriptionBean) {
		this.testDescriptionBean = testDescriptionBean;
	}
	
}