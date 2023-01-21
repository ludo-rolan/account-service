package com.bank.accountservice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.repositories.BankAccountRepository;

@Controller
public class BankAccountGraphQLController {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	
	@QueryMapping
	public List<BankAccount> accountsList()
	{
		return bankAccountRepository.findAll();
	}

}
