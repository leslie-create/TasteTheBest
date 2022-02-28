package com.example.tastethebest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tastethebest.R;
import com.example.tastethebest.ratings.Recipe;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private static ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    Context context;

    public RecipeAdapter(@NonNull Context context, ArrayList<Recipe> recipeArrayList) {
        super(context, R.layout.layout_recipe, recipeArrayList);
        this.context = context;
        this.recipeArrayList = recipeArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_recipe, null, false);

        TextView tvRecipeName;
        TextView tvUser;

        tvRecipeName = view.findViewById(R.id.tvRecipeName);
        tvUser = view.findViewById(R.id.tvUser);

        tvRecipeName.setText(recipeArrayList.get(position).getName());
        tvUser.setText("by "+recipeArrayList.get(position).getUser());

        return view;
    }
}
