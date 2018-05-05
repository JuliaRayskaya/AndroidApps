package com.example.juliarayskaya.myapplication.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliarayskaya.myapplication.NewsItem;
import com.example.juliarayskaya.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class NewsAdapter
        extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private final List<NewsItem> newsItems;

    public NewsAdapter(List<NewsItem> newsItems) {
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        // get our custom object from our dataset at this position
        NewsItem item = newsItems.get(position);

        Picasso.get().load(item.getImage()).into(holder.image);
        holder.header.setText(item.getHeader());
        holder.text.setText(item.getText());
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        public final ImageView image;
        public final TextView header;
        public final TextView text;

        public NewsHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_news_image);
            header = itemView.findViewById(R.id.item_news_header);
            text = itemView.findViewById(R.id.item_news_text);
        }
    }
}

