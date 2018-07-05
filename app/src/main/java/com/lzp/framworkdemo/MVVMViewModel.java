package com.lzp.framworkdemo;

import android.util.Log;
import android.view.View;

import com.lzp.framworkdemo.databinding.ActivityMvvmBinding;

import framworkdemo.lzp.com.mvpdemo.UserModel;
import framworkdemo.lzp.com.net.NetListener;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/5.
 */
public class MVVMViewModel extends BaseViewModel<ActivityMvvmBinding> {
    private static final String TAG = "MVVMViewModel";

    public MVVMViewModel(ActivityMvvmBinding viewDataBinding) {
        super(viewDataBinding);

        mViewDataBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(mViewDataBinding.etName.getText().toString().trim(), mViewDataBinding.etPwd.getText().toString().trim());
            }
        });
    }

    public void login(String name, String pwd) {
        showProgress();
        //发送网络请求
        NetUtils.getInstance().sendRequest(name, pwd, new NetListener() {
            @Override
            public void success(int status) {
                switch (status) {
                    //根据status,调整界面。这里假设0：登录成功 1:用户名错误  2：密码错误
                    case 0:
                        loginSuccess(new com.lzp.framworkdemo.UserModel("张三", "18"));
                        break;
                    case 1:
                        userNameErr();
                        break;
                    case 2:
                        pwdErr();
                        break;
                }
                hindProgress();
            }

            @Override
            public void fail(int status) {
                hindProgress();
                loginFail("登录失败的原因");
            }
        });
    }


    public void showProgress() {
        Log.e(TAG, "展示loadingView");
    }

    public void hindProgress() {
        Log.e(TAG, "隐藏loadingView");
    }

    public void userNameErr() {
        //用户名错误是的UI效果
        Log.e(TAG, "用户名错误是的UI效果");
    }

    public void pwdErr() {
        //密码错误的UI效果
        Log.e(TAG, "密码错误的UI效果");
    }

    public void loginSuccess(com.lzp.framworkdemo.UserModel user) {
        //登录成功的效果
        Log.e(TAG, "登录成功的效果");
        mViewDataBinding.setUser(user);
    }

    public void loginFail(String desc) {
        //登录失败的效果
        Log.e(TAG, "登录失败的效果,失败原因：" + desc);
    }


    @Override
    public void onDestroy() {
        mViewDataBinding.unbind();
        NetUtils.getInstance().cancel(TAG);
    }
}
