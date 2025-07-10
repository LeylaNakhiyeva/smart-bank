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
        Optional<Card> card = Bank.users.stream()
                .flatMap(user -> user.getCards().stream()) // bütün istifadəçilərin kartlarını götür
                .filter(c -> c.getCardNumber().equals(cardNumber)) // uyğun kartı tap
                .findFirst();


        if (card.isPresent()){
            System.out.println("Write amount: ");
            BigDecimal amount = new BigDecimal(sc.nextInt());
            card.get().setBalance(card.get().getBalance().add(amount));
            System.out.println("Succesfull");
        }
        else {
            System.out.println("Card not found.");
        }
    }
}
