package com.bank.Bank.Transiction.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Bank.Transiction.API.domain.transaction.Transactions;
import com.bank.Bank.Transiction.API.dto.TransactionDTO;
import com.bank.Bank.Transiction.API.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    public TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody TransactionDTO transaction) throws Exception {
        Transactions newTransaction = this.transactionService.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
