package com.lzp.framworkdemo.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lzp.framworkdemo.R;
import com.lzp.framworkdemo.databinding.ActivityMvvmBinding;

public class MVVMActivity extends AppCompatActivity {

    MVVMViewModel viewModel;
    ActivityMvvmBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        viewModel = new MVVMViewModel(binding);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }
}
