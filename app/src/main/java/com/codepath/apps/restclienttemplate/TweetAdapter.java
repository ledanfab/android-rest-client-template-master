package com.codepath.apps.restclienttemplate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Fab on 7/22/2018.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

    public List<Tweet> mTweets;
    //pass in the tweets array in the constructor
    public TweetAdapter(List<Tweet>tweets){
        mTweets = tweets;

    }
    //fo each row inflate the layout cache references into view holders

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        AtomicReference<View> tweetView = new AtomicReference<>(inflater.inflate(R.layout.item_tweet, parent, false));
        AtomicReference<ViewHolder> viewHolder = new AtomicReference<>(new ViewHolder(tweetView.get()));
        return viewHolder.get();
    }


    //bind the the values based on the position of the element

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = mTweets.get(position);

        holder.tvUserName.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }
    //create the viw holder

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvUserName,tvBody;


        @SuppressLint("WrongViewCast")
        public ViewHolder(View itemView){
            super(itemView);

            // perform findViewById lookups

            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvUserName =  itemView.findViewById(R.id.tvUserName);
            tvBody = itemView.findViewById(R.id.tvBody);
        }

    }
}
