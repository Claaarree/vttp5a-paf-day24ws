package vttp5a_paf.day24_25ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp5a_paf.day24_25ws.service.RegistrationService;
import vttp5a_paf.day24_25ws.utils.Constants;

@SpringBootApplication
public class Day2425wsApplication implements CommandLineRunner{

	@Autowired
	private RegistrationService registrationService;

	public static void main(String[] args) {
		SpringApplication.run(Day2425wsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length <= 0) {
			System.out.println("Please input customer name!");
			System.exit(1);
		}
		
		Constants.CUSTOMER_NAME = args[0];
		registrationService.addToRegistration(Constants.CUSTOMER_NAME);
	}

}
