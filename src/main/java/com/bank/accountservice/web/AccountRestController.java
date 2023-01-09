package com.bank.accountservice.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.accountservice.dto.BankAccountRequestDTO;
import com.bank.accountservice.dto.BankAccountResponseDTO;
import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.mappers.AccountMapper;
import com.bank.accountservice.repositories.BankAccountRepository;
import com.bank.accountservice.service.AccountService;


@RestController
@RequestMapping("/api")
public class AccountRestController {
	
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountMapper accountMapper;
	

	public AccountRestController(BankAccountRepository bankAccountRepository) {
		super();
		this.bankAccountRepository = bankAccountRepository;
	}

	@GetMapping("/bankAccounts")
	public List<BankAccount> bankAccounts()
	{
		return bankAccountRepository.findAll();
	}
	
	@GetMapping("/bankAccounts/{id}")
	public BankAccount bankAccount(@PathVariable String id)
	{
		return bankAccountRepository.findById(id)
				.orElseThrow(
					() -> new RuntimeException(String.format("Account %s not found", id))
				);
	}
	
	@PostMapping("/bankAccounts")
	public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
		
		return accountService.addAccount(requestDTO);
		
	}
	
	@PutMapping("/bankAccounts/{id}")
	public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
		
		BankAccount account = bankAccountRepository.findById(id).orElseThrow();
		
		if(bankAccount.getBalance() != null)
			account.setBalance(bankAccount.getBalance());
		if(bankAccount.getCreatedAt() != null)
			account.setCreatedAt(new Date());
		if(bankAccount.getType() != null)
			account.setType(bankAccount.getType());
		if(bankAccount.getCurrency() != null)
			account.setCurrency(bankAccount.getCurrency());
		return bankAccountRepository.save(account);
		
	}
	
	@DeleteMapping("/bankAccounts/{id}")
	public void deleteAccount(@PathVariable String id)
	{
		bankAccountRepository.deleteById(id);
	}
}
