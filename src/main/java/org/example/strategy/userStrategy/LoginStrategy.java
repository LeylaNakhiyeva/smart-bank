package org.example.strategy.userStrategy;

import org.example.constant.exceptions.InvalidCredentialsException;
import org.example.constant.exceptions.UserBlockedException;
import org.example.constant.messages.ExceptionMessages;
import org.example.enums.StatusEnum;
import org.example.model.Bank;
import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.Scanner;

public class LoginStrategy implements MenuStrategy {

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the email: ");
        String email = sc.next();
        System.out.println("Please enter the password: ");
        String password = sc.next();
        Bank.users.stream().forEach(user -> {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword()) && user.getStatus().equals(StatusEnum.ACTIVE)){
                System.out.println("Login is successful!");
            }
        else if (password!=user.getPassword()){
            throw new InvalidCredentialsException(ExceptionMessages.INVALID_CREDENTIALS_EXCEPTION);
        }
            else if (user.getStatus().equals(StatusEnum.INACTIVE)) {
                throw new UserBlockedException(ExceptionMessages.USER_BLOCKED_EXCEPTION);
            }
        });

    }
}
