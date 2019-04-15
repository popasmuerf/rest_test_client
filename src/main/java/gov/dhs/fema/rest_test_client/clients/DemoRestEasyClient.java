package gov.dhs.fema.rest_test_client.clients;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import javax.ws.rs.client.Client;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Service;

//@Service
public class DemoRestEasyClient {
    public void nasaExoPlanetApi() throws Exception {
        //ClientRequest request = new ClientRequest("http://localhost:8888/foobar");

        //api-key = T9Wyq3iIcejBgXndcRPhzVnaID7pUWqJDrndfQoH
        //https://api.nasa.gov/planetary/earth/assets?lon=100.75&lat=1.5&begin=2014-02-01&api_key=DEMO_KEY
        //https://api.nasa.gov/planetary/earth/assets?lon=100.75&lat=1.5&begin=2014-02-01&api_key=T9Wyq3iIcejBgXndcRPhzVnaID7pUWqJDrndfQoH
         ClientRequest request = new ClientRequest("https://api.nasa.gov/planetary/earth/assets?lon=100.75&lat=1.5&begin=2014-02-01&api_key=T9Wyq3iIcejBgXndcRPhzVnaID7pUWqJDrndfQoH");
         request.accept("application/json");
         ClientResponse<String> response = request.get(String.class);

         if(response.getStatus()!=200){
             throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
         }

         
         BufferedReader br = new BufferedReader(new InputStreamReader(
			new ByteArrayInputStream(response.getEntity().getBytes())));

         String output ;
         while ((output = br.readLine()) != null) {
			//System.out.println(output);
        }
        System.out.println("FOOBAR : " + response.getEntity().toString());

    }
}