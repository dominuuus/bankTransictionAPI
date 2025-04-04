package com.bank.Bank.Transiction.API.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Bank.Transiction.API.domain.user.User;
import com.bank.Bank.Transiction.API.domain.user.UserType;
import com.bank.Bank.Transiction.API.dto.UserDTO;
import com.bank.Bank.Transiction.API.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo Merchat não está autorizado a realizar esta transação");
        }

        if(sender.getAccount().getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }
    
    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }


    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public void saveUser(User user) {
        this.repository.save(user);
    }

}
