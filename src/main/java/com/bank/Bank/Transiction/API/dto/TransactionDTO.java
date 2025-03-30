package com.bank.Bank.Transiction.API.dto;

import java.math.BigDecimal;

public record TransactionDTO (BigDecimal value, Long senderId, Long receiverId) {

}
