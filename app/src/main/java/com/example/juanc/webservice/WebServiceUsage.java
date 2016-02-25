package com.example.juanc.webservice;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by juanc on 25/02/2016.
 */
public class WebServiceUsage {

    public void getPosts() throws JSONException {
        String postUrl = "/posts/1";
        WebService.get(postUrl, null, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject object) {
                // Pull out the first event on the public timeline

                String title = "";
                try {
                    title = object.getString("title");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println("Title: " + title);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                JSONObject firstEvent = null;
                try {
                    firstEvent = (JSONObject) timeline.get(0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                String tweetText = null;
                try {
                    tweetText = firstEvent.getString("title");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Do something with the response
                System.out.println(tweetText);
            }


        });
    }

}
