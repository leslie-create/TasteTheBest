package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Pinakbet extends AppCompatActivity {
    //    private ImageView mbackbtn;
//    private Button mResponseBtn;
    private TextView mRateme;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinakbet);



//        mbackbtn = findViewById(R.id.backbtn);
//        mResponseBtn = findViewById(R.id.responsebtbn);
        mRateme = findViewById(R.id.rateme);


//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Vegetables.class));
//            }
//        });

//        mResponseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Response.class));
//            }
//        });

        mRateme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Response.class).putExtra("recipeName","Pinakbet"));
            }
        });
    }
}