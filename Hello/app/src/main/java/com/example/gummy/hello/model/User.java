package com.example.gummy.hello.model;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.gummy.hello.contract.MainContract;

/*
 * Model class to define how the data is structured
 */
public class User implements MainContract.Model {
    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {

        /*
         * 0. Check if email is empty
         * 1. Check email pattern
         * 2. Check password length > 6
         */
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return 3;
    }
}
