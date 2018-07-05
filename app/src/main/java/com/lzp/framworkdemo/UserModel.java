package com.lzp.framworkdemo;

import android.databinding.BaseObservable;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class UserModel extends BaseObservable{

    public final String name;
    public final String age;

    public UserModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
    /*

    public void setName(String name) {
        this.name = name;
    }



    public void setAge(String age) {
        this.age = age;
    }*/
}
