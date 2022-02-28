package com.example.tastethebest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tastethebest.adapters.RatingsAdapter;
import com.example.tastethebest.ratings.Rating;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RatingActivity extends AppCompatActivity {
    TextView tvName;
    ListView lvRatings;
    String recipeName,id;
    String comment, rating;
    DatabaseReference dbRatings;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    public static ArrayList<Rating> ratingArrayList = new ArrayList<>();
    RatingsAdapter ratingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        tvName = findViewById(R.id.tvName);
        lvRatings = findViewById(R.id.lvResponse);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        Intent intent = getIntent();
        id=intent.getStringExtra("id");
        recipeName = intent.getStringExtra("recipeName");
        dbRatings = FirebaseDatabase.getInstance().getReference("Ratings").child(id);
        tvName.setText(recipeName.toUpperCase());

        getRating();
    }

    private void getRating() {
        dbRatings.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ratingArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Rating rating = dataSnapshot.getValue(Rating.class);
                    ratingArrayList.add(rating);
                }
                ratingsAdapter = new RatingsAdapter(RatingActivity.this, ratingArrayList);
                lvRatings.setAdapter(ratingsAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void addRating(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_add_rating);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);


        EditText etComment;
        RatingBar ratingBar;
        Button btnSubmit;

        etComment = dialog.findViewById(R.id.etComment);
        ratingBar = dialog.findViewById(R.id.ratingBar);
        btnSubmit = dialog.findViewById(R.id.btnSubmit);
        ratingBar.setRating(1.0F);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comment = etComment.getText().toString();
                rating = String.valueOf(ratingBar.getRating());

                if (rating.equalsIgnoreCase("0.0")) {
                    Toast.makeText(RatingActivity.this, "Please add rating", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (comment.isEmpty()) {
                    Toast.makeText(RatingActivity.this, "Please add comment", Toast.LENGTH_SHORT).show();
                    return;
                }

                String user = firebaseUser.getEmail();
                String key = dbRatings.push().getKey();

                Rating rate = new Rating(key, recipeName, user, rating, comment);

                dbRatings.child(key).setValue(rate).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        getRating();
                        Toast.makeText(RatingActivity.this, "Added rating!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RatingActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        dialog.show();
    }
}