package com.example.stepintwosecond.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jisajose on 2018-02-07.
 */

public class UserGeo implements Parcelable {
    String lat;
    String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lat);
        dest.writeString(this.lng);
    }

    public UserGeo() {
    }

    protected UserGeo(Parcel in) {
        this.lat = in.readString();
        this.lng = in.readString();
    }

    public static final Parcelable.Creator<UserGeo> CREATOR = new Parcelable.Creator<UserGeo>() {
        @Override
        public UserGeo createFromParcel(Parcel source) {
            return new UserGeo(source);
        }

        @Override
        public UserGeo[] newArray(int size) {
            return new UserGeo[size];
        }
    };
}
