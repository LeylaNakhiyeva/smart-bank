package org.example.strategy.adminStrategy;

import org.example.enums.StatusEnum;
import org.example.model.User;
import org.example.strategy.MenuStrategy;

import java.util.Scanner;

public class ActiveDeactiveStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user name: ");
        String name = sc.next();
        User user = new User();
        if (user.getName().equals(name)){
            if (user.getStatus().equals(StatusEnum.ACTIVE)){
                user.setStatus(StatusEnum.INACTIVE);
            }else {
                user.setStatus(StatusEnum.ACTIVE);
            }
        }
    }
}
