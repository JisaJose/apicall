package com.example.stepintwosecond.utils;

/**
 * Created by jisajose on 2018-01-31.
 */

public class Utils {
    /**
     * URL
     */
    public static final String URL_POST = "https://jsonplaceholder.typicode.com/users";
    /**
     * product table
     */
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public static final String TABLE_NAME_USER = "USERDETALS";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String USER_NAME = "username";
    public static final String EMAIL = "email";
    public static final String ADDRESS = "address";
    public static final String STREET = "street";
    public static final String SUITE = "suite";
    public static final String CITY = "CITY";
    public static final String ZIPCODE = "ZIPCODE";
    public static final String GEO = "GEO";
    public static final String LAT = "LAT";
    public static final String LNG = "LNG";
    public static final String PHONE = "phone";
    public static final String WEBSITE = "website";
    public static final String COMPANY = "company";
    public static final String COMPANY_NAME = "companyname";
    public static final String CATCHPHRASE = "catchPhrase";
    public static final String BS = "bs";
    /**
     * Versions
     */
    public static final int DATABASE_VERSION = 1;
    /**
     * QUERY
     */
    public static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME_USER + "(" + Utils.ID + " TEXT ,"
            + Utils.NAME + " TEXT ," + Utils.USER_NAME + " TEXT ," + Utils.EMAIL + " TEXT ," + Utils.ADDRESS + " TEXT ," + Utils.STREET + " TEXT ," +
            Utils.SUITE + " TEXT ," + Utils.CITY + " TEXT ," + Utils.ZIPCODE + " TEXT ,"  +
            Utils.LAT + " TEXT ," +Utils.LNG + " TEXT ," +  Utils.PHONE + " TEXT ," +Utils.WEBSITE + " TEXT ,"
            + Utils.COMPANY_NAME + " TEXT ," +Utils.CATCHPHRASE + " TEXT ," +   Utils.BS + " TEXT );";


}
