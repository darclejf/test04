package com.darclejf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.darclejf.models.ScoreInputModel;
import com.darclejf.service.GitService;
import com.darclejf.service.ScoreService;

/**
 * @author DarcleJF
 * @version 1.00
 * 
 */
@Path("score")
public class ScoreRest {

    @GET
    @Path("/{idGist}")
	@Produces({MediaType.APPLICATION_JSON})
    public Response getLastScoreBoard(@PathParam("idGist") String idGist) {
        GitService service = new GitService();
        return Response.ok().entity(service.getLastScoreContentFile(idGist)).build();
    }
    
    @POST
	@Produces({MediaType.APPLICATION_JSON})
    public Response save(ScoreInputModel input) {
        ScoreService service = new ScoreService();
        return Response.ok().entity(service.ReadInput(input)).build();
    }
}