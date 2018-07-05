package framworkdemo.lzp.com.mvpdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import framworkdemo.lzp.com.mvpdemo.preserter.LoginPresenter;
import framworkdemo.lzp.com.net.NetUtils;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class MVPLoginActivity extends AppCompatActivity implements ILogin, View.OnClickListener {

    private static final String TAG = "MVPLoginActivity";

    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    private LoginPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        init();


    }

    private void init() {
        presenter = new LoginPresenter(this);

        etName = findViewById(R.id.et_name);
        etPwd = findViewById(R.id.et_pwd);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy(TAG);
    }

    @Override
    public void showProgress() {
        Log.e(TAG, "展示loadingView");
    }

    @Override
    public void hindProgress() {
        Log.e(TAG, "隐藏loadingView");
    }

    @Override
    public void userNameErr() {
        //用户名错误是的UI效果
        Log.e(TAG, "用户名错误是的UI效果");
    }

    @Override
    public void pwdErr() {
        //密码错误的UI效果
        Log.e(TAG, "密码错误的UI效果");
    }


    @Override
    public void loginSuccess(UserModel user) {
        //登录成功的效果
        Log.e(TAG, "登录成功的效果");
    }

    @Override
    public void loginFail(String desc) {
        //登录失败的效果
        Log.e(TAG, "登录失败的效果,失败原因：" + desc);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_login) {
            String name = etName.getText().toString().trim();
            String pwd = etPwd.getText().toString().trim();
            presenter.login(name,pwd);
        }
    }
}
