package com.feicuiedu.mvpdemo_0317.test;

/**
 * Created by gqq on 2017/3/17.
 */

import com.feicuiedu.mvpdemo_0317.net.BombClient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 1. View：Activity里面，我们需要获取数据，所以通过一个业务类实现
 * 2. Presneter：业务类里面，去执行业务拿到View需要的数据
 * 3. 拿到数据之后，数据要给视图View设置上
 */

// 业务操作，去拿到数据
public class MvpPresenter {

    // 去获取数据
    public void getData(){
        // 去进行数据请求
        // 如果我拿到了数据，是不是要返回给View，来进行展示

    }
}
