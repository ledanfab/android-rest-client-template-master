package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fab on 7/21/2018.
 */

public class Tweet {

    //where to define the attributes to show
    public String body;
    public Long uid; //database for id tweets
    public  User user;
    public String createdAt;


    //deserialize the json
    public  static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet = new Tweet();
        // extract the valuse from json
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        return tweet;
    }


}
