package org.example.strategy.userStrategy;

import org.example.strategy.MenuStrategy;

import javax.smartcardio.Card;
import java.util.Scanner;

public class ViewOperationHistoryStrategy implements MenuStrategy {
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the account number: ");
        String accountNo= sc.next();

    }
}
