basic endpoint response testing.
Todo:
1. authentication testing against JWT
2. ????

versioning:
major.minor[.build[.revision]](example: 1.2.12.102)
1.0.1.0



JAX-RS 2.0 RESTEasy Final Client API example


Client API example for JAX-RS 2.0
-----------------------------------------
//code for specific JAX-RS 2.0 classes

Client client = ClientFactory.newClient() ;
WebTarget target = client.target("https://foobar.com") ;
Form form = new Form().param("userId","password")
		      .param("product","book") ;

Response resp = target.request().post(Entity.form(form)) ;
Order order = response.readEntity(Order.class); 


//Server Side code



@GET
@PATH("/users")
@Produces("application/vnd.com.demo.user-management.users+xml;charset=UTF-8;version=1")
public Users getAllUsers(){

    User user1 = new User();
    user1.setId(1);
    user1.setFirstName("demo");
    user1.setLastName("user");
    user1.setUri("/user-management/users/1");
 
    User user2 = new User();
    user2.setId(2);
    user2.setFirstName("Mark");
    user2.setLastName("Dwain");
    user2.setUri("/user-management/users/2");

    Users users = new Users();
    users.setUsers(new ArrayList<User>());
    users.getUsers().add(user1);
    users.getUsers().add(user2);
 
    return users;

}


@POST
@Path("/users")
@Consumes("application/vnd.com.demo.user-management.user+xml;charset=UTF-8;version=1")
public Response createUser(User user,
        @DefaultValue("false") @QueryParam("allow-admin") boolean allowAdmin)
        throws URISyntaxException {
    System.out.println(user.getFirstName());
    System.out.println(user.getLastName());
    return Response.status(201)
            .contentLocation(new URI("/user-management/users/123")).build();
}



//RESTEasy(version 3.x) build lower level JAX-RS 2.0
//from RESTEasy abstraction provided by it's client API



import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
 
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
 
import com.demo.rest.model.User;
import com.demo.rest.model.Users;


public class Demo_JAXRS_2_Example{
	public static void main(String[] args){
		getExample_one() ;
		getExample_two() ;
		getExample_three() ;
	}


	private static void getExample_one(){
		ResteasyClient client = new RestEasyClientBuilder().build() ;
		ResteasyWebTarget target = client.target("http://localhost:8080/RESTEasyApplication/user-management/users");
		Response response = target.request().get() ;
		String value = response.readEntity(String.class) ;
		System.out.println(value) ;
		response.close() ;
	}

	private static void getExample_two(){
		ResteasyClient client = new RestEasyClientBuilder().build() ;
		ResteasyWebTarget target = client.target("http://localhost:8080/RESTEasyApplication/user-management/users");
		Response response = target.request().get() ;
		Users users = response.readEntity(Users.class) ;
		for(User user : users.getUsers()){
			System.out.println(user.getId()) ;
			System.out.println(user.getLastName()) ;
		}		

	}

	private static void getExample_three(){

	}

}
 



