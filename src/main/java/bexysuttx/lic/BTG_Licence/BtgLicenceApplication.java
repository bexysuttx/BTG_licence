package bexysuttx.lic.BTG_Licence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
public class BtgLicenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtgLicenceApplication.class, args);
	}

}
