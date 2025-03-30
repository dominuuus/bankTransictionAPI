package com.bank.Bank.Transiction.API.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.Bank.Transiction.API.domain.transaction.Transactions;
import com.bank.Bank.Transiction.API.domain.user.User;
import com.bank.Bank.Transiction.API.dto.TransactionDTO;
import com.bank.Bank.Transiction.API.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transactions createTransaction(TransactionDTO transaction) throws Exception{
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.validateTransaction(sender, transaction.value());

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value());
        if(!isAuthorized) {
            throw new Exception("Transação não autorizada");
        }

        Transactions newTransaction = new Transactions();
        newTransaction.setAmount(transaction.value());
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newTransaction);
        this.userService.saveUser(sender);
        this.userService.saveUser(receiver);

        this.notificationService.sendNotification(sender, "Transferência realizada com sucesso");
        this.notificationService.sendNotification(receiver, "Transferência recebida");

        return newTransaction;

    }

    public boolean authorizeTransaction(User sender, BigDecimal value) {
        String urlMockTransfer = "https://util.devi.tools/api/v2/authorize";
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity(urlMockTransfer, Map.class);
        if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
            String message = (String) authorizationResponse.getBody().get("status");
            return "success".equalsIgnoreCase(message);
        } else return false;
    }

}
