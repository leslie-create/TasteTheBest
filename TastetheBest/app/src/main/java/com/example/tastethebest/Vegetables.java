package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Vegetables extends AppCompatActivity {

//    private ImageButton mbackbtn;

//    private Button mPinakbetbtn;
//    private Button mChopsueybtn;
//    private Button mBinagoonganbtn;
//    private Button mMunggobtn;
//    private Button mGinataangkalabasabtn;

    RelativeLayout mfirst, msecond, mthird, mfourth, mfifth;
    TextView mPinakbetbtn, mChopsueybtn, mBinagoonganbtn, mMunggobtn, mGinataangkalabasabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

//        mbackbtn = findViewById(R.id.backbtn);

        mPinakbetbtn = findViewById(R.id.txt2);
        mChopsueybtn = findViewById(R.id.txt5);
        mBinagoonganbtn = findViewById(R.id.txt8);
        mMunggobtn = findViewById(R.id.txt11);
        mGinataangkalabasabtn = findViewById(R.id.txt14);

        mfirst = findViewById(R.id.first);
        msecond = findViewById(R.id.second);
        mthird = findViewById(R.id.third);
        mfourth = findViewById(R.id.fourth);
        mfifth = findViewById(R.id.fifth);


//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });

        mPinakbetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pinakbet.class));
            }
        });

        mChopsueybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Chapsuey.class));
            }
        });

        mBinagoonganbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Binagoongan.class));
            }
        });

        mMunggobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Munggo.class));
            }
        });

        mGinataangkalabasabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GinataangKalabasa.class));
            }
        });

        //relative onlick//

        mfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Pinakbet.class));
            }
        });

        msecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Chapsuey.class));
            }
        });

        mthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Binagoongan.class));
            }
        });

        mfourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Munggo.class));
            }
        });

        mfifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GinataangKalabasa.class));
            }
        });
    }public void userRecipe(View view) {
        startActivity(new Intent(this, UserRecipeActivity.class).putExtra("category", "vegetables"));
    }
}