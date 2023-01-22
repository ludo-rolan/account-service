package com.bank.accountservice.service;

import com.bank.accountservice.dto.BankAccountRequestDTO;
import com.bank.accountservice.dto.BankAccountResponseDTO;

public interface AccountService {
	
	BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

	BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);

}
