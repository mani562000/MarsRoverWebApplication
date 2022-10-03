package com.mars.rover.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mars.rover.api.response.MarsRoverApiResponse;

@SpringBootTest
class MarsRoverWebApplication1ApplicationTests {

	 @Test
	  public void smallTest () {
	    RestTemplate rt = new RestTemplate();
	    
	    ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=DEMO_KEY", MarsRoverApiResponse.class);
	    System.out.println(response.getBody());

}
}