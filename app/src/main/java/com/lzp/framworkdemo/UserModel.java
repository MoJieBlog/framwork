package com.lzp.framworkdemo;

import android.databinding.BaseObservable;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class UserModel extends BaseObservable {

    private String name;
    private String age;

    public UserModel(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
