package io.dev.ruben.random.api;

import io.dev.ruben.random.ejb.connector.RandomEjbConnector;
import org.jboss.logging.Logger;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.lang.String.format;

@Path("/random")
public class RandomApi {

    private static Logger log = Logger.getLogger(RandomApi.class);

    @GET
    @Path("/{length}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response randomString(@PathParam("length") String length) {
        RandomEjbConnector connector = new RandomEjbConnector();
        log.info("Carregou o conector");
        Response response;
        try {
            String randomString = connector.invoke(Integer.parseInt(length));
            log.info(format("Random String: %s",randomString));
            response = Response.ok().entity(randomString).build();
        } catch (NamingException e) {
            response = Response.serverError().build();
        }
        return response;
    }

}
