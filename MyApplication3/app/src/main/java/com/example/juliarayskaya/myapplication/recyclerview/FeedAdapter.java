package com.example.juliarayskaya.myapplication.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliarayskaya.myapplication.FeedItem;
import com.example.juliarayskaya.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    private final List<FeedItem> feedItems;

    public FeedAdapter(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_feed, parent, false);
        return new FeedHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        // get our custom object from our dataset at this position
        FeedItem item = feedItems.get(position);

        Picasso.get().load(item.getImage()).into(holder.image);
        holder.header.setText(item.getHeader());
        holder.text.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    static class FeedHolder extends RecyclerView.ViewHolder {

        public final ImageView image;
        public final TextView header;
        public final TextView text;

        public FeedHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_news_image);
            header = itemView.findViewById(R.id.item_news_header);
            text = itemView.findViewById(R.id.item_news_text);
        }
    }
}

