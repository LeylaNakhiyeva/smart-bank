package org.example.strategy.userStrategy;

import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferMoneyStrategy implements MenuStrategy {
    private List<Card> cards = new ArrayList<>();
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your card number: ");
        String yourCardNumber = sc.next();

        System.out.println("Enter to card number: ");
        String toCardNumber = sc.next();

        System.out.println("Write amount: ");
        BigDecimal amount = new BigDecimal(sc.nextInt());


        Card yourCard = findCardByNumber(yourCardNumber);
        Card toCard = findCardByNumber(toCardNumber);

        if (yourCard != null && toCard != null) {
            if (amount.compareTo(yourCard.getBalance()) <= 0) {
                yourCard.setBalance(yourCard.getBalance().subtract(amount));
                toCard.setBalance(toCard.getBalance().add(amount));
                System.out.println("Transfer completed.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("One or both cards not found.");
        }
    }

    private Card findCardByNumber(String cardNumber) {
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }
}
