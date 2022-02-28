package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Dessert extends AppCompatActivity {

//    private ImageButton mbackbtn;

    private Button mLecheFlanbtn;
    private Button mFruitSaladbtn;
    private Button mUbePutobtn;
    private Button mMangoGrahambtn;
    private Button mMajaBlancabtn;

    RelativeLayout mlecheflanfirst,mfruitsaladsecond,mubeputothird,mgrahamtahofourth,mmajablancafifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);

//        mbackbtn = findViewById(R.id.backbtn);

//        mLecheFlanbtn = findViewById(R.id.lecheflanbtn);
//        mFruitSaladbtn = findViewById(R.id.fruitsaladbtn);
//        mUbePutobtn = findViewById(R.id.ubeputobtn);
//        mMangoGrahambtn = findViewById(R.id.mangograhambtn);
//        mMajaBlancabtn = findViewById(R.id.majablancabtn);

        mlecheflanfirst = findViewById(R.id.lecheflanfirst);
        mfruitsaladsecond = findViewById(R.id.fruitsaladsecond);
        mubeputothird = findViewById(R.id.ubeputothird);
        mgrahamtahofourth = findViewById(R.id.grahamtahofourth);
        mmajablancafifth = findViewById(R.id.majablancafifth);


//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });

//        mLecheFlanbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),LecheFlan.class));
//            }
//        });
//
//        mFruitSaladbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),FruitSalad.class));
//            }
//        });
//
//        mUbePutobtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),UbePuto.class));
//            }
//        });
//
//        mMangoGrahambtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MangoGraham.class));
//            }
//        });
//
//        mMajaBlancabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MajaBlanca.class));
//            }
//        });

        //relative onlick//

        mlecheflanfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LecheFlan.class));
            }
        });

        mfruitsaladsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FruitSalad.class));
            }
        });

        mubeputothird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UbePuto.class));
            }
        });

        mgrahamtahofourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MangoGraham.class));
            }
        });

        mmajablancafifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MajaBlanca.class));
            }
        });
    }public void userRecipe(View view) {
        startActivity(new Intent(this, UserRecipeActivity.class).putExtra("category", "dessert"));
    }
}