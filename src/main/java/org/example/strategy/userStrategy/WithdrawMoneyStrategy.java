package org.example.strategy.userStrategy;

import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.Scanner;

public class WithdrawMoneyStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter card number: ");
        String cardNumber = sc.next();
        Card card = new Card();
        if (cardNumber.equals(card.getCardNumber())){
            System.out.println("Write amount: ");
            BigDecimal amount = new BigDecimal(sc.nextBigInteger());
            if (amount.compareTo(card.getBalance())<0){
                card.setBalance(card.getBalance().subtract(amount));
                System.out.println("Succesfull withdraw!");
            }
        }
    }
}
