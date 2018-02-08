package com.example.stepintwosecond.model;

/**
 * Created by jisajose on 2018-02-07.
 */

public class UserDetails {
    public User user;
    public UserAddress userAddress;
    public UserGeo userGeo;
    public UserContacts userContacts;
    public UserCompany userCompany;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public UserGeo getUserGeo() {
        return userGeo;
    }

    public void setUserGeo(UserGeo userGeo) {
        this.userGeo = userGeo;
    }

    public UserContacts getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(UserContacts userContacts) {
        this.userContacts = userContacts;
    }

    public UserCompany getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(UserCompany userCompany) {
        this.userCompany = userCompany;
    }
}
