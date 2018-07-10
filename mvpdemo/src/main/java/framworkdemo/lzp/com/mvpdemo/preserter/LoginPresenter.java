package framworkdemo.lzp.com.mvpdemo.preserter;

import android.util.Log;

import framworkdemo.lzp.com.mvpdemo.ILogin;
import framworkdemo.lzp.com.mvpdemo.UserModel;
import framworkdemo.lzp.com.net.NetListener;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class LoginPresenter extends BasePresenter {

    private ILogin iLogin;
    private static final String TAG = "LoginPresenter";

    public LoginPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public void login(String name, String pwd) {
        iLogin.showProgress();
        //发送网络请求
        NetUtils.getInstance().sendRequest(name, pwd, new NetListener() {
            @Override
            public void success(int status) {
                switch (status) {
                    //根据status,调整界面。这里假设0：登录成功 1:用户名错误  2：密码错误
                    case 0:
                        iLogin.loginSuccess(new UserModel("张三","18"));
                        dosave();
                        turnToMain();
                        break;
                    case 1:
                        iLogin.userNameErr();
                        break;
                    case 2:
                        iLogin.pwdErr();
                        break;
                }
                iLogin.hindProgress();
            }

            @Override
            public void fail(int status) {
                iLogin.hindProgress();
                iLogin.loginFail("登录失败的原因");
            }
        });

    }

    public void refreshData(){
        //网络刷新请求
        iLogin.refreshSuccess();
    }

    private void dosave() {

    }

    private void turnToMain(){
        //
    }

    @Override
    public void onDestroy(String tag) {
        //页面销毁时用于取消网络请求，释放引用到的资源等操作
        Log.e(TAG, "onDestroy: ");
        NetUtils.getInstance().cancel(tag);
    }


}
