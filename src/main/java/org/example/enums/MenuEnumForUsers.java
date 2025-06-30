package org.example.enums;

import lombok.Getter;
import org.example.strategy.userStrategy.LoginStrategy;
import org.example.strategy.MenuStrategy;
import org.example.strategy.userStrategy.RegistrationStrategy;
import org.example.strategy.userStrategy.ResetPasswordStrategy;

import java.util.Arrays;

@Getter
public enum MenuEnumForUsers {
    REGISTRATION(1, "Registration", new RegistrationStrategy()),
    LOGIN(2, "Login", new LoginStrategy()),
    PASSWORD_RESET(3, "Reset password", new ResetPasswordStrategy());
//    CREATE_ACCOUNT,
//    DEPOSIT_MONEY,
//    WITHDRAW_MONEY,
//    TRANSFER_MONEY,
//    VIEW_TRANSACTION_HISTORY,
//    LOGOUT;

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
