package org.example.strategy.userStrategy;

import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.example.model.Bank;

public class ResetPasswordStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your password: ");
        String password = sc.next();

        Bank.users.stream().filter(user -> password.equals(user.getPassword()))
                .forEach(user -> {
                    System.out.println("Enter your new password: ");
                    String newPassword = sc.next();

                    user.setPassword(newPassword);
                    System.out.println("Password successfully updated!");
                });

//        if (password.isBlank()) {
//            System.out.println("Password cannot be empty!");
//            return;
//        }
//
//        Optional<User> user1 = Bank.users.stream()
//                .filter(user -> password.equals(user.getPassword()))
//                .findFirst();
//
//        if (user1.isPresent()) {
//            System.out.println("Enter your new password: ");
//            String newPassword = sc.next();
//
//            if (newPassword.isBlank()) {
//                System.out.println("New password cannot be empty!");
//                return;
//            }
//
//            user1.get().setPassword(newPassword);
//            System.out.println("Password successfully updated!");
//        } else {
//            System.out.println("Incorrect password!");
//        }
//
//         sc.close(); // Əgər başqa yerdə input lazım deyilsə, saxla
    }
}

