package co.jg.vlab.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.views.EntityView;

import java.util.Set;


/**
 * The persistent class for the place database table.
 * 
 */
@Entity
public class Place implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PLACE_ID_GENERATOR", sequenceName="SC_PLACE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PLACE_ID_GENERATOR")
	private Integer id;

	private String name;

	@Column(name="national_code")
	private String nationalCode;

	//bi-directional many-to-one association to Labcase
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="place")
	private Set<Labcase> labcases;

	//bi-directional many-to-one association to Place
    @ManyToOne
	@JoinColumn(name="placed_on")
	private Place place;

	//bi-directional many-to-one association to Place
    @JsonView(EntityView.Extended.class)
	@OneToMany(mappedBy="place")
	private Set<Place> places;

	//bi-directional many-to-one association to PlaceType
    @ManyToOne
	@JoinColumn(name="place_type")
	private PlaceType placeTypeBean;

    public Place() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationalCode() {
		return this.nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public Set<Labcase> getLabcases() {
		return this.labcases;
	}

	public void setLabcases(Set<Labcase> labcases) {
		this.labcases = labcases;
	}
	
	public Place getPlace() {
		return this.place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Set<Place> getPlaces() {
		return this.places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}
	
	public PlaceType getPlaceTypeBean() {
		return this.placeTypeBean;
	}

	public void setPlaceTypeBean(PlaceType placeTypeBean) {
		this.placeTypeBean = placeTypeBean;
	}
	
}