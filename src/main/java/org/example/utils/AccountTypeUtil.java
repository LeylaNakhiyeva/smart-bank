package org.example.utils;

import org.example.enums.AccountTypeEnum;

public class AccountTypeUtil {
    public  static  void showAccountType(){
        for (AccountTypeEnum accountTypeEnum: AccountTypeEnum.values()){
            System.out.println(accountTypeEnum.getValue()+"."+accountTypeEnum.getDescription());
        }
    }
}
