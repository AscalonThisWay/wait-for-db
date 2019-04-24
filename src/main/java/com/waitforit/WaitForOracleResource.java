package com.waitforit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/check")
public class WaitForOracleResource {

    @Inject
    WaitForOracleService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/oracle/{url}/{user}/{password}")
    public String greeting(@PathParam("url") String url, @PathParam("user") String user, @PathParam("password") String password) {
        return service.checkConnection(url, user, password);
    }

}
