package com.example.juliarayskaya.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class AndroidDevelopersAdapter extends BaseAdapter {

    private final List<AndroidDeveloper> developers;
    private final LayoutInflater inflater;

    public AndroidDevelopersAdapter(Context context, List<AndroidDeveloper> developers) {
        this.developers = developers;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return developers.size();
    }

    @Override
    public AndroidDeveloper getItem(int position) {
        return developers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = onCreateViewHolder(parent);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();

        // Getting the data for this specific row
        AndroidDeveloper developer = developers.get(position);

        onBindViewHolder(holder, developer);

        return convertView;
    }

    private View onCreateViewHolder(ViewGroup parent) {
        View convertView = inflater.inflate(R.layout.item_developer, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.image = convertView.findViewById(R.id.item_developer_image);
        holder.name = convertView.findViewById(R.id.item_developer_name);
        holder.lecturer = convertView.findViewById(R.id.item_developer_lecturer);
        convertView.setTag(holder);
        return convertView;
    }

    private void onBindViewHolder(ViewHolder holder, AndroidDeveloper developer) {
        // Fill views with our data
        Picasso.get().load(developer.getImage()).into(holder.image);
        holder.name.setText(developer.getName());
        if (developer.isLecturer()) {
            holder.lecturer.setVisibility(View.VISIBLE);
        } else {
            holder.lecturer.setVisibility(View.GONE);
        }
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView name;
        public ImageView lecturer;
    }
}

