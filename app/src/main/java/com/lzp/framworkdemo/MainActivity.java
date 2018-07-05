package com.lzp.framworkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lzp.framworkdemo.mvvm.MVVMActivity;

import framworkdemo.lzp.com.mvcdemo.MVCLoginActivity;
import framworkdemo.lzp.com.mvpdemo.MVPLoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_mvc).setOnClickListener(this);
        findViewById(R.id.btn_mvp).setOnClickListener(this);
        findViewById(R.id.btn_mvvm).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_mvc:
                intent = new Intent(this, MVCLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_mvp:
                intent = new Intent(this, MVPLoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_mvvm:
                intent = new Intent(this, MVVMActivity.class);
                startActivity(intent);
                break;
        }
    }
}
