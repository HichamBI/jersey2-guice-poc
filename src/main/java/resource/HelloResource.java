/**
 Created by IntelliJ IDEA.
 Author: Hicham B.I.
 Date: 27/09/15
 Time: 15:46
 */

package resource;

import service.HelloService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloResource {

    @Inject
    private HelloService helloService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return helloService.hello("I am a Jersey2 restful service with Guice injection");
    }
}