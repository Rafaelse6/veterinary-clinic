package org.rafaelsantos.controllers;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.rafaelsantos.dto.AnimalDTO;
import org.rafaelsantos.services.AnimalService;

import java.util.List;

@Path(value = "/api/animals")
public class AnimalController {

    @Inject
    AnimalService animalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalDTO> findAllAnimals(){
        return animalService.findAllAnimals();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalDTO findAnimalById(@PathParam("id") Long id){
        return animalService.findAnimalById(id);
    }

    @POST
    @Transactional
    public Response saveAnimal(AnimalDTO animalDTO){
        try {
            animalService.createNewAnimal(animalDTO);
            return Response.ok().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateAnimal(@PathParam("id") Long id, AnimalDTO animalDTO) {
        try {
            animalService.updateAnimal(id, animalDTO);
            return Response.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteAnimal(@PathParam("id") Long id){
        try {
            animalService.deleteAnimal(id);
            return Response.accepted().build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }

    }
}
