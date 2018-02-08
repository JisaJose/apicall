package com.example.stepintwosecond.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jisajose on 2018-02-07.
 */

public class UserAddress implements Parcelable {
    String street;
    String suite;
    String city;
    String zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.street);
        dest.writeString(this.suite);
        dest.writeString(this.city);
        dest.writeString(this.zipcode);
    }

    public UserAddress() {
    }

    protected UserAddress(Parcel in) {
        this.street = in.readString();
        this.suite = in.readString();
        this.city = in.readString();
        this.zipcode = in.readString();
    }

    public static final Parcelable.Creator<UserAddress> CREATOR = new Parcelable.Creator<UserAddress>() {
        @Override
        public UserAddress createFromParcel(Parcel source) {
            return new UserAddress(source);
        }

        @Override
        public UserAddress[] newArray(int size) {
            return new UserAddress[size];
        }
    };
}
