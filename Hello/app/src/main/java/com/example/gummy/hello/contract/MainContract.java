package com.example.gummy.hello.contract;

/*
 * This contract interface is used to bind everything together
 */
public interface MainContract {

    // Base interface for view
    interface View {
        void onLoginResult(String message);
    }

    // Base interface for Model
    interface Model {
        String getEmail();
        String getPassword();
        int isValidData();
    }

    // Base interface for model
    interface Presenter {
        void onLogin(String email, String password);
    }
}
