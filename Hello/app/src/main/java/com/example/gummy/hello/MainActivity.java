package com.example.gummy.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gummy.hello.presenter.ILoginPresenter;
import com.example.gummy.hello.presenter.LoginPresenter;
import com.example.gummy.hello.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText mEtEmail;
    EditText mEtPassword;
    Button mBtLogin;

    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtEmail = (EditText) findViewById(R.id.et_email);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtLogin = (Button) findViewById(R.id.bt_login);

        iLoginPresenter = new LoginPresenter(this);

        mBtLogin.setOnClickListener(new View.OnClickListener() {

            String email = mEtEmail.getText().toString();
            String password = mEtPassword.getText().toString();

            @Override
            public void onClick(View v) {
                iLoginPresenter.onLogin(email, password);
            }
        });
    }


    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
