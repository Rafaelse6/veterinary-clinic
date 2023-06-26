package org.rafaelsantos.clients;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.rafaelsantos.dto.CustomerDTO;

@Path("/customers")
@RegisterRestClient
@ApplicationScoped
public interface CustomerClient {

    @GET
    @Path("/{id}")
    CustomerDTO getCustomerById(@PathParam("id")Long id);
}
