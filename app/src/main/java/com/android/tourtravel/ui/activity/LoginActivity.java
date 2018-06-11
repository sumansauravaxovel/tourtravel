package com.android.tourtravel.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.android.tourtravel.BaseActivity;
import com.android.tourtravel.R;
import com.android.tourtravel.databinding.ActivityLoginBinding;
import com.android.tourtravel.request.request.UserModel;
import com.android.tourtravel.ui.viewmodel.LoginModel;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {

    private ActivityLoginBinding loginBinding;
    private LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginModel= ViewModelProviders.of(this).get(LoginModel.class);
       // initializeValidation();
        setListeners();

    }


    private void setListeners() {
        loginBinding.btLogin.setOnClickListener(this);
        loginBinding.tvForgotPass.setOnClickListener(this);
        loginBinding.tvNewUser.setOnClickListener(this);
        loginBinding.etEmail.getEditText().addTextChangedListener(this);
        loginBinding.etPassword.getEditText().addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:

                UserModel userModel=new UserModel("Saurav","saurav.jpg","9555917543","email@gmail.com");
                UserModel userModel1=loginModel.selectUserByEmail(userModel);
                Log.e("user",userModel+"");
                break;
            case R.id.tvForgotPass:
                      break;
            case R.id.tvNewUser:
                break;
        }
    }



    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        loginBinding.etEmail.setErrorEnabled(false);
        loginBinding.etPassword.setErrorEnabled(false);
    }

}
