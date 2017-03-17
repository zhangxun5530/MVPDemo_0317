package com.feicuiedu.mvpdemo_0317.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.feicuiedu.mvpdemo_0317.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MvpActivity extends AppCompatActivity {
    @BindView(R.id.listview)
    ListView mListview;
    @BindView(R.id.btnShow)
    Button mBtnShow;

    // 插件:Butterknife一个插件：下载插件：Android Butterknife zelezny
//    具体使用：点到布局上，点击alt+insert，弹出的弹窗选择绑定控件的操作就可以了。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnShow)
    public void onClick() {

        // 点击的时候，我们要去进行数据请求
        // 要将数据请求放置到业务中去执行
        new MvpPresenter().getData();
    }
}
