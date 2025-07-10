package org.example.strategy.userStrategy;

import org.example.enums.AccountTypeEnum;
import org.example.model.Bank;
import org.example.model.Card;
import org.example.model.User;
import org.example.strategy.MenuStrategy;
import org.example.utils.AccountTypeUtil;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.random.RandomGenerator;

public class CreateAccountStrategy implements MenuStrategy {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String name = sc.next();
        if (name.isBlank()){
            System.out.println("Name cannot be empty!");
            return;
        }

        Bank.users.stream()
                .filter(user -> user.getName().equals(name))
                .forEach(user -> {
                    AccountTypeUtil.showAccountType();
                    System.out.println("Select account type: ");
                    int select = sc.nextInt();
                    AccountTypeEnum accountType = AccountTypeEnum.getEnumByValue(select);
                    String rawCard = String.format("%016d", Math.abs(UUID.randomUUID().getMostSignificantBits()));
                    String cardNumber = rawCard.substring(0, 16);

                    System.out.println("card number: "+ cardNumber);
                    BigDecimal balance = BigDecimal.ZERO;

                    Card card = new Card(cardNumber, balance, accountType);
                    user.getCards().add(card);
                });
    }
}
