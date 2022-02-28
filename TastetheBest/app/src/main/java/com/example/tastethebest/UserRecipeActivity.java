package com.example.tastethebest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tastethebest.adapters.RecipeAdapter;
import com.example.tastethebest.ratings.Recipe;
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

import java.sql.Array;
import java.util.ArrayList;

public class UserRecipeActivity extends AppCompatActivity {
    String category;
    DatabaseReference dbUserRecipe;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    TextView tvCategory;
    ListView lvRecipe;
    RecipeAdapter recipeAdapter;
    private static ArrayList<Recipe> recipeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recipe);

        tvCategory = findViewById(R.id.tvCategory);
        lvRecipe = findViewById(R.id.lvUserRecipes);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        Intent intent = getIntent();
        category = intent.getStringExtra("category");

        tvCategory.setText(category.toUpperCase() + " user recipes".toUpperCase());

        dbUserRecipe = FirebaseDatabase.getInstance().getReference("UserRecipe").child(category);

        getUserRecipes();

    }

    private void getUserRecipes() {
        dbUserRecipe.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recipeArrayList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Recipe recipe = dataSnapshot.getValue(Recipe.class);
                    recipeArrayList.add(recipe);
                }
                recipeAdapter = new RecipeAdapter(UserRecipeActivity.this, recipeArrayList);
                lvRecipe.setAdapter(recipeAdapter);

                lvRecipe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String id = recipeArrayList.get(i).getId();
                        String name = recipeArrayList.get(i).getName();
                        String procedure = recipeArrayList.get(i).getProcedure();
                        String ingredients = recipeArrayList.get(i).getIngredients();

                        startActivity(new Intent(UserRecipeActivity.this,UserRecipeDetails.class)
                                .putExtra("id",id)
                                .putExtra("name",name)
                                .putExtra("procedure",procedure)
                                .putExtra("ingredients",ingredients));
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserRecipeActivity.this, "Error! " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addRecipe(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_add_recipe);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        dialog.setCancelable(true);
        dialog.show();

        EditText etProcedure, etRecipeName, etIngredients;
        Button btnAdd;

        etProcedure = dialog.findViewById(R.id.etProcedure);
        etIngredients = dialog.findViewById(R.id.etIngredients);
        etRecipeName = dialog.findViewById(R.id.etRecipeName);
        btnAdd = dialog.findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String procedure = etProcedure.getText().toString();
                String recipeName = etRecipeName.getText().toString();
                String ingredients = etIngredients.getText().toString();

                if (recipeName.isEmpty()) {
                    Toast.makeText(UserRecipeActivity.this, "Insert recipe name", Toast.LENGTH_SHORT).show();
                } else if (ingredients.isEmpty()) {
                    Toast.makeText(UserRecipeActivity.this, "Insert ingredients", Toast.LENGTH_SHORT).show();
                } else if (procedure.isEmpty()) {
                    Toast.makeText(UserRecipeActivity.this, "Insert procedure", Toast.LENGTH_SHORT).show();
                } else {
                    String key = dbUserRecipe.push().getKey();
                    String user = firebaseUser.getEmail();

                    Recipe recipe = new Recipe(key, category, recipeName, ingredients, procedure, user);

                    dbUserRecipe.child(key).setValue(recipe).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(UserRecipeActivity.this, "Recipe added", Toast.LENGTH_SHORT).show();
                            getUserRecipes();
                            dialog.dismiss();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(UserRecipeActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

    }
}