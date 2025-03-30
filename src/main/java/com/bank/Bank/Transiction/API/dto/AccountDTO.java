package com.bank.Bank.Transiction.API.dto;

import java.math.BigDecimal;

public record AccountDTO(String number, String agency, BigDecimal balance, BigDecimal limit) {

}
