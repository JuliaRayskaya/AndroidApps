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

import java.util.ArrayList;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedHolder> {

    public ArrayList<FeedItem> feedItems;


    public FeedAdapter(ArrayList<FeedItem> feedItems) {
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
        holder.name.setText(item.getName());
        holder.checkBox.setChecked(false);
        item.setCheckBoxMarked(false);

    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public FeedItem getItem(int position) {
        return feedItems.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    class FeedHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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
            addListenerOnChkbx();
        }

        public void addListenerOnChkbx() {

            checkBox.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()) {
                        checkBox.setChecked(true);
                        getItem(getAdapterPosition()).setCheckBoxMarked(true);
                    } else {
                        checkBox.setChecked(false);
                        getItem(getAdapterPosition()).setCheckBoxMarked(false);
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {
            if(checkBox.isChecked()){
                checkBox.setChecked(false);
                getItem(getAdapterPosition()).setCheckBoxMarked(false);
            }
            else {
                checkBox.setChecked(true);
                getItem(getAdapterPosition()).setCheckBoxMarked(true);
            }

        }
    }
}

