package com.example.tastethebest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Fish extends AppCompatActivity {

//    private ImageButton mbackbtn;

//    private Button mGinataangSalmonbtn;
//    private Button mPinangatbtn;
//    private Button mSweetTilapiabtn;
//    private Button mBangusSisigbtn;
//    private Button mFishSinigangbtn;

    RelativeLayout mginataangsalmonfirst,mpinangatsecond,msweettilapiathird,mbangussisigfourth,mfishsinigangfifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);

//        mbackbtn = findViewById(R.id.backbtn);

//        mGinataangSalmonbtn       = findViewById(R.id.ginataangsalmonbtn);
//        mPinangatbtn    = findViewById(R.id.pinangatbtn);
//        mSweetTilapiabtn   = findViewById(R.id.sweettilapiabtn);
//        mBangusSisigbtn    = findViewById(R.id.bangussisigbtn);
//        mFishSinigangbtn   = findViewById(R.id.fishsinigangbtn);

        mginataangsalmonfirst = findViewById(R.id.ginataangsalmonfirst);
        mpinangatsecond = findViewById(R.id.pinangatsecond);
        msweettilapiathird = findViewById(R.id.sweettilapiathird);
        mbangussisigfourth = findViewById(R.id.bangussisigfourth);
        mfishsinigangfifth = findViewById(R.id.fishsinigangfifth);

//        mbackbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            }
//        });

//        mGinataangSalmonbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),GinataangSalmon.class));
//            }
//        });
//
//        mPinangatbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),Pinangat.class));
//            }
//        });
//
//        mSweetTilapiabtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),SweetTilapia.class));
//            }
//        });
//
//        mBangusSisigbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),BangusSisig.class));
//            }
//        });
//
//        mFishSinigangbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),FishSinigang.class));
//            }
//        });

        //relative onlick//

        mginataangsalmonfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GinataangSalmon.class));
            }
        });

        mpinangatsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Pinangat.class));
            }
        });

        msweettilapiathird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SweetTilapia.class));
            }
        });

        mbangussisigfourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BangusSisig.class));
            }
        });

        mfishsinigangfifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),FishSinigang.class));
            }
        });

    }public void userRecipe(View view) {
        startActivity(new Intent(this, UserRecipeActivity.class).putExtra("category", "fish"));
    }
}