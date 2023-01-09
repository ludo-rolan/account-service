package com.bank.accountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bank.accountservice.dto.BankAccountResponseDTO;
import com.bank.accountservice.entities.BankAccount;


@Component
public class AccountMapper {
	
	public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount)
	{
		BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
		BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
		
		return bankAccountResponseDTO;
	}

}
