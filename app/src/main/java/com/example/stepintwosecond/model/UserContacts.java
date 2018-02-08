package com.example.stepintwosecond.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jisajose on 2018-02-07.
 */

public class UserContacts implements Parcelable {
    String phone;
    String website;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
        dest.writeString(this.website);
    }

    public UserContacts() {
    }

    protected UserContacts(Parcel in) {
        this.phone = in.readString();
        this.website = in.readString();
    }

    public static final Parcelable.Creator<UserContacts> CREATOR = new Parcelable.Creator<UserContacts>() {
        @Override
        public UserContacts createFromParcel(Parcel source) {
            return new UserContacts(source);
        }

        @Override
        public UserContacts[] newArray(int size) {
            return new UserContacts[size];
        }
    };
}
