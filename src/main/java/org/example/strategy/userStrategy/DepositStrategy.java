package org.example.strategy.userStrategy;

import org.example.User;
import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.Scanner;

public class DepositStrategy implements MenuStrategy {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the card number: ");
        String cardNumber = sc.next();
        Card card = new Card();
        if (cardNumber.equals(card.getCardNumber())){
            System.out.println("Write amount: ");
            BigDecimal amount = new BigDecimal(sc.nextInt());
            card.setBalance(card.getBalance().add(amount));
            System.out.println("Succesfull");
        }
    }
}
