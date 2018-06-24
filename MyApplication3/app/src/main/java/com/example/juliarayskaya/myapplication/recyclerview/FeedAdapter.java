package com.example.juliarayskaya.myapplication.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliarayskaya.myapplication.FeedItem;
import com.example.juliarayskaya.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    private final List<FeedItem> feedItems;
    final boolean[] checkedArr;

    public FeedAdapter(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        checkedArr = new boolean[feedItems.size()];
        // Filling all the items as unchecked by default
        Arrays.fill(checkedArr, true);
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
        holder.name.setText(item.getName());
        if (item.checkboxMarked()) {
            holder.checkBox.setChecked(checkedArr[holder.getAdapterPosition()]);
        } else {
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    static class FeedHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final ImageView image;
        public final TextView name;
        public final CheckBox checkBox;

        public FeedHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_feed_image);
            name = itemView.findViewById(R.id.item_feed_header);
            checkBox = itemView.findViewById(R.id.checkbox);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            checkBox.setChecked(true);
    }
    }
}

