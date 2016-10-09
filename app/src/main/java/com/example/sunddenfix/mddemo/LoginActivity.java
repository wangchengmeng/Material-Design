package com.example.sunddenfix.mddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout mTilUserName;
    private TextInputLayout mTilPassword;
    private EditText        mEdtUserName;
    private EditText        mEdtPassword;
    private Button          mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        //        initListener();
    }

    private void initViews() {
        mTilUserName = (TextInputLayout) findViewById(R.id.til_username);
        mTilPassword = (TextInputLayout) findViewById(R.id.til_password);

        mEdtUserName = (EditText) findViewById(R.id.edt_username);
        mEdtPassword = (EditText) findViewById(R.id.edt_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mEdtUserName.getText().toString())) {
                    mTilUserName.setErrorEnabled(true);
                    mTilUserName.setError("username is null");
                    return;
                }

                if (TextUtils.isEmpty(mEdtPassword.getText().toString())) {
                    mTilPassword.setErrorEnabled(true);
                    mTilPassword.setError("password is null");
                    return;
                }

                if (!"wangchengmeng".equals(mEdtUserName.getText().toString())) {
                    mTilUserName.setErrorEnabled(true);
                    mTilUserName.setError("username is error");
                    return;
                }

                if (!"123456".equals(mEdtPassword.getText().toString())) {
                    mTilPassword.setErrorEnabled(true);
                    mTilPassword.setError("password is error");
                    return;
                }

                //账户正确

                mTilUserName.setErrorEnabled(false);
                mTilPassword.setErrorEnabled(false);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
    }


    private void initListener() {
        mEdtUserName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    //当时去焦点的时候 判断是否为空  null 显示错误信息
                    if (TextUtils.isEmpty(mEdtUserName.getText().toString())) {
                        mTilUserName.setErrorEnabled(true);
                        mTilUserName.setError("username is null");
                    } else {
                        mTilUserName.setErrorEnabled(false);
                    }
                }
            }
        });
    }
}
