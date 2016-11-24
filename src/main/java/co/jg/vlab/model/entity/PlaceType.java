package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

import java.util.Set;


/**
 * The persistent class for the place_type database table.
 * 
 */
@Entity
@Table(name="place_type")
public class PlaceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PLACE_TYPE_ID_GENERATOR", sequenceName="SC_PLACE_TYPE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLACE_TYPE_ID_GENERATOR")
	private Integer id;

	private String description;

	//bi-directional many-to-one association to Place
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="placeTypeBean")
	private Set<Place> places;

    public PlaceType() {
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

	public Set<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	
}