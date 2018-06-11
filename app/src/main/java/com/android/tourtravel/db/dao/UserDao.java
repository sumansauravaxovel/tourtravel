package com.android.tourtravel.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.android.tourtravel.request.request.UserModel;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by axovel18 on 1/2/18.
 */

@Dao
public interface UserDao {

    @Query("select * from user_table")
    LiveData<List<UserModel>> getAllUser();

    @Query("select * from user_table where email = :emailId")
    UserModel getItembyEmail(String emailId);

    @Insert(onConflict = REPLACE)
    Long addUser(UserModel userModel);

    @Delete
    void deleteUSer(UserModel userModel);
}
