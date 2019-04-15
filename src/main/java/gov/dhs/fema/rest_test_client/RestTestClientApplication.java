package gov.dhs.fema.rest_test_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import gov.dhs.fema.rest_test_client.clients.DemoRestEasyClient;

@SpringBootApplication
public class RestTestClientApplication {

	DemoRestEasyClient demoRestEasyClient;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RestTestClientApplication.class, args);
		DemoRestEasyClient demoRestEasyClient  = new DemoRestEasyClient();
		demoRestEasyClient.nasaExoPlanetApi();
	}

}
