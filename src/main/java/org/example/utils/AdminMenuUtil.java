package org.example.utils;

import org.example.enums.MenuEnumForAdmin;

public class AdminMenuUtil {
    public static void showAdminMenu(){
        for (MenuEnumForAdmin menuEnumForAdmin: MenuEnumForAdmin.values()){
            System.out.println(menuEnumForAdmin.getValue()+"."+menuEnumForAdmin.getDescription());
        }
    }
}
