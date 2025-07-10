package org.example.enums;

import lombok.Getter;
import org.example.strategy.userStrategy.*;
import org.example.strategy.MenuStrategy;

import java.util.Arrays;

@Getter
public enum MenuEnumForUsers {
    REGISTRATION(1, "Registration", new RegistrationStrategy()),
    LOGIN(2, "Login", new LoginStrategy()),
    PASSWORD_RESET(3, "Reset password", new ResetPasswordStrategy()),
    CREATE_ACCOUNT(4, "Create account", new CreateAccountStrategy()),
    DEPOSIT_MONEY(5, "Deposit money", new DepositStrategy()),
    WITHDRAW_MONEY(6, "Withdraw money", new WithdrawMoneyStrategy()),
    TRANSFER_MONEY(7, "Transfer money", new TransferMoneyStrategy()),
//    VIEW_TRANSACTION_HISTORY,
    LOGOUT(9, "Logout", new LogoutStrategy());

    private final int value;
    private final String description;
    private final MenuStrategy strategy;

    MenuEnumForUsers(int value, String description, MenuStrategy strategy){
        this.value = value;
        this.description = description;
        this.strategy = strategy;
    }

    public static MenuEnumForUsers getEnumByValue(int option){
        return Arrays.stream(MenuEnumForUsers.values())
                .filter(enumObject -> enumObject.getValue() == option)
                .findFirst()
                .orElse(null);
    }
}
