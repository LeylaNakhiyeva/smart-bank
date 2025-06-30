package org.example.strategy.userStrategy;

import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.Scanner;

public class ResetPasswordStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc =new Scanner(System.in);
        User user = new User();
        System.out.println("Enter your password: ");
        String password = sc.next();
        if (user.getPassword().equals(password)){
            System.out.println("Enter your new password: ");
            String newPassword = sc.next();
            user.setPassword(newPassword);
            System.out.println("Password successfully updated!");
        }
    }
}
