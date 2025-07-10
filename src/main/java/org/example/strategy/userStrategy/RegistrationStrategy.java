package org.example.strategy.userStrategy;

import org.example.constant.exceptions.UserAlreadyExistsException;
import org.example.constant.messages.ExceptionMessages;
import org.example.enums.StatusEnum;
import org.example.model.Bank;
import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.Scanner;

public class RegistrationStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please fill in the following fields.");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Surname: ");
        String surname = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Password: ");
        String password = sc.next();
        StatusEnum status = StatusEnum.ACTIVE;

        boolean exists = Bank.users.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));

        if (exists) {
            throw new UserAlreadyExistsException(ExceptionMessages.USER_ALREADY_EXISTS);
        }
        User user = new User(name, surname, email, password, status);

        Bank.users.add(user);
        System.out.println("User registered successfully!");
    }
}
