package com.bank.accountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.accountservice.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
