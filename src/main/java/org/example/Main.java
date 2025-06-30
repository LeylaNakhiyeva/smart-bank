package org.example;


import org.example.enums.AdminUserMenuEnum;
import org.example.enums.MenuEnumForAdmin;
import org.example.enums.MenuEnumForUsers;
import org.example.model.Admin;
import org.example.utils.AdminMenuUtil;
import org.example.utils.MenuUtil;
import org.example.utils.UsersMenuUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            MenuUtil.showFirstMenu();
            System.out.println("Select one: ");
            int option = sc.nextInt();
            AdminUserMenuEnum menu = AdminUserMenuEnum.getEnumByValue(option);
            int choice;

            if (menu.equals(AdminUserMenuEnum.USER)){
                UsersMenuUtil.showMenuForUsers();
                System.out.print("Select one: ");
                choice = sc.nextInt();
                MenuEnumForUsers menuEnumForUsers = MenuEnumForUsers.getEnumByValue(choice);

                menuEnumForUsers.getStrategy().execute();
                System.out.println();
            }
            else {
                    AdminMenuUtil.showAdminMenu();
                    System.out.print("Select one: ");
                    choice = sc.nextInt();
                    MenuEnumForAdmin menuEnumForAdmin = MenuEnumForAdmin.getEnumByValue(choice);
                    menuEnumForAdmin.getStrategy().execute();
                    System.out.println();
                }

            }





    }
