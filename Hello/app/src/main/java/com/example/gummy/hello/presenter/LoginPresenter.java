package com.example.gummy.hello.presenter;

import com.example.gummy.hello.model.User;
import com.example.gummy.hello.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email,password);
        boolean isLogginSuccess = user.isValidData();

        if (isLogginSuccess)
            loginView.onLoginResult("Login Success");
        else
            loginView.onLoginResult("Login Failed");
    }
}
