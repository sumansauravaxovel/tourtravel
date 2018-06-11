package com.android.tourtravel.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.android.tourtravel.db.dao.UserDao;
import com.android.tourtravel.request.request.UserModel;

@Database(entities = {UserModel.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase appDataBase;

    public static AppDataBase getAppDataBase(Context context)
    {
        if(appDataBase==null)
            appDataBase= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"TourTravel.db").build();
        return appDataBase;
    }

    public abstract UserDao userDao();

}