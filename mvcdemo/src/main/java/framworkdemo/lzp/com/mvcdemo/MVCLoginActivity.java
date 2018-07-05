package framworkdemo.lzp.com.mvcdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import framworkdemo.lzp.com.net.NetListener;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class MVCLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MVCLoginActivity";

    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etName = findViewById(R.id.et_name);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    private void doLogin() {
        showProgress();
        String name = etName.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        NetUtils.getInstance().sendRequest(name, pwd, new NetListener() {
            @Override
            public void success(int status) {
                switch (status) {
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
                loginFail("网络请求失败");
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        NetUtils.getInstance().cancel(TAG);
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

    public void loginSuccess(UserModel user) {
        //登录成功的效果
        Log.e(TAG, "登录成功的效果");
    }

    public void loginFail(String desc) {
        //登录失败的效果
        Log.e(TAG, "登录失败的效果,失败原因：" + desc);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_login) {
            doLogin();
        }
    }
}
