package com.example.stepintwosecond.api;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jisajose on 2018-01-31.
 */

public class HttpHandler {
    private  String mUrl;
    private  String mJsonPostData;
    public  HttpHandler ( String url,String jsonPostData){
        mUrl=url;
        mJsonPostData=jsonPostData;
    }
    public String makeServiceCall(){
        try {
            URL url = new URL(mUrl);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            if(this.mJsonPostData!= null){
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.setRequestMethod("POST");
                OutputStreamWriter writer = new OutputStreamWriter(urlConnection.getOutputStream());
                writer.write(mJsonPostData);
                writer.flush();
            }
            else {

                urlConnection.setRequestMethod("GET");
            }
            int statusCode = urlConnection.getResponseCode();
            Log.e(HttpHandler.class.getSimpleName(), " The status code is " + statusCode);
            if (statusCode == 200) {
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                String response = convertInputStreamToString(inputStream);
                return response;

                // From here you can convert the string to JSON with whatever JSON parser you like to use
                // After converting the string to JSON, I call my custom callback. You can follow this process too, or you can implement the onPostExecute(Result) method
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private String convertInputStreamToString(InputStream inputStream) {
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder total = new StringBuilder();
        String line;
        try {
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return total.toString();
    }
}
