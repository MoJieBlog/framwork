package framworkdemo.lzp.com.mvpdemo.preserter;

import android.util.Log;

/**
 * Created by Li Xiaopeng on 18/7/10.
 */
public abstract class BasePresenter implements IBasePresenter{
    private static final String TAG = "BasePresenter";
    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onRestart() {
        Log.e(TAG, "onRestart: ");
    }
}
