package org.example.strategy.userStrategy;

import org.example.enums.StatusEnum;
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
        User user = new User();
        if (email.equals(user.getEmail()) && password.equals(user.getPassword()) && user.getStatus().equals(StatusEnum.ACTIVE)){
            System.out.println("Login is successful!");
        }
        else if (!password.equals(user.getPassword())){
            System.out.println("InvalidCredentialsException");
        } else if (user.getStatus().equals(StatusEnum.INACTIVE)) {
            System.out.println("UserBlockedException");
        }
    }
}
