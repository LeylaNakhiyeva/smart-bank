package org.example.model;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Admin{
    private final String password = "Ad@1322";
    private final String name = "Leyla";
    private final String surname = "Nagiyeva";
    private final String email = "leylanagiyeva@gmail.com";
    private List<User> userList;
//    public List<User> getUsers() {
//        return userList;
//    }
}
