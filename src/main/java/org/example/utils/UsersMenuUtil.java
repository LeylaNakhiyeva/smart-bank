package org.example.utils;

import org.example.enums.MenuEnumForUsers;

public class UsersMenuUtil {
    public static void showMenuForUsers(){
        for (MenuEnumForUsers menuEnumForUsers: MenuEnumForUsers.values()){
            System.out.println(menuEnumForUsers.getValue() +"."+menuEnumForUsers.getDescription());
        }
    }}
