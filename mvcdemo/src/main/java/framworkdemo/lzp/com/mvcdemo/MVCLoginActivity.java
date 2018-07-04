package framworkdemo.lzp.com.mvcdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import framworkdemo.lzp.com.net.NetListener;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class MVCLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //点击开始登录哦，这里不在写点击事件
       doLogin();
    }

    private void doLogin() {
        showProgress();
        NetUtils.getInstance().sendRequest(new NetListener() {
            @Override
            public void success(int status) {
                switch (status){
                    //根据status,调整界面。这里假设0：登录成功 1:用户名错误  2：密码错误
                    case 0:
                        loginSuccess(new UserModel());
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

    protected void onDestroy() {
        super.onDestroy();
        NetUtils.getInstance().cancel("TAG");
    }

    public void showProgress() {
        //展示loadingView
    }

    public void hindProgress() {
        //隐藏loadingView
    }

    public void userNameErr() {
        //用户名错误是的UI效果
    }

    public void pwdErr() {
        //密码错误的UI效果
    }

    public void loginSuccess(UserModel user) {
        //登录成功的效果
    }

    public void loginFail(String desc) {
        //登录失败的效果
    }
}
