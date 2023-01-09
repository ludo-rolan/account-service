package com.bank.accountservice.service;

import com.bank.accountservice.dto.BankAccountRequestDTO;
import com.bank.accountservice.dto.BankAccountResponseDTO;

public interface AccountService {
	
	public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

}
