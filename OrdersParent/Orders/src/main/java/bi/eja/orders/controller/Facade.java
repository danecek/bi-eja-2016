package bi.eja.orders.controller;


import bi.eja.orders.data.CustomerDAO;
import bi.eja.orders.data.OrderDAO;
import bi.eja.orders.model.Order;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("orders")
@Produces(MediaType.APPLICATION_XML)
public class Facade {

    @Inject
    OrderDAO orderDAO;
    @Inject
    CustomerDAO customerDAO;
    private static final Logger LOG = Logger.getLogger(Facade.class.getName());

    @GET
    public Response get(@QueryParam("username") String username) {
        LOG.info(username);
        if (!customerDAO.contains(username)) {
            return Response.status(Status.UNAUTHORIZED).build();
        } else {
            List<Order> list = orderDAO.getOrdersByUsername(username);
            GenericEntity<List<Order>> entity = new GenericEntity<List<Order>>(list) {
            };
            return Response.ok(entity).build();
        }
    }

    @PUT
    public Response crateId() throws URISyntaxException {
        Order o = new Order();
        orderDAO.create(o);
        URI uri = new URI("orders/" + o.getId());
        return Response.created(uri).build();
    }

    @Path("{id}")
    public ItemSubresource item(@PathParam("id") int id) {
        return new ItemSubresource(orderDAO);
    }

}
