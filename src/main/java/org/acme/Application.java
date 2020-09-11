package org.acme;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.service.LoadService;

@Path("/")
public class Application {

    @Inject
    LoadService service;

    @POST
    @Path("/init")
    public Response init(){
        return Response.ok().build();
    }

    @GET
    @Path("/health_check")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        return Response.ok().build();
    }

    @POST
    @Path("/run")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Message run() {
        service.readAllData();
        return new Message("Success");
    }
}