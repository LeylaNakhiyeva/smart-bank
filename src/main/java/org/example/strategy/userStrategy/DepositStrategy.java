package org.example.strategy.userStrategy;

import org.example.model.User;
import org.example.model.Bank;
import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class DepositStrategy implements MenuStrategy {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the card number: ");
        String cardNumber = sc.next();
        Card card = new Card();

        Bank.users.stream()
                .filter(user -> card.getCardNumber().equals(card))
                .forEach(user -> {
                    System.out.println("Write amount: ");
                    BigDecimal amount = new BigDecimal(sc.nextInt());
                    card.setBalance(card.getBalance().add(amount));
                    System.out.println("Succesfull");
                });

    }
}
