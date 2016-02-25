package com.example.juanc.webservice;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by juanc on 25/02/2016.
 */
public class WebService {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static String getAbsoluteUrl(String url) {
        return BASE_URL + url;
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }


}
