package glados.web.controller.api.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/v1/rest/controller/core")
public class AperatureCoreRestService {
	
	@GET
	@Path("")
	public Response getAvailableCoreControllers() {
		ArrayList<String> availableCoreClassNames = new ArrayList<String>();
		// TODO: get all cores
		Response response = Response.status(200).entity(availableCoreClassNames).build();
		return response;
	}
	
	@GET
	@Path("/current")
	public Response getCurrentCoreController() {
		Response response = Response.status(200).build();
		// TODO: get current core in control
		return response;
	}
	
	@POST
	@Path("")
	public Response setCurrentCoreController() {
		return null;
	}

}