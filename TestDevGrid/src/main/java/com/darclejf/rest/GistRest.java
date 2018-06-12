package com.darclejf.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.darclejf.service.GitService;

import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Gist;

/**
 * @author DarcleJF
 * @version 1.00
 * 
 */
@Path("gist")
public class GistRest {

    @GET
    @Path("/{id}/comments")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getComments(@PathParam("id") String id) {
        GitService service = new GitService();
        return Response.ok().entity(service.getGistComments(id)).build();
    }

    @POST
    @Path("/create")
	@Produces({MediaType.APPLICATION_JSON})    
    public Response createGist() {
        GitService service = new GitService();        
        return Response.ok().entity(service.createGist()).build();
    }
}