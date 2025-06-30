package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.StatusEnum;

@Getter
@Setter
public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private StatusEnum status;

    public User(String name, String surname, String email, String password, StatusEnum status){
        this.name= name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.status = status;
    }
    public User(){

    }
}
