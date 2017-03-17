package com.feicuiedu.mvpdemo_0317;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.feicuiedu.mvpdemo_0317.videonews.LoginActivity;
import com.feicuiedu.mvpdemo_0317.videonews.RegisterActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btnLogin, R.id.btnRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.btnRegister:
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                break;
        }
    }
}
