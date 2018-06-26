package com.example.juliarayskaya.myapplication;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServerFetcher {
    private final static String TAG = "ServerFetcher";

    public static String getExclude() {

         String exclude = FeedListActivity.getInstance().getPreferredRSSFeed().toString();
        return exclude.substring(16, exclude.length() - 2);
    }

    public static String getFind() {

         String search = FeedListActivity.getInstance().getPreferredRSSFeed2().toString();
        return search.substring(15, search.length() - 2);
    }

    public static String getRes() {

        String string = FeedListActivity.getInstance().generateChecked().toString();
        return string.substring(1, string.length() - 1);
    }

    public static String getJSONString(String UrlSpec) throws Exception {

        OkHttpClient client = new OkHttpClient();

        String url = "85.143.216.172";


        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(url)
                .port(8080)
                .addPathSegment("choose")
                .addQueryParameter("chosen", getRes())
                .addQueryParameter("filters", getExclude())
                .addQueryParameter("search", getFind())
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        System.out.println(httpUrl.toString());
        System.out.println(getExclude());
        System.out.println(getFind());
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        return result;
    }

    public static List<NewsItem> newsItems(){
        List<NewsItem> newsItems = new ArrayList<>();
        try{
            String url = Uri.parse("http://85.143.216.172:8080")
                    .buildUpon()
                    .appendPath("choose")
                    .appendQueryParameter("chosen",getRes())
                    .appendQueryParameter("filters",getExclude())
                    .appendQueryParameter("search",getFind())
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