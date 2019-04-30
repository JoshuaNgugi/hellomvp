package com.example.gummy.hello.model;

/*
 * User Interface to define common behaviours of users
 * In this case the behaviours are get email, password and validate the data
 */
public interface IUser {
    String getEmail();
    String getPassword();
    int isValidData();
}
