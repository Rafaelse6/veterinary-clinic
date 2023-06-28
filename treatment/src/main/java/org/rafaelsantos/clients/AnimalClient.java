package org.rafaelsantos.clients;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rafaelsantos.dto.AnimalDTO;

@Path("/animals")
@RegisterRestClient
@ApplicationScoped
public interface AnimalClient {

    @GET
    @Path("/{id}")
    AnimalDTO getAnimalById(@PathParam("id")Long id);
}
