package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sequential_numbers database table.
 * 
 */
@Entity
@Table(name="sequential_numbers")
public class SequentialNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQUENTIAL_NUMBERS_ID_GENERATOR", sequenceName="SC_SEQUENTIAL_NUMBERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENTIAL_NUMBERS_ID_GENERATOR")
	private Integer id;

	private String description;

	@Column(name="seq_number")
	private Integer seqNumber;

    public SequentialNumber() {
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

	public Integer getSeqNumber() {
		return this.seqNumber;
	}

	public void setSeqNumber(Integer seqNumber) {
		this.seqNumber = seqNumber;
	}

}