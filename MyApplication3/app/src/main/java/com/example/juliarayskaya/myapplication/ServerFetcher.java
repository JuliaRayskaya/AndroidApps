package com.example.juliarayskaya.myapplication;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerFetcher {
    private final static String TAG = "ServerFetcher";


    public static String getJSONString(String UrlSpec) throws Exception {

        OkHttpClient client = new OkHttpClient();

        String url = "http://85.143.216.172:8080/all";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public static List<NewsItem> newsItems(){
        List<NewsItem> newsItems = new ArrayList<>();
        try{
            String url = Uri.parse("http://85.143.216.172:8080/all")
                    .buildUpon()
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .build().toString();
            String jsonString = getJSONString(url);
            JSONArray news = new JSONArray(jsonString);

            for (int i = 0; i < news.length(); i++){
                JSONObject e = news.getJSONObject(i);
                NewsItem parseNewsItem = new NewsItem();
                parseNewsItem.setImage(e.getString("media"));
                parseNewsItem.setHeader(e.getString("title"));
                parseNewsItem.setText(e.getString("description"));
                parseNewsItem.setContent(e.getString("content"));
                newsItems.add(parseNewsItem);
            }


        } catch (IOException ioe){
            Log.e(TAG, "Ошибка загрузки данных", ioe);
        } catch (JSONException joe){
            Log.e(TAG, "Ошибка парсинга JSON", joe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsItems;
    }

}