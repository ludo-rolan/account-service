package com.bank.accountservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.bank.accountservice.entities.BankAccount;
import com.bank.accountservice.entities.Customer;
import com.bank.accountservice.enums.AccountType;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
