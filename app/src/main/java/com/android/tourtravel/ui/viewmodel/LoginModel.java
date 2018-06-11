package com.android.tourtravel.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.tourtravel.db.AppDataBase;
import com.android.tourtravel.request.request.UserModel;

import java.util.List;


public class LoginModel extends AndroidViewModel {

    private AppDataBase appDataBase;
    private UserModel userModel;
    private LiveData<List<UserModel>>  userData;
    public LoginModel(@NonNull Application application) {
        super(application);
        appDataBase=AppDataBase.getAppDataBase(this.getApplication());
        userData=appDataBase.userDao().getAllUser();
    }

    public LiveData<List<UserModel>> getUserData()
    {
        return userData;
    }

    public void insertUser(UserModel userModel)
    {
        this.userModel=userModel;
        new insertAsyncTask().execute();
    }

    public UserModel selectUserByEmail(UserModel userModel)
    {
       return appDataBase.userDao().getItembyEmail(userModel.getEmail());
    }


    private class insertAsyncTask extends AsyncTask<Void, Void, Long> {

        @Override
        protected Long doInBackground(Void... voids) {
            return appDataBase.userDao().addUser(userModel);
        }

        @Override
        protected void onPostExecute(Long integer) {
            super.onPostExecute(integer);
            Log.e("Insert",integer+"");
        }
    }
}
