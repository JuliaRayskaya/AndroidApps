package com.example.juliarayskaya.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId,ArrayList<User> users){
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents){
        convertView = mInflater.inflate(mViewResourceId,null);

        User user = users.get(position);
        if(user!=null){
            ImageView first = convertView.findViewById(R.id.first);
            TextView second = convertView.findViewById(R.id.second);
            TextView third = convertView.findViewById(R.id.third);

            if(first!=null){
                Picasso.get().load(user.getFirst()).into(first);

            }
            if(second!=null){
                second.setText(user.getSecond());

            }
            if(third!=null){
                third.setText(user.getThird());

            }
        }
        return convertView;
    }
}
