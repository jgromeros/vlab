package co.jg.vlab.service.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonView;

import co.jg.vlab.model.entity.Labcase;
import co.jg.vlab.model.views.EntityView;
import co.jg.vlab.service.LabcaseService;

@Path("labcases")
public class LabcaseServiceREST {

    @Inject
    private LabcaseService labcaseService;

    @JsonView(EntityView.Regular.class)
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabcases() {
        List<Labcase> labcases = labcaseService.getLabcases();
        Response resp = Response.status(200).entity(labcases).build();
        return resp;
    }

    @GET
    @Path("/{idLabcase}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLabcase(@PathParam("idLabcase") Integer idLabcase) {
        Labcase labcase = labcaseService.getLabcase(idLabcase);
        Response resp = Response.status(200).entity(labcase).build();
        return resp;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response persistLabcase(Labcase labcase) {
        labcaseService.persistLabcase(labcase);
        Response resp = Response.status(200).entity(labcase).build();
        return resp;
    }

    @DELETE
    @Path("/{id}")
    public void removeLabcase(@PathParam("id") Integer id) {
        labcaseService.removeLabcase(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateLabcase(Labcase labcase) {
        labcaseService.updateLabcase(labcase);
    }

    @GET
    @Path("/code/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLabcaseByCode(@PathParam("code") String code) {
        List<Labcase> labcases = labcaseService.getLabcaseByCode(code);
        if (labcases.size() == 0){
            return null;
        } else {
            Response resp = Response.status(200).entity(labcases.get(0)).build();
            return resp;
        }
    }

}
