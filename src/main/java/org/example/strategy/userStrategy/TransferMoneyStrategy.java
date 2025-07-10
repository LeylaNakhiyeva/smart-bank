package org.example.strategy.userStrategy;

import org.example.constant.exceptions.InsufficientBalanceException;
import org.example.constant.messages.ExceptionMessages;
import org.example.model.Bank;
import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferMoneyStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your card number: ");
        String yourCardNumber = sc.next();

        System.out.println("Enter to card number: ");
        String toCardNumber = sc.next();

        System.out.println("Write amount: ");
        BigDecimal amount = new BigDecimal(sc.next());


        Card yourCard = findCardByNumber(yourCardNumber);
        Card toCard = findCardByNumber(toCardNumber);

        if (yourCard != null && toCard != null) {
            if (amount.compareTo(yourCard.getBalance()) <= 0) {
                yourCard.setBalance(yourCard.getBalance().subtract(amount));
                toCard.setBalance(toCard.getBalance().add(amount));
                System.out.println("Transfer completed.");
            } else {
                throw new InsufficientBalanceException(ExceptionMessages.INSUFFICIENT_BALANCE_EXCEPTION);
            }
        } if (yourCard == null) {
            System.out.println("Your card not found.");
            return;
        }
        if (toCard == null) {
            System.out.println("Receiver card not found.");
            return;
        }

    }

    private Card findCardByNumber(String cardNumber) {
        return Bank.users.stream()
                .flatMap(user -> user.getCards().stream())
                .filter(card -> card.getCardNumber().equals(cardNumber))
                .findFirst()
                .orElse(null);
    }
}
