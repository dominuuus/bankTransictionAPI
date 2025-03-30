package com.bank.Bank.Transiction.API.dto;

import com.bank.Bank.Transiction.API.domain.user.UserType;


public record UserDTO (String firstname, String lastName, String document, String email, String password, UserType userType, AccountDTO account, CardDTO card){

}
