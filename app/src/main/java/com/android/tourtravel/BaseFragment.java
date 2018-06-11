package com.android.tourtravel;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


import com.android.tourtravel.api.ApiService;
import com.android.tourtravel.db.UserPref;
import com.android.tourtravel.utills.Utils;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class BaseFragment extends Fragment {

    @Inject
    public Utils utils;
    @Inject
    public UserPref userPref;
    @Inject
    public ApiService apiService;

    public ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    protected void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
       // fragmentTransaction.replace(R.id.frameContainer, fragment, fragment.getClass().getName()).commit();
    }


    public void showProgressDialog() {
        if (progressDialog == null)
            progressDialog = new ProgressDialog(getContext(), R.style.Theme_AppCompat_DayNight_Dialog_MinWidth);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        if (progressDialog != null && !progressDialog.isShowing())
            progressDialog.show();
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
