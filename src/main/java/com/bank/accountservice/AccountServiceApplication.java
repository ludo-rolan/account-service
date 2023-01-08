package com.bank.accountservice;

import java.util.Date;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.enums.AccountType;
import com.bank.accountservice.repositories.BankAccountRepository;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository) {
		
		return args -> {
			for(int i=0; i<10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(10000 + Math.random() * 90000)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				
				bankAccountRepository.save(bankAccount);
			}
		};
		
	}

}
