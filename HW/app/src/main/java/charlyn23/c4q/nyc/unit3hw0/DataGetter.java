package charlyn23.c4q.nyc.unit3hw0;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by charlynbuchanan on 7/15/15.
 */


public class DataGetter {
    public DataGetter() {
        new AsyncClass().execute();
    }


    class AsyncClass extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String result = "";
            String jsonURL = "https://data.cityofnewyork.us/api/views/9mhd-na2n/rows.json?accessType=DOWNLOAD";
            URL url = null;
            try {
                url = new URL(jsonURL);
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

                if ((connection != null) || (url != null)) {
                    Log.v("status", "CONNECTED");
                }
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                StringBuilder stringBuilder = new StringBuilder();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                result = stringBuilder.toString();
                Log.d("json: ", result);
                connection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("JSON", "Malformed url: " + e.toString());
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("JSON", "IOException url" + e.toString());
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            jsonString = s;
            Log.v("JSON", s);

            getBX2000Pop();
            getBX2010Pop();
            getBK2000Pop();
            getBK2010Pop();
            getManhattan2000Pop();
            getManhattan2010Pop();
            getQueens2000Pop();
            getQueens2010Pop();
            getSI2000Pop();
            getSI2010Pop();

        }
    }

    private static String jsonString = "";

    public static String getJsonString() {
        return jsonString;
    }


    //Get Bronx 2000 population
    public static int getBX2000Pop() {

        int bx2000pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray bronx = (JSONArray) data.get(0);
            bx2000pop = bronx.getInt(9);

            Log.d("Bronx data : ", String.valueOf(bx2000pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bx2000pop;

    }

    //Get Bronx 2010 population
    public static int getBX2010Pop() {

        int bx2010pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray bronx = (JSONArray) data.get(0);
            bx2010pop = bronx.getInt(10);

            Log.d("Bronx 2010 data : ", String.valueOf(bx2010pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bx2010pop;



    }

    //Get Brooklyn 2000 population
    public static int getBK2000Pop() {

        int bk2000pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray brooklyn = (JSONArray) data.get(1);
            bk2000pop = brooklyn.getInt(9);

            Log.d("Brooklyn 2000 data : ", String.valueOf(bk2000pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bk2000pop;

    }

    //Get Brooklyn 2000 population
    public static int getBK2010Pop() {

        int bk2010pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray brooklyn = (JSONArray) data.get(1);
            bk2010pop = brooklyn.getInt(10);

            Log.d("Brooklyn 2010 data : ", String.valueOf(bk2010pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bk2010pop;

    }

    //Get Manhattan 2000 population
    public static int getManhattan2000Pop() {

        int man2000pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray brooklyn = (JSONArray) data.get(2);
            man2000pop = brooklyn.getInt(9);

            Log.d("Manhattan 2000 data : ", String.valueOf(man2000pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return man2000pop;

    }

    //Get Manhattan 2010 population
    public static int getManhattan2010Pop() {

        int man2010pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray manhattan = (JSONArray) data.get(2);
            man2010pop = manhattan.getInt(10);

            Log.d("Manhattan 2010 data : ", String.valueOf(man2010pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return man2010pop;
    }

    //Get Queens 2000 population
    public static int getQueens2000Pop() {

        int queens2000pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray queens = (JSONArray) data.get(3);
            queens2000pop = queens.getInt(9);

            Log.d("Queens 2000 data : ", String.valueOf(queens2000pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return queens2000pop;

    }

    //Get Queens 2010 population
    public static int getQueens2010Pop() {

        int queens2010pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray queens = (JSONArray) data.get(3);
            queens2010pop = queens.getInt(10);

            Log.d("Queens 2010 data : ", String.valueOf(queens2010pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return queens2010pop;

    }

    //Get Staten Island 2000 population
    public static int getSI2000Pop() {

        int sI2000pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray sI = (JSONArray) data.get(4);
            sI2000pop = sI.getInt(9);

            Log.d("SI 2000 data : ", String.valueOf(sI2000pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sI2000pop;

    }

    //Get Staten Island 2010 population
    public static int getSI2010Pop() {

        int sI2010pop = 0;
        String json = getJsonString();
        Log.v("getJsonString", json);

        try {
            JSONObject object = new JSONObject(json);
            JSONArray data = object.getJSONArray("data");
            JSONArray sI = (JSONArray) data.get(4);
            sI2010pop = sI.getInt(10);

            Log.d("SI 2010 data : ", String.valueOf(sI2010pop));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sI2010pop;

    }
}
