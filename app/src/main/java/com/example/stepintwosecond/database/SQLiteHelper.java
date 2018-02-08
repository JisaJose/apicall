package com.example.stepintwosecond.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.stepintwosecond.model.UserDetails;
import com.example.stepintwosecond.utils.Utils;

import java.util.ArrayList;

import static com.example.stepintwosecond.utils.Utils.TABLE_NAME_USER;

/**
 * Created by jisajose on 2018-02-07.
 */

public class SQLiteHelper extends SQLiteOpenHelper{
    private  static  SQLiteHelper instance;
    private SQLiteHelper(Context context) {
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }
    public static SQLiteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SQLiteHelper(context);
        }
        return instance;

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL(Utils.CREATE_USER_TABLE);
        Log.e("TABLE", "TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertUserDetails(ArrayList<UserDetails> userDetailsArrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        for (int i = 0; i < userDetailsArrayList.size(); i++) {
            UserDetails userDetails = userDetailsArrayList.get(i);
            ContentValues values = new ContentValues();
            values.put(Utils.ID, userDetails.user.getId());
            values.put(Utils.NAME, userDetails.user.getName());
            values.put(Utils.USER_NAME, userDetails.user.getUsername());
            values.put(Utils.EMAIL, userDetails.user.getEmail());
            values.put(Utils.STREET, userDetails.userAddress.getStreet());
            values.put(Utils.SUITE, userDetails.userAddress.getSuite());
            values.put(Utils.CITY, userDetails.userAddress.getCity());
            values.put(Utils.ZIPCODE, userDetails.userAddress.getZipcode());
            values.put(Utils.LAT, userDetails.userGeo.getLat());
            values.put(Utils.LNG, userDetails.userGeo.getLng());
            values.put(Utils.PHONE, userDetails.userContacts.getPhone());
            values.put(Utils.WEBSITE, userDetails.userContacts.getWebsite());
            values.put(Utils.COMPANY_NAME, userDetails.userCompany.getName());
            values.put(Utils.CATCHPHRASE, userDetails.userCompany.getCatchPhrase());
            values.put(Utils.BS, userDetails.userCompany.getBs());
            db.insert(TABLE_NAME_USER, null, values);
        }
        db.close();
        Log.e("values", "value inserted");
    }
    public boolean isMakeApiCall() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME_USER, null);
        if (cur != null) {//there is dada
            cur.moveToFirst();
            // Always one row returned.
            if (cur.getInt(0) == 0) {               // Zero count means empty table.
                return true;
            }
        }
        return false;
    }

    public ArrayList<UserDetails> getUsers() {
        return  null;

    }
}
