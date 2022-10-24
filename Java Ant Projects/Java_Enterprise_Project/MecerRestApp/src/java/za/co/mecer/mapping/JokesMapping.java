package za.co.mecer.mapping;

import java.io.File;
import java.nio.file.Paths;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/joke")
public class JokesMapping {

    /**
     *
     * And Bridget Bapela today the 24 Oct 2022 said tee pedi nne{jumping tharo}
     *
     * @param category
     * @param jokeNum
     * @return
     */
    @GET
    @Path("/{cat}/{num: [0-9]+}")
    public Response getJoke(@PathParam("cat") String category, @PathParam("num") Integer jokeNum) {
        String ans = String.format("The joke for category %s and number %d is %s", category, jokeNum, "Is really hahahahaha");
        return Response.status(200).entity(ans).build();
    }

    @GET
    @Path("/query")
    public Response getQuery(@DefaultValue("mom") @QueryParam("cat") String category, @DefaultValue("77") @QueryParam("num") Integer num) {
        String ans = String.format("The joke queried for category %s and number %d is %s", category, num, "Is really hahahahaha");
        return Response.status(200).entity(ans).build();
    }

    @GET
    @Path("/hdr")
    public Response getHeader(@HeaderParam("user-agent") String userAgent, @HeaderParam("Accept") String agnt) {
        String ans = String.format("User agent: %s%n"
                + "Accept: %s%n", userAgent, agnt);
        return Response.status(200).entity(ans).build();
    }

    @POST
    @Path("/form")
    public Response registerForm(@FormParam("name") String name, @FormParam("tel") String tel) {
        String userInfo = String.format("Sucessfully added %s whose tel is %s", name, tel);
        return Response.status(200).entity(userInfo).build();
    }

    @GET
    @Path("/doc")
    public Response getDocument() {
        File file = Paths.get("C:\\Users\\TRAIN 08\\Documents\\MIE_J004\\Misc\\MIEtrainingScheduleAug2022_V2_J004.pdf").toFile();
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment;filename=\"MIEtrainingScheduleAug2022_V2_J004.pdf\"");
        return response.build();
    }

}
