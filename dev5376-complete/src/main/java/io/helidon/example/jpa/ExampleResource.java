package io.helidon.example.jpa;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Simple JAXRS resource class.
 */
@Dependent
@Path("/example")
public class ExampleResource {

    @PersistenceContext
    private EntityManager em;

    @Produces("text/plain")
    @Path("/")
    @GET
    public String get() {
        return "It works!";
    }

    @GET
    @Path("response/{salutation}")
    @Produces("text/plain")
    @Transactional
    public String getResponse(@PathParam("salutation") String salutation) {
        final Greeting greeting = this.em.find(Greeting.class, salutation);
        final String returnValue;
        if (greeting == null) {
            returnValue = null;
        } else {
            returnValue = greeting.getResponse();
        }
        return returnValue;
    }

}
