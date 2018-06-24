package com.example.juliarayskaya.myapplication.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliarayskaya.myapplication.ContentActivity;
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
        holder.content.setText(Html.fromHtml(item.getContent()));
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    static class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final ImageView image;
        public final TextView header;
        public final TextView text;
        public final TextView content;
        private final Context context;

        public NewsHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            image = itemView.findViewById(R.id.item_news_image);
            header = itemView.findViewById(R.id.item_news_header);
            text = itemView.findViewById(R.id.item_news_text);
            content = itemView.findViewById(R.id.item_news_content);
            content.setVisibility(View.GONE);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

            final Intent intent;
            switch (getAdapterPosition()){
                default:
                    image.buildDrawingCache();
                    Bitmap bitmap = image.getDrawingCache();
                    intent =  new Intent(context, ContentActivity.class);
                    intent.putExtra("image",bitmap);
                    intent.putExtra("title", header.getText().toString());
                    intent.putExtra("content", content.getText().toString());
                    break;
            }
            context.startActivity(intent);
        }
    }
}

