package za.co.mecer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/message")
public class MieGreeting {

    @GET
    @Path("/greeting")
    public String helloMecerPeeps() {
        return "Welcome to MIE!!";
    }

    @GET
    @Path("/morning")
    public String morningGreeting() {
        return "Good Morning, It is happy FrIdAy!!!";
    }

    @GET
    @Path("/afternoon")
    public String afterNoonGreeting() {
        return "Afternoon, Hope you enjoyed your day!";
    }

    @GET
    @Path("/birthday")
    public Response happyBirthday() {
        String msg = "Yo Happy Birthday to you";
        return Response.status(200).entity(msg).build();
    }

    @POST
    @Path("/send/{msg}")
    public Response sendMsg(@PathParam("msg") String strMsg) {
        strMsg = String.format("Server received %s", strMsg);
        return Response.status(200).entity(strMsg).build();
    }

}
