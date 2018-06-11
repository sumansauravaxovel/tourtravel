package com.android.tourtravel.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import javax.inject.Singleton;


@Singleton
public class UserPref {
    private SharedPreferences preferences;
    private Gson gson;

    public UserPref(Context context) {
        preferences = context.getSharedPreferences("userPref", Context.MODE_PRIVATE);
        gson = new Gson();
    }

/*    public UserModel getUser() {
        return gson.fromJson(preferences.getString("user", null), UserModel.class);
    }

    public void setUser(UserModel user) {
        Gson gson = new Gson();
        String loginRes = gson.toJson(user);
        preferences.edit().putString("user", loginRes).apply();
    }*/

    public boolean isLogin() {
        return preferences.getBoolean("isLogin", false);
    }

    public void setLogin(boolean login) {
        preferences.edit().putBoolean("isLogin", login).apply();
    }

    public void clearPref() {
        preferences.edit().clear().apply();
    }

}