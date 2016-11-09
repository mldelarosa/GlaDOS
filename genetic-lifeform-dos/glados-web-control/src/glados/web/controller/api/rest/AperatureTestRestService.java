package glados.web.controller.api.rest;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import glados.controller.hardware.controller.HardwareControllerFactory;
import glados.controller.hardware.controller.HardwareControllerServiceInterface;

@Path("/test")
public class AperatureTestRestService {
	
	@POST
	@Path("/led/{pinId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setLedStatus(@PathParam("pinId") int pinId,
								@FormParam("setHighState") boolean setOn) {
		Response response = null;
		
		try {
			HardwareControllerFactory
					.getInstance()
					.getHardwareController()
					.getLedController(pinId)
					.setHigh(setOn);
		} catch(Exception ex) {
			response = Response.status(500).entity("Failed to set controller: " + HardwareControllerFactory.getInstance().getStatus()).build(); // + ex.toString()).build();
			return response;
		}		
		response = Response.status(200).entity(setOn).build();
		return response;
	}
	
	@POST
	@Path("/pwmLed/{pinId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setPwmLedStatus(@PathParam("pinId") int pinId,
								@FormParam("pwmHighStatePercentage") int pwmHighState) {
		Response response = null;
		HardwareControllerFactory.getInstance().getHardwareController().getPwmLedController(pinId).setPwmHighStatePercentage(pwmHighState);
		response = Response.status(200).entity(pwmHighState).build();
		return response;
	}
	
	@GET
	@Path("/live")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setPwmLedStatus() {
		Response response = null;
		response = Response.status(200).entity("Rest service is live").build();
		return response;
	}
}
