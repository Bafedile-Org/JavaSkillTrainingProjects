package za.co.mecer.res;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import za.co.mecer.modelImpl.Client;
import za.co.mecer.serviceimpl.ClientServiceImpl;
import za.co.mecer.services.ClientService;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/app")
public class LibraryMapping {
    
    @GET
    public String greeting() {
        return "Hello There";
    }
    
    @GET
    @Path("/clients")
    public Response getClients() {
        StringBuilder sb = new StringBuilder();
        ClientService clientService = new ClientServiceImpl();
        List<Client> clients = clientService.getClients();
        clients.stream().forEach((client) -> sb.append(client).append("\n"));
        
        return Response.status(200).entity(sb.toString()).build();
    }
}
