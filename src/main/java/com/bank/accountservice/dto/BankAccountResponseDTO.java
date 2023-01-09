package com.bank.accountservice.dto;

import java.util.Date;

import com.bank.accountservice.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {

	private String id;
	private Date createdAt;
	private Double balance;
	private String currency;
	private AccountType type;
	
}
