package com.hj.test;

import android.app.Application;


public class App extends Application {

    private static boolean isLogin = false;

    private static int id = -1;//需要跳转的acitivity的id

    @Override
    public void onCreate() {
        super.onCreate();
        isLogin = false;
        id = -1;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static void setLogin(boolean islogin) {
        App.isLogin = islogin;
    }

    public static void setId(int id){
        App.id = id;
    }

    public static int getId(){
        return id;
    }
}
