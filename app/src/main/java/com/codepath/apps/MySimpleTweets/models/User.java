package com.codepath.apps.MySimpleTweets.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shehba.shahab on 9/30/15.
 */
public class User {
    // list attributes

    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;

    // deserialize the user json => User
    public static User fromJSON(JSONObject json) {
        User u = new User();

        // Extract and fill the values

        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
        } catch (JSONException e) {
            e.printStackTrace();

        }

        // Return a user
        return u;
    }

    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
