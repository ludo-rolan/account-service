package com.bank.accountservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bank.accountservice.dto.BankAccountRequestDTO;
import com.bank.accountservice.dto.BankAccountResponseDTO;
import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.entities.Customer;
import com.bank.accountservice.repositories.BankAccountRepository;
import com.bank.accountservice.repositories.CustomerRepository;
import com.bank.accountservice.service.AccountService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class BankAccountGraphQLController {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	CustomerRepository customerRepository;
	
	
	@QueryMapping
	public List<BankAccount> accountsList()
	{
		return bankAccountRepository.findAll();
	}
	
	@QueryMapping
	public BankAccount bankAccountById(@Argument String id)
	{
		return bankAccountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
	}
	
	@MutationMapping
	public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount)
	{
		return accountService.addAccount(bankAccount);
	}
	
	@MutationMapping
	public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount)
	{
		return accountService.updateAccount(id, bankAccount);
	}
	
	@MutationMapping
	public Boolean deleteAccount(@Argument String id)
	{
		bankAccountRepository.deleteById(id);
		return true;
	}
	
	@QueryMapping
	public List<Customer> customers ()
	{
		return customerRepository.findAll();
	}

}


//Équivalent à la définition de la classe BankAccountDTO ci-dessous
//record BankAccountDTO(Double balance, String type, String currency) {
//	
//}

// Équivalent à la définition du record BankAccountDTO ci-dessus
//@Data @NoArgsConstructor @AllArgsConstructor
//class BankAccountDTO {
//	private String type;
//	private Double balance;
//	private String currency;
//}