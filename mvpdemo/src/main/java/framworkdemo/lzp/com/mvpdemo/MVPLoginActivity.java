package framworkdemo.lzp.com.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import framworkdemo.lzp.com.mvpdemo.preserter.LoginPresenter;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class MVPLoginActivity extends AppCompatActivity implements ILogin {

    private LoginPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this);
        //点击开始登录哦，这里不在写点击事件
        presenter.login();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        //展示loadingView
    }

    @Override
    public void hindProgress() {
        //隐藏loadingView
    }

    @Override
    public void userNameErr() {
        //用户名错误是的UI效果
    }

    @Override
    public void pwdErr() {
        //密码错误的UI效果
    }

    @Override
    public void loginSuccess(UserModel user) {
        //登录成功的效果
    }

    @Override
    public void loginFail(String desc) {
        //登录失败的效果
    }
}
