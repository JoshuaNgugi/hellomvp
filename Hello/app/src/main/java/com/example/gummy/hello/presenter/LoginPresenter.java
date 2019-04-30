package com.example.gummy.hello.presenter;

import com.example.gummy.hello.model.User;
import com.example.gummy.hello.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValidData();

        if (loginCode == 0)
            loginView.onLoginResult("Enter an email address");
        else if (loginCode == 1)
            loginView.onLoginResult("Enter a valid email address");
        else if (loginCode == 2)
            loginView.onLoginResult("Password must be over 6 characters");
        else
            loginView.onLoginResult("Success");
    }
}
