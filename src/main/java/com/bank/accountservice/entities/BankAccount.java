package com.bank.accountservice.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private Double balance;
	private String currency;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	@ManyToOne
	private Customer customer;

}
