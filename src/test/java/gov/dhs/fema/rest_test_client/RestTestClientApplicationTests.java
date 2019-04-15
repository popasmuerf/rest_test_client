package gov.dhs.fema.rest_test_client;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RestTestClientApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testNasaExoPlanetApi() throws Exception {
		ClientRequest request = new ClientRequest("https://api.nasa.gov/planetary/earth/assets?lon=100.75&lat=1.5&begin=2014-02-01&api_key=T9Wyq3iIcejBgXndcRPhzVnaID7pUWqJDrndfQoH");
         request.accept("application/json");
         ClientResponse<String> response = request.get(String.class);

		 /*
         if(response.getStatus()!=200){
             throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		 }
		 */
		 assertTrue(response.getStatus()==200);
	}

	private void assertArrayEquals(int status, int i) {
	}

	

}
