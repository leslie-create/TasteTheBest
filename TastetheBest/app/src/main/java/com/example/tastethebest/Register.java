package com.example.tastethebest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {
    public static final String TAG = "TAG";
    public static final String TAG1 = "TAG,";
    EditText mUserName, mEmail, mPassword, mConfirmpass;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    //    FirebaseFirestore fStore;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUserName = findViewById(R.id.Username);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mConfirmpass = findViewById(R.id.confirmpass);
        mRegisterBtn = findViewById(R.id.registerButton);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();
//        fStore = FirebaseFirestore.getInstance();


        // login//

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String Username = mUserName.getText().toString();
                String confirmpass = mConfirmpass.getText().toString();

                if (TextUtils.isEmpty(Username)) {
                    mUserName.setError("Full name is required");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                    return;
                }

                if (password.length() < 8) {
                    mPassword.setError("Password must be at least 8 numbers");
                    return;
                }
                if (TextUtils.isEmpty(confirmpass)) {
                    mConfirmpass.setError("Confirm Password is required");
                    return;
                }
                if(!password.equals(confirmpass)){
                    mConfirmpass.setError("Password mismatch");
                    return;
                }
//                else{
//                    mConfirmpass.setText("Password matched");
//                }


                //        register the user in firebase


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {


                            User user = new User(Username, email, password, confirmpass);


                            FirebaseDatabase.getInstance().getReference("Users")


                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User Created ", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(getApplicationContext(), Login.class);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(Register.this, "Registration Failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(Register.this, "Registration Failed!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });



    }
}