package gov.dhs.fema.rest_test_client.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gov.dhs.fema.rest_test_client.model.Movie;

import java.util.List;


public interface ISimpleClient {
    @GET 
    @Path("basic")
    @Produces("text/plain")
    String getBasic() ;

    @PUT
    @Path("basic")
    @Consumes("text/plain")
    void putBasic(String body);

    @GET
    @Path("queryParam")
    @Produces("text/plain")
    String getQueryParam(@QueryParam("param")String param); 


    @GET
    @Path("uriParam/{param}")
    @Produces("text/plain")
    int getUriParam(@PathParam("param")int param);


}