package com.bank.accountservice.dto;

import com.bank.accountservice.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {

	private Double balance;
	private String currency;
	private AccountType type;
	
}
