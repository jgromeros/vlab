package co.jg.vlab.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.jg.vlab.model.entity.Place;

@Stateless
@Path("/places")
public class PlaceService {

    @PersistenceContext(unitName = "vlabDS")
    private EntityManager em;

//    private Gson gson;

//    @GET
//    @Path("/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPlaces() {
//        System.out.println("Responding rest/places/all");
//        List<Place> places = (List<Place>) em.createQuery("from Place").getResultList();
//        Response resp = Response.status(200).entity(places).build();
//        return resp;
//    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPlaces() {
        System.out.println("Responding rest/places/all");
        return "{\"result\":\"Lugar 1\"}";
//        return gson.toJson(places);
    }

    @GET
    @Path("places/{idPlace}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPlace(@PathParam("idPlace") Integer idPlace) {
        Place place = em.find(Place.class, idPlace);
        Response resp = Response.status(200).entity(place).build();
        return resp;
    }

    @GET
    @Path("/allList")
    public List<Place> allList() {
        List<Place> places = (List<Place>) em.createQuery("from Place").getResultList();
        return places;
    }

}
