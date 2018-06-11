package com.android.tourtravel;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;


import com.android.tourtravel.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().application(this).build().inject(this);
      //  checkUpdate();
    }


    //TODO uncomment checkUpdate() for force to update apk

/*
    private void checkUpdate() {
        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        // set in-app defaults
        Map<String, Object> remoteConfigDefaults = new HashMap();
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_REQUIRED, false);
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_CURRENT_VERSION, "1.0.0");
        remoteConfigDefaults.put(ForceUpdateChecker.KEY_UPDATE_URL,
                "https://play.google.com/store/apps/details?id=com.sembozdemir.renstagram");

        firebaseRemoteConfig.setDefaults(remoteConfigDefaults);
        firebaseRemoteConfig.fetch(60) // fetch every minutes
                .addOnCompleteListener((OnCompleteListener<Void>) task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "remote config is fetched.");
                        firebaseRemoteConfig.activateFetched();
                    }
                });
    }
*/

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}
