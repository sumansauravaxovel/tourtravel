package com.android.tourtravel.request.request;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_table")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String name;
    private String image;
    private String phoneNo;
    private String email;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserModel(String name, String image, String phoneNo, String email) {
        this.name = name;
        this.image = image;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }
}
