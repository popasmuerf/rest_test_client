instructional guides 
===============================
https://docs.jboss.org/resteasy/docs/3.0-beta-3/userguide/html/RESTEasy_Client_Framework.html
https://howtodoinjava.com/resteasy/jax-rs-2-0-resteasy-3-0-2-final-client-api-example/



Testing backend APIs 
=====================================
@GET
@Path("/users/{id}")
public User getUserById (@PathParam("id") Integer id)
{
    User user = new User();
    user.setId(id);
    user.setFirstName("demo");
    user.setLastName("user");
    return user;
}
 
@POST
@Path("/users")
public User addUser()
{
   //Some code
}