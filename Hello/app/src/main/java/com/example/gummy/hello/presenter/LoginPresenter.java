package com.example.gummy.hello.presenter;

import com.example.gummy.hello.contract.MainContract;
import com.example.gummy.hello.model.User;

public class LoginPresenter implements MainContract.Presenter {

    private MainContract.View mLoginView; // view

    // Set view in the constructor
    public LoginPresenter(MainContract.View mLoginView) {
        this.mLoginView = mLoginView;
    }

    // When button is pressed validate the data and return correct response
    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            mLoginView.onLoginResult("Enter an email address");
        else if (loginCode == 1)
            mLoginView.onLoginResult("Enter a valid email address");
        else if (loginCode == 2)
            mLoginView.onLoginResult("Password must be over 6 characters");
        else
            mLoginView.onLoginResult("Success");
    }
}
