package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Card {
    private String cardNumber;
    private BigDecimal balance;
    private Transaction transaction;
}
