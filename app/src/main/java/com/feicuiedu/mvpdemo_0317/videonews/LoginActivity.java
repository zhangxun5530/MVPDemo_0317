package com.feicuiedu.mvpdemo_0317.videonews;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.mvpdemo_0317.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/15 0015.
 */

public class LoginActivity extends AppCompatActivity{

    private Unbinder mUnbinder;

    @BindView(R.id.etUsername)
    EditText mEtUsername;
    @BindView(R.id.etPassword)
    EditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClick(){

        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        //用户名和密码不能为空
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            Toast.makeText(this, "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 2017/3/15 0015 登录的网络请求

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .get()
                .url("https://api.bmob.cn/1/login" + "?"
                        +"username=" + username + "&"
                        +"password=" + password)
                //用于让bomb服务器，区分是哪一个应用
                .addHeader("X-Bmob-Application-Id", "623aaef127882aed89b9faa348451da3")
                //用于授权
                .addHeader("X-Bmob-REST-API-Key", "c00104962a9b67916e8cbcb9157255de")
                //请求和响应统一使用json格式
                .addHeader("Content-Type","application/json")
                .build();
//        "https://api.bmob.cn/1/login?username=aaa&password=bbb"
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("okhttp","连接失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    Log.e("okhttp","登陆成功");
                }else{
                    Log.e("okhttp","登陆失败");
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
