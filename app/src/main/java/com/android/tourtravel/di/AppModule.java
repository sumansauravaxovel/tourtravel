package com.android.tourtravel.di;

import android.content.Context;

import com.android.tourtravel.App;
import com.android.tourtravel.api.ApiService;
import com.android.tourtravel.db.UserPref;
import com.android.tourtravel.utills.Constants;
import com.android.tourtravel.utills.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
class AppModule {

    @Provides
    Context providesContext(App app) {
        return app.getApplicationContext();
    }

    @Provides
    Gson providesGson() {
        return new GsonBuilder().create();
    }

    @Provides
    OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor);

        return builder.build();
    }


    @Provides
    Retrofit providesRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        return builder.build();
    }

    @Provides
    ApiService providesApiServices(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    Utils providesUtils(Context context) {
        return new Utils(context);
    }

    @Provides
    UserPref provideUserPref(Context context)
    {
        return new UserPref(context);
    }
}