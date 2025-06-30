package org.example.enums;

import lombok.Getter;
import org.example.strategy.*;
import org.example.strategy.adminStrategy.ActiveDeactiveStrategy;
import org.example.strategy.adminStrategy.SystemWideStatisticStrategy;
import org.example.strategy.adminStrategy.ViewAllAccountsOfUserStrategy;
import org.example.strategy.adminStrategy.ViewAllUsersStrategy;

import java.util.Arrays;

@Getter
public enum MenuEnumForAdmin {
    VIEW_ALL_USERS(1, "View all users", new ViewAllUsersStrategy()),
    ACTIVE_DEACTIVE_USERS(2, "Enable or disable", new ActiveDeactiveStrategy()),
    VIEW_ALL_ACCOUNTS_OF_A_USER(3, "View all account of a user", new ViewAllAccountsOfUserStrategy()),
    SYSTEM_WIDE_STATISTICS(4, "System wide statistic", new SystemWideStatisticStrategy());

    private final int value;
    private final String description;
    private final MenuStrategy strategy;

    MenuEnumForAdmin(int value, String description, MenuStrategy strategy){
        this.value = value;
        this.description = description;
        this.strategy = strategy;
    }

    public static MenuEnumForAdmin getEnumByValue(int option){
        return Arrays.stream(MenuEnumForAdmin.values())
                .filter(enumObject -> enumObject.getValue() == option)
                .findFirst()
                .orElse(null);
    }
}
