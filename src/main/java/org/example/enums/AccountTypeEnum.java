package org.example.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum AccountTypeEnum {
    SAVINGS(1, "Savings"),
    CHECKING(2, "Checking");

    private final int value;
    private final String description;

    AccountTypeEnum(int value, String description){
        this.value= value;
        this.description = description;
    }

    public static AccountTypeEnum getEnumByValue(int option){
        return Arrays.stream(AccountTypeEnum.values())
                .filter(enumObject -> enumObject.getValue() == option)
                .findFirst()
                .orElse(null);
    }
}
