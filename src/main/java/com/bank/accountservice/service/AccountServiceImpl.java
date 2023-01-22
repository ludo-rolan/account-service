package com.bank.accountservice.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.accountservice.dto.BankAccountRequestDTO;
import com.bank.accountservice.dto.BankAccountResponseDTO;
import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.mappers.AccountMapper;
import com.bank.accountservice.repositories.BankAccountRepository;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
		// TODO Auto-generated method stub
		BankAccount bankAccount = BankAccount.builder()
				.id(UUID.randomUUID().toString())
				.createdAt(new Date())
				.balance(bankAccountDTO.getBalance())
				.type(bankAccountDTO.getType())
				.currency(bankAccountDTO.getCurrency())
				.build();
		
		BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
		
		BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
		
		return bankAccountResponseDTO;
	}
	
	@Override
	public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO) {
		// TODO Auto-generated method stub
		BankAccount bankAccount = BankAccount.builder()
				.id(id)
				.createdAt(new Date())
				.balance(bankAccountDTO.getBalance())
				.type(bankAccountDTO.getType())
				.currency(bankAccountDTO.getCurrency())
				.build();
		
		BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
		
		BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
		
		return bankAccountResponseDTO;
	}

}
