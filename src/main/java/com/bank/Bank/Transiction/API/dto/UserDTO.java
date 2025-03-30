package com.bank.Bank.Transiction.API.dto;

import java.math.BigDecimal;

import com.bank.Bank.Transiction.API.domain.user.UserType;


public record UserDTO (String firstname, String lastName, String document, BigDecimal balance, String email, String password, UserType userType){

}
