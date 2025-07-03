package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.AccountTypeEnum;

import java.math.BigDecimal;

@Getter
@Setter

public class Card {
    private String cardNumber;
    private BigDecimal balance;
    private Transaction transaction;
    private AccountTypeEnum accountType;
    private User user;

    public Card(String cardNumber, BigDecimal balance, AccountTypeEnum accountType){
        this.cardNumber= cardNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    public Card(){

    }
}
