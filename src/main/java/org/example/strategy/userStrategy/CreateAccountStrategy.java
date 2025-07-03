package org.example.strategy.userStrategy;

import org.example.enums.AccountTypeEnum;
import org.example.model.Card;
import org.example.model.User;
import org.example.strategy.MenuStrategy;
import org.example.utils.AccountTypeUtil;

import java.math.BigDecimal;
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
        User user = new User();
        if (name.equals(user.getName())){
            AccountTypeUtil.showAccountType();
            System.out.println("Select account type: ");
            int select = sc.nextInt();
            AccountTypeEnum accountType = AccountTypeEnum.getEnumByValue(select);
            String cardNumber = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
            System.out.println(cardNumber.substring(0, 16));

            BigDecimal balance = new BigDecimal(0);

            Card card = new Card(cardNumber, balance, accountType);

        }
    }
}
