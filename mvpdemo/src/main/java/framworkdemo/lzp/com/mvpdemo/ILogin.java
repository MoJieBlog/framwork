package framworkdemo.lzp.com.mvpdemo;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public interface ILogin {
    /**
     * 展示进度条，网络加载的动画
     */
    void showProgress();

    /**
     * 隐藏加载的动画
     */
    void hindProgress();

    /**
     * 用户名错误
     */
    void userNameErr();

    /**
     * 密码错误
     */
    void pwdErr();

    /**
     * 登录成功
     * @param user 用户信息
     */
    void loginSuccess(UserModel user);

    /**
     * 登录失败
     * @param desc 失败原因
     */
    void loginFail(String desc);

}
