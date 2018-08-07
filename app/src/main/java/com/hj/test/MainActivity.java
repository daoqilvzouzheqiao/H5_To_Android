package com.hj.test;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!App.isLogin()){//没有登录就跳转到登录界面
            App.setId(123);//缓存需要跳转的页面,模拟id和OtherActivity对应
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }else{
            if(-1!=App.getId()){//登录成功后查看是否有需要跳转页面的缓存
                startActivity(new Intent(this,OtherActivity.class));
                App.setId(-1);//跳转到页面后，将缓存删掉
            }
        }

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Uri uri = getIntent().getData();
        if(uri!=null){
            String id = uri.getQueryParameter("id");
            startActivity(new Intent(this,OtherActivity.class));
            App.setId(-1);//跳转到页面后，将缓存删掉
        }

    }

    /**
     * 首页是singleTask的，在MainActivity已经初始化的情况下，h5跳转进入MainActivity会触发onNewIntent方法
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Uri uri = intent.getData();
        if(uri!=null){
            String id = uri.getQueryParameter("id");
            startActivity(new Intent(this,OtherActivity.class));
            App.setId(-1);//跳转到页面后，将缓存删掉
        }
    }

}
