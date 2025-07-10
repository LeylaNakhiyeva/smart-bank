package org.example.strategy.userStrategy;

import org.example.constant.exceptions.InsufficientBalanceException;
import org.example.constant.messages.ExceptionMessages;
import org.example.model.Bank;
import org.example.model.Card;
import org.example.strategy.MenuStrategy;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class WithdrawMoneyStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter card number: ");
        String cardNumber = sc.next();

        Optional<Card> card = Bank.users.stream()
                .flatMap(user -> user.getCards().stream()) // bütün istifadəçilərin kartlarını götür
                .filter(c -> c.getCardNumber().equals(cardNumber)) // uyğun kartı tap
                .findFirst();

        if (cardNumber.equals(card.get().getCardNumber())){
            System.out.println("Write amount: ");
            BigDecimal amount = new BigDecimal(sc.nextBigInteger());
            if (amount.compareTo(card.get().getBalance())<=0){
                card.get().setBalance(card.get().getBalance().subtract(amount));
                System.out.println("Succesfull withdraw!");
            }
            else throw new InsufficientBalanceException(ExceptionMessages.INSUFFICIENT_BALANCE_EXCEPTION);
        }
    }
}
