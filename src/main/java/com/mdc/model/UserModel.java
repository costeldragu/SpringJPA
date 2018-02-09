package com.mdc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserModel {

    @Id
    @GeneratedValue
    private Long user_id;

    private String username;

    private String password;

}
