package com.codepath.apps.MySimpleTweets;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
    public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
    public static final String REST_URL = "https://api.twitter.com/1.1";
    public static final String REST_CONSUMER_KEY = "S8IRBV07UYbjA6wb4Um8Vy7oe";
    public static final String REST_CONSUMER_SECRET = "lINwkmVamQS9qmVEU6GjSR7PkpyUst0kRnIEyDDdiTe9OHdtKv";
    public static final String REST_CALLBACK_URL = "oauth://SS-CPTweetsApp";
    int count = 25;

    public TwitterClient(Context context) {
        super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
    }

    public void getHomeTimelineWithCount(AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put("count", count);
        getHomeTimeline(handler, params);
    }

    public void getHomeTimelineWithMaxId(AsyncHttpResponseHandler handler, long max_id) {

        RequestParams params = new RequestParams();
        params.put("max_id", max_id);
        getHomeTimeline(handler, params);
    }

    public void getHomeTimeline(AsyncHttpResponseHandler handler, RequestParams params) {
        String apiUrl = getApiUrl("statuses/home_timeline.json");
        getClient().get(apiUrl, params, handler);

    }
}