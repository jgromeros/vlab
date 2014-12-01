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

import co.jg.vlab.model.entity.Labcase;

@Stateless
@Path("soat")
public class LabcaseService {

    @PersistenceContext(unitName="vlabDS")
    private EntityManager em;

    @GET
    @Path("labcases")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabcases() {
        List<Labcase> labcases = (List<Labcase>) em.createQuery("from Labcase").getResultList();
        Response resp = Response.status(200).entity(labcases).build();
        return resp;
    }

    @GET
    @Path("labcases/{idLabcase}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLabcase(@PathParam("idLabcase") Integer idLabcase) {
        Labcase labcase = em.find(Labcase.class, idLabcase);
        Response resp = Response.status(200).entity(labcase).build();
        return resp;
    }

}
