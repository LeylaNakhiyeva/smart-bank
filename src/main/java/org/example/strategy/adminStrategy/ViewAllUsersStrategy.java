package org.example.strategy.adminStrategy;

import org.example.model.Admin;
import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.Scanner;

public class ViewAllUsersStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Login: ");
        System.out.println("Password: ");
        String password = sc.next();
        System.out.println("Name: ");
        String name = sc.next();
        System.out.println("Surname: ");
        String surname = sc.next();
        System.out.println("Email: ");
        String email = sc.next();
        Admin admin = new Admin(){};   //anonymous subclass -- abstract class fieldi cagirmaq ucun
        if (password.equals(admin.getPassword()) && name.equals(admin.getName()) && surname.equals(admin.getSurname()) && email.equals(admin.getEmail())){
            System.out.println("All users: ");
            for (User u : admin.getUserList()) {
                System.out.println("Name: " + u.getName());
                System.out.println("Surname: " + u.getSurname());
                System.out.println("Status: " + u.getStatus());
                System.out.println("------------------");
            }
        }else {
            System.out.println("wrong information");
        }
    }
}
