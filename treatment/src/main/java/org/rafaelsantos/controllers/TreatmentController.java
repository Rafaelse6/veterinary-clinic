package org.rafaelsantos.controllers;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.rafaelsantos.dto.TreatmentDTO;
import org.rafaelsantos.services.TreatmentService;

import java.util.List;

@Path("/api/treatments")
public class TreatmentController {

    @Inject
    private TreatmentService treatmentService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TreatmentDTO> getAllTreatments(){
        return treatmentService.getAllTreatments();
    }

    @POST
    @Transactional
    public Response saveNewTreatment(TreatmentDTO treatment){
        try {
            treatmentService.saveNewTreatment(treatment);
            return Response.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
