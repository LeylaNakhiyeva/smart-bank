package org.example.utils;

import org.example.enums.MenuEnumForAdmin;
import org.example.enums.MenuEnumForUsers;
import org.example.enums.AdminUserMenuEnum;
import org.example.model.Admin;

import java.util.Scanner;

public class MenuUtil {
    public static void showFirstMenu(){
        for (AdminUserMenuEnum menuEnum: AdminUserMenuEnum.values()){
            System.out.println(menuEnum.getValue() +"."+menuEnum.getDescription());
        }
    }

    public static void baseMenu(){
        Scanner sc = new Scanner(System.in);

        MenuUtil.showFirstMenu();
        System.out.println("Select one: ");
        int option = sc.nextInt();
        System.out.println();
        AdminUserMenuEnum menu = AdminUserMenuEnum.getEnumByValue(option);
        int choice;

        if (menu.equals(AdminUserMenuEnum.USER)) {
            while (true){
                UsersMenuUtil.showMenuForUsers();
                System.out.print("Select one: ");
                choice = sc.nextInt();
                MenuEnumForUsers menuEnumForUsers = MenuEnumForUsers.getEnumByValue(choice);

                menuEnumForUsers.getStrategy().execute();
                System.out.println();
            }

        } else {
            System.out.println("Enter your password: ");
            String password = sc.next();
            Admin admin = new Admin() {};
            if (password.equals(admin.getPassword())) {
                while (true){
                    AdminMenuUtil.showAdminMenu();
                    System.out.print("Select one: ");
                    choice = sc.nextInt();
                    MenuEnumForAdmin menuEnumForAdmin = MenuEnumForAdmin.getEnumByValue(choice);
                    menuEnumForAdmin.getStrategy().execute();
                    System.out.println();
                }

            }else {
                throw new RuntimeException("Password is incorrect!");
            }
        }
    }

}
