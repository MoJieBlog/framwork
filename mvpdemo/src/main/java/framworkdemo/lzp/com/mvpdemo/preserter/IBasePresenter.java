package framworkdemo.lzp.com.mvpdemo.preserter;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public interface IBasePresenter {
    void onCreate();
    void onResume();
    void onStart();
    void onPause();
    void onRestart();
    void onDestroy(String tag);
}
