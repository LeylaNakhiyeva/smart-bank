package org.example.enums;
import org.example.strategy.MenuStrategy;
import lombok.Getter;


import java.util.Arrays;

@Getter
public enum AdminUserMenuEnum {
    ADMIN(1, "Admin"),
    USER(2, "User");

    private final int value;
    private final String description;
    private MenuStrategy strategy;

    AdminUserMenuEnum(int value, String description){
        this.value = value;
        this.description = description;

    }

//    public int getValue() {
//        return value;
//    }
//
//    public String getDescription() {
//        return description;
//    }
    public static AdminUserMenuEnum getEnumByValue(int option){
        return Arrays.stream(AdminUserMenuEnum.values())
                .filter(enumObject -> enumObject.getValue() == option)
                .findFirst()
                .orElse(null);
    }

}
