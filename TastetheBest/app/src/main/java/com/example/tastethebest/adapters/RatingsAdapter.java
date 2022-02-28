package com.example.tastethebest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tastethebest.R;
import com.example.tastethebest.ratings.Rating;

import java.util.ArrayList;

public class RatingsAdapter extends ArrayAdapter<Rating> {
    private static ArrayList<Rating> ratingArrayList = new ArrayList<>();
    Context context;

    public RatingsAdapter(@NonNull Context context, ArrayList<Rating> ratingArrayList) {
        super(context, R.layout.layout_ratings, ratingArrayList);
        this.context = context;
        this.ratingArrayList = ratingArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_ratings, null, false);
        TextView tvUser = view.findViewById(R.id.tvUser);
        RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        TextView tvComment = view.findViewById(R.id.tvComment);

        tvUser.setText(ratingArrayList.get(position).getUser());
        tvComment.setText(ratingArrayList.get(position).getComment());

        float rate = Float.parseFloat(ratingArrayList.get(position).getStar());

        ratingBar.setRating(rate);
        return view;
    }
}
