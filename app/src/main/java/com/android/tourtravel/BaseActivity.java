package com.android.tourtravel;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.android.tourtravel.api.ApiService;
import com.android.tourtravel.db.UserPref;
import com.android.tourtravel.utills.Utils;

import javax.inject.Inject;

import dagger.android.AndroidInjection;


@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    @Inject
    public Utils utils;

    @Inject
    public UserPref userPref;

    @Inject
    public ApiService apiService;

    public ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    protected void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    //    fragmentTransaction.replace(R.id.frameContainer, fragment, fragment.getClass().getName()).commit();
    }

   /* protected void transitionTo(Intent i) {
        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(i, transitionActivityOptions.toBundle());
    }*/

    protected void showProgressDialog() {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(this, R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    protected void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
