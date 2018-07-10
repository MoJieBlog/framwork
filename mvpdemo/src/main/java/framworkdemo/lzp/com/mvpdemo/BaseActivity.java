package framworkdemo.lzp.com.mvpdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import framworkdemo.lzp.com.mvpdemo.preserter.IBasePresenter;

/**
 * Created by Li Xiaopeng on 18/7/10.
 */
public abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity{

    protected T basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        basePresenter = initPresenter();
        if (basePresenter!=null)basePresenter.onCreate();
    }

    @NonNull
    public abstract T initPresenter();

    public T getBasePresenter() {
        return basePresenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (basePresenter!=null)basePresenter.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (basePresenter!=null)basePresenter.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (basePresenter!=null)basePresenter.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (basePresenter!=null)basePresenter.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (basePresenter!=null)basePresenter.onDestroy(this.getClass().getSimpleName());
    }
}
