package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserRecipeDetails extends AppCompatActivity {
    TextView tvName, tvIngredients, tvProcedure;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recipe_details);

        tvName = findViewById(R.id.tvRecipeName);
        tvIngredients = findViewById(R.id.tvIngredients);
        tvProcedure = findViewById(R.id.tvProcedure);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        tvName.setText(intent.getStringExtra("name").toUpperCase());
        tvIngredients.setText(intent.getStringExtra("ingredients"));
        tvProcedure.setText(intent.getStringExtra("procedure"));
    }

    public void addRating(View view) {
        startActivity(new Intent(getApplicationContext(), RatingActivity.class)
                .putExtra("recipeName", tvName.getText().toString()).putExtra("id",id));
    }
}