package com.example.juliarayskaya.myapplication.recyclerview;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juliarayskaya.myapplication.AndroidDeveloper;
import com.example.juliarayskaya.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class AndroidDevelopersAdapter
        extends RecyclerView.Adapter<AndroidDevelopersAdapter.DeveloperHolder> {

    private final List<AndroidDeveloper> developers;

    public AndroidDevelopersAdapter(List<AndroidDeveloper> developers) {
        this.developers = developers;
    }

    @NonNull
    @Override
    public DeveloperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_developer, parent, false);
        return new DeveloperHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeveloperHolder holder, int position) {
        // get our custom object from our dataset at this position
        AndroidDeveloper developer = developers.get(position);

        Picasso.get().load(developer.getImage()).into(holder.image);
        holder.name.setText(developer.getName());
        if (developer.isLecturer()) {
            holder.lecturer.setVisibility(View.VISIBLE);
        } else {
            holder.lecturer.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    static class DeveloperHolder extends RecyclerView.ViewHolder {

        public final ImageView image;
        public final TextView name;
        public final ImageView lecturer;

        public DeveloperHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_developer_image);
            name = itemView.findViewById(R.id.item_developer_name);
            lecturer = itemView.findViewById(R.id.item_developer_lecturer);
        }
    }
}