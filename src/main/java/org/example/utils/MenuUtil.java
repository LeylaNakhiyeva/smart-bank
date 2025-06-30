package org.example.utils;

import org.example.enums.MenuEnumForUsers;
import org.example.enums.AdminUserMenuEnum;

public class MenuUtil {
    public static void showFirstMenu(){
        for (AdminUserMenuEnum menuEnum: AdminUserMenuEnum.values()){
            System.out.println(menuEnum.getValue() +"."+menuEnum.getDescription());
        }
    }


}
