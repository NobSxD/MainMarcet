package com.example.MainMarcet.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserRepo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;
    private String userPassword;


    public UserRepo(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
}

