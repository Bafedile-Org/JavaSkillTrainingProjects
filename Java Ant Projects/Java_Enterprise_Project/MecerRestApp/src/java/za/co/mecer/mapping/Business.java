package za.co.mecer.mapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import za.co.mecer.model.Order;

/**
 *
 * @author Dimakatso Sebatane
 */
@Path("/order")
public class Business {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postOrder(Order order) {
        if (order == null) {
            return Response.status(500).entity("Order not found").build();
        }
        return Response.status(200).entity(order).build();
    }

    @GET
    @Path("/{orderid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderById(@PathParam("orderid") Integer orderid) {
        Order order = new Order();
        order.setItems("hammer");
        order.setName("Bob Builder");
        order.setOrderid(1);
        order.setTel("0987654321");
        return order;
    }

}
