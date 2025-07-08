package com.autosms.myapplicationcallevent.Helper;

import android.util.Log;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceAPI {
    private static final String API_KEY = "AIzaSyCW4Vs1DFofnrj5gCa2lsBvZg1cLwpiCT0";
    private static final String OUT_JSON = "/json";
    private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    private static final String TAG = PlaceAPI.class.getSimpleName();
    private static final String TYPE_AUTOCOMPLETE = "/autocomplete";

    public ArrayList<String> autocomplete(String input) {
        ArrayList<String> resultList = null;
        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json");
            sb.append("?key=AIzaSyCW4Vs1DFofnrj5gCa2lsBvZg1cLwpiCT0");
            sb.append("&types=(cities)");
            sb.append("&components=country:ind");
            sb.append("&input=" + URLEncoder.encode(input, "utf8"));
            HttpURLConnection conn2 = (HttpURLConnection) new URL(sb.toString()).openConnection();
            InputStreamReader in = new InputStreamReader(conn2.getInputStream());
            char[] buff = new char[1024];
            while (true) {
                int read = in.read(buff);
                int read2 = read;
                if (read == -1) {
                    break;
                }
                jsonResults.append(buff, 0, read2);
            }
            if (conn2 != null) {
                conn2.disconnect();
            }
            try {
                JSONArray predsJsonArray = new JSONObject(jsonResults.toString()).getJSONArray("predictions");
                resultList = new ArrayList<>(predsJsonArray.length());
                for (int i = 0; i < predsJsonArray.length(); i++) {
                    Log.i("ZZZZZ", "1nd " + predsJsonArray.getJSONObject(i).getString("description"));
                    resultList.add(predsJsonArray.getJSONObject(i).getString("description"));
                }
            } catch (JSONException e) {
                Log.e(TAG, "Cannot process JSON results", e);
            }
            return resultList;
        } catch (MalformedURLException e2) {
            Log.e(TAG, "Error processing Places API URL", e2);
            if (conn != null) {
                conn.disconnect();
            }
            return null;
        } catch (IOException e3) {
            Log.e(TAG, "Error connecting to Places API", e3);
            if (conn != null) {
                conn.disconnect();
            }
            return null;
        } catch (Throwable th) {
            if (conn != null) {
                conn.disconnect();
            }
            throw th;
        }
    }
}
