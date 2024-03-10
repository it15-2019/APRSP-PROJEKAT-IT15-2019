package circuitBreaker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {
	
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	public static int counter = 0;

	@GetMapping("/sample/api")
	@CircuitBreaker(name="defaultCB", fallbackMethod = "defaultResponse")
	public String sample() {

		counter++;
		logger.info("Method called");

		String value = new RestTemplate().getForEntity("http://localhost:8080/fakeUrl", String.class).getBody();

		return value;
	}

	public String defaultResponse(Exception ex) {

		return "Service is currently not available";
	}
}
