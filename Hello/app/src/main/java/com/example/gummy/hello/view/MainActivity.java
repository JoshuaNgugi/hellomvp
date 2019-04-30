package com.example.gummy.hello.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.hello.R;
import com.example.gummy.hello.contract.MainContract;
import com.example.gummy.hello.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private EditText mEtEmail;
    private EditText mEtPassword;
    private Button mBtLogin;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginPresenter = new LoginPresenter(this);

        mEtEmail = (EditText) findViewById(R.id.et_email);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtLogin = (Button) findViewById(R.id.bt_login);

        mBtLogin.setOnClickListener(new View.OnClickListener() {
            String email = mEtEmail.getText().toString();
            String password = mEtPassword.getText().toString();

            @Override
            public void onClick(android.view.View view) {
                mLoginPresenter.onLogin(email, password);
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
