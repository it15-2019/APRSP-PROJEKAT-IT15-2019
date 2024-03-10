package currencyexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepository repo;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ResponseEntity<?> getExchange(@PathVariable String from, @PathVariable String to) {

		String port = environment.getProperty("local.server.port");
		CurrencyExchange exchangeRate = repo.findByFromAndToIgnoreCase(from, to);

		if (exchangeRate != null) {

			exchangeRate.setEnvironment(port);

			return ResponseEntity.ok(exchangeRate);

		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Requested currency exchange could not be found!");
		}
	}
}