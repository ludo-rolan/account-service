package com.bank.accountservice;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.entities.Customer;
import com.bank.accountservice.enums.AccountType;
import com.bank.accountservice.repositories.BankAccountRepository;
import com.bank.accountservice.repositories.CustomerRepository;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
//		SpringApplication app = new SpringApplication(AccountServiceApplication.class);
//        app.setDefaultProperties(Collections
//          .singletonMap("server.port", "8083"));
//        app.run(args);
	}
	
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
		
		return args -> {
			
			Stream.of("Mohamed", "Yassine", "Hanae", "Imane").forEach(c -> {
				Customer customer = Customer.builder()
						.name(c)
						.build();
				
				customerRepository.save(customer);
			});
			
			customerRepository.findAll().forEach( customer -> {
				
				for (int i=0; i<10; i++) {
					BankAccount bankAccount = BankAccount.builder()
							.id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
							.balance(10000 + Math.random() * 90000)
							.createdAt(new Date())
							.currency("MAD")
							.customer(customer)
							.build();
					
					bankAccountRepository.save(bankAccount);
				}
				
			});
			
		};
		
	}

}
