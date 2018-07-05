package com.lzp.framworkdemo.mvvm;

import android.databinding.ViewDataBinding;

/**
 * Created by Li Xiaopeng on 18/7/5.
 */
public abstract class BaseViewModel<T extends ViewDataBinding> implements IBaseViewModel {

    public T mViewDataBinding;

    public BaseViewModel(T viewDataBinding) {
        this.mViewDataBinding = viewDataBinding;
    }
}
