package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Meat extends AppCompatActivity {

//    private ImageButton mbackbtn;

//    private Button mAdobobtn;
//    private Button mSinigangbtn;
//    private Button mBeefSteakbtn;
//    private Button mKareKarebtn;
//    private Button mCalderetabtn;

    RelativeLayout madobofirst, msinigangsecond, mbeefsteakthird, mkarekarefourth, mcalderetafifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);

//        mbackbtn = findViewById(R.id.backbtn);

//        mAdobobtn       = findViewById(R.id.adobobtn);
//        mSinigangbtn    = findViewById(R.id.sinigangbtn);
//        mBeefSteakbtn   = findViewById(R.id.beefsteakbtn);
//        mKareKarebtn    = findViewById(R.id.karekarebtn);
//        mCalderetabtn   = findViewById(R.id.calderetabtn);

        madobofirst = findViewById(R.id.adobofirst);
        msinigangsecond = findViewById(R.id.sinigangsecond);
        mbeefsteakthird = findViewById(R.id.beefsteakthird);
        mkarekarefourth = findViewById(R.id.karekarefourth);
        mcalderetafifth = findViewById(R.id.calderetafifth);

//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });

//        mAdobobtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Adobo.class));
//            }
//        });
//
//        mSinigangbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Sinigang.class));
//            }
//        });
//
//        mBeefSteakbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),BeefSteak.class));
//            }
//        });
//
//        mKareKarebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),KareKare.class));
//            }
//        });
//
//        mCalderetabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Caldereta.class));
//            }
//        });

        //relative onlick//

        madobofirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Adobo.class));
            }
        });

        msinigangsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Sinigang.class));
            }
        });

        mbeefsteakthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BeefSteak.class));
            }
        });

        mkarekarefourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KareKare.class));
            }
        });

        mcalderetafifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Caldereta.class));
            }
        });
    }

    public void userRecipe(View view) {
        startActivity(new Intent(this, UserRecipeActivity.class).putExtra("category", "meat"));
    }
}