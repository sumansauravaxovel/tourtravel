package com.android.tourtravel.di;


import com.android.tourtravel.ui.activity.LoginActivity;
import com.android.tourtravel.ui.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Binds all sub-components within the app.
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

}