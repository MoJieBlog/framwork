package framworkdemo.lzp.com.mvpdemo.preserter;

import android.content.Context;
import android.util.Log;

import framworkdemo.lzp.com.mvpdemo.ILoginView;
import framworkdemo.lzp.com.mvpdemo.UserModel;
import framworkdemo.lzp.com.net.NetListener;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    private static final String TAG = "LoginPresenter";

    public LoginPresenter(ILoginView iBaseView) {
        super(iBaseView);
    }


    public void login(String name, String pwd) {
        iBaseView.showProgress();
        //发送网络请求
        NetUtils.getInstance().sendRequest(name, pwd, new NetListener() {
            @Override
            public void success(int status) {
                switch (status) {
                    //根据status,调整界面。这里假设0：登录成功 1:用户名错误  2：密码错误
                    case 0:
                        iBaseView.loginSuccess(new UserModel("张三","18"));
                        dosave();
                        turnToMain();
                        break;
                    case 1:
                        iBaseView.userNameErr();
                        break;
                    case 2:
                        iBaseView.pwdErr();
                        break;
                }
                iBaseView.hindProgress();
            }

            @Override
            public void fail(int status) {
                iBaseView.hindProgress();
                iBaseView.loginFail("登录失败的原因");
            }
        });

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
