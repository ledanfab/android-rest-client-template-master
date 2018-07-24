package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Fab on 7/21/2018.
 */

public class Tweet {

    //where to define the attributes to show
    public String body;
    public Long uid; //database for id tweets
    public  User user;
    public String photoUrls;
    public String createdAt;


    //deserialize the json
    public  static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet = new Tweet();
        // extract the valuse from json
        tweet.body = jsonObject.getString("text");
        tweet.uid = jsonObject.getLong("id");
        //tweet.mediaURl = jsonObject.getString("display_url");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        tweet.photoUrls = new String();
        if (jsonObject.has("entities") && jsonObject.getJSONObject("entities").has("media")) {
            JSONArray medias = jsonObject.getJSONObject("entities").getJSONArray("media");
            for (int i = 0; i < medias.length(); i++) {
                JSONObject media = medias.getJSONObject(i);

                if (media.getString("type").equals("photo")) {
                    tweet.photoUrls= media.getString("media_url");
                }
            }
        }
        return tweet;
    }


}
