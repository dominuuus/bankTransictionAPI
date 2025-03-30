package com.bank.Bank.Transiction.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Bank.Transiction.API.domain.transaction.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long>{

}
