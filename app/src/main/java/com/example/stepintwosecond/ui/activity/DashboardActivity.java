package com.example.stepintwosecond.ui.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stepintwosecond.R;
import com.example.stepintwosecond.api.HttpHandler;
import com.example.stepintwosecond.database.SQLiteHelper;
import com.example.stepintwosecond.model.User;
import com.example.stepintwosecond.model.UserDetails;
import com.example.stepintwosecond.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
    UserDetails userDetails;
    ArrayList<UserDetails> userDetailsArrayList;
    SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sqLiteHelper = SQLiteHelper.getInstance(this);
        userDetailsArrayList = new ArrayList<>();
        DataAsync dataAsync = new DataAsync(this, Utils.URL_POST);
        dataAsync.execute();
    }

    private class DataAsync extends AsyncTask<Void, Integer, ArrayList<UserDetails>> {
        private Context context;
        private final String url;

        public DataAsync(Context context, String url) {

            this.context = context;
            this.url = url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected ArrayList<UserDetails> doInBackground(Void... arg0) {
            boolean isMakeApi = sqLiteHelper.isMakeApiCall();
            if (isMakeApi == true) {
                HttpHandler httpHandler = new HttpHandler(url, null);
                String jsonServerResponce = httpHandler.makeServiceCall();

                if (jsonServerResponce != null) {
                    try {
                        ArrayList<UserDetails> localuserdetailArrayList = new ArrayList<>();
                        JSONArray jsonArray = new JSONArray(jsonServerResponce);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObj = jsonArray.getJSONObject(i);
                            UserDetails userDetails = new UserDetails();
                            userDetails.setUser(User u);
                            userDetails.user.setId(jsonObj.getString("id"));
                            userDetails.user.setName(jsonObj.getString("name"));
                            userDetails.user.setUsername(jsonObj.getString("username"));
                            userDetails.user.setEmail(jsonObj.getString("email"));
                            userDetails.userAddress.setStreet(jsonObj.getString("street"));
                            userDetails.userAddress.setSuite(jsonObj.getString("suite"));
                            userDetails.userAddress.setCity(jsonObj.getString("city"));
                            userDetails.userAddress.setZipcode(jsonObj.getString("zipcode"));
                            userDetails.userGeo.setLat(jsonObj.getString("lat"));
                            userDetails.userGeo.setLng(jsonObj.getString("lng"));
                            userDetails.userContacts.setPhone(jsonObj.getString("phone"));
                            userDetails.userContacts.setWebsite(jsonObj.getString("website"));
                            userDetails.userCompany.setName(jsonObj.getString("name"));
                            userDetails.userCompany.setCatchPhrase(jsonObj.getString("catchPhrase"));
                            userDetails.userCompany.setBs(jsonObj.getString("bs"));

                            localuserdetailArrayList.add(userDetails);
                        }

                        sqLiteHelper.insertUserDetails(localuserdetailArrayList);
                        sqLiteHelper.close();
                        return localuserdetailArrayList;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return sqLiteHelper.getUsers();

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList<UserDetails> userDetailsArrayList) {
            super.onPostExecute(userDetailsArrayList);
        }

    }
}

