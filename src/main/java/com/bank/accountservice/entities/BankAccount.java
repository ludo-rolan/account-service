package com.bank.accountservice.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bank.accountservice.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
	
	@Id
	private String id;
	private Date createdAt;
	private double balance;
	private String currency;
	private AccountType type;

}
