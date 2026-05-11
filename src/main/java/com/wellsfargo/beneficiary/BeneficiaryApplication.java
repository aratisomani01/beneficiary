package com.wellsfargo.beneficiary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wellsfargo.beneficiary")
public class BeneficiaryApplication {

	public static void main(String[] args) {

        SpringApplication.run(BeneficiaryApplication.class, args);
	}

}
