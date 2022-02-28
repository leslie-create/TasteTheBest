package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button logout;

//    private ImageButton mVegetalbles;
//    private ImageButton mMeat;
//    private ImageButton mFish;
//    private ImageButton mDessert;


    CardView mVegetables,mMeat,mFish,mDessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        logout = findViewById(R.id.logoutbtn);

        mVegetables = findViewById(R.id.imgvegetables);
        mMeat        = findViewById(R.id.imgmeat);
        mFish        = findViewById(R.id.imgfish);
        mDessert     = findViewById(R.id.imgdessert);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        mVegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Vegetables.class));
            }
        });
        mMeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Meat.class));
            }
        });
        mFish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Fish.class));
            }
        });
        mDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Dessert.class));
            }
        });


    }


    public void addRating(View view) {
    }

    public void dictionary(View view) {
        startActivity(new Intent(this,DictionaryActivity.class));
    }
}