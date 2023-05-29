package com.example.mobile_labs_20521431;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity  extends AppCompatActivity {
    TextView textViewLoginLink;
    EditText mFullName, mPhone, mUsername, mPassword;
    Button mSignup;
    private FirebaseAuth mauth;

    FirebaseFirestore db;
    CollectionReference Ref;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFullName = findViewById(R.id.Fullname);
        mPhone = findViewById(R.id.Phone);
        mUsername = findViewById(R.id.Username);
        mPassword = findViewById(R.id.Password);
        mSignup = findViewById(R.id.Signup);
        textViewLoginLink = findViewById(R.id.textViewLoginLink);
        mauth = FirebaseAuth.getInstance();

        db = FirebaseFirestore.getInstance();
        Ref =db.collection("userLab4");


        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });


        textViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }



    private void registerUser()
    {
        String Fullname = mFullName.getText().toString().trim();
        String Phone = mPhone.getText().toString().trim();
        String UserName = mUsername.getText().toString().trim();
        String Password = mPassword.getText().toString().trim();
        User user = new User(Fullname,Phone,UserName,Password);
        if(Fullname.isEmpty())
        {
            mFullName.setError("Name required");
            mFullName.requestFocus();
            return;
        }
        if(Phone.isEmpty())
        {
            mPhone.setError("Phone required");
            mPhone.requestFocus();
            return;
        }
        if(Phone.length() > 10)
        {
            mPhone.setError("Your phone is invalid");
            mPhone.requestFocus();
            return;
        }
        if(UserName.isEmpty())
        {
            mUsername.setError("UserName required");
            mUsername.requestFocus();
            return;
        }
        if(UserName.length() < 6 )
        {
            mUsername.setError("Username needs more than 6 characters");
            mUsername.requestFocus();
            return;
        }
        if(Password.isEmpty())
        {
            mPassword.setError("Password required");
            return;
        }
        if(Password.length() <6)
        {
            mPassword.setError("Password needs more than 6 characters");
            return;
        }


        Ref.add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Register Successfully",Toast.LENGTH_LONG).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failure",Toast.LENGTH_LONG).show();
            }
        });


    }


    protected void onStart() {
        super.onStart();
        if(mauth.getCurrentUser() != null)
        {
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
