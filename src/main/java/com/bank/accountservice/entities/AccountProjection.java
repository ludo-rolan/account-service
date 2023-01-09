package com.bank.accountservice.entities;

import org.springframework.data.rest.core.config.Projection;

import com.bank.accountservice.enums.AccountType;

@Projection(types = BankAccount.class, name = "p1")
public interface AccountProjection {
	
	public String getId();
	public AccountType getType();
	public Double getBalance();

}
