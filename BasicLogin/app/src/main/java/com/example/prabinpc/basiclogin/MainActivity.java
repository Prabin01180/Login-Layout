package com.example.prabinpc.basiclogin;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private TextInputLayout mTilUsername;
    private TextInputLayout mTilPassword;
    private Button btn_Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTilUsername = findViewById(R.id.main_til_username);
        mTilPassword = findViewById(R.id.main_til_password);
        btn_Login = findViewById(R.id.main_btn_login);
        btn_Login.setEnabled(false);


        mTilUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MainActivity before", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MainActivity on", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                validateUser(s.toString());
            }
        });

        mTilPassword.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("MainActivity before", s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("MainActivity before", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                validatePassword(s.toString());

            }
        });
    }

    private void validateUser(String username) {
        if (TextUtils.isEmpty(username)) {
            mTilUsername.setError("Enter Valid Username");
        }
    }

    private void validatePassword(String password) {
        if (TextUtils.isEmpty(password)) {
            mTilPassword.setError("Enter Valid Password");
            btn_Login.setEnabled(false);
        } else {
            mTilPassword.setError(null);
            btn_Login.setEnabled(true);
        }
    }

}
