package com.android.tourtravel.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.tourtravel.R;
import com.android.tourtravel.databinding.ActivityMainBinding;
import com.android.tourtravel.request.request.UserModel;
import com.android.tourtravel.ui.viewmodel.LoginModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private LoginModel mainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
           }
}