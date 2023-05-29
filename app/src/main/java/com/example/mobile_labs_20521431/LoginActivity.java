package com.example.mobile_labs_20521431;

import static android.service.controls.ControlsProviderService.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    TextView textViewRegisterLink;
    EditText Username, Password;
    FirebaseFirestore db    ;
    CollectionReference Ref;
    Button Login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);
        textViewRegisterLink = findViewById(R.id.textViewRegisterLink);
        db = FirebaseFirestore.getInstance();
        Ref =db.collection("userLab4");



        textViewRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots)
                        { User user = documentSnapshot.toObject(User.class);
                            String UserNamedb = user.getUserName();
                            String Passworddb = user.getPassword();

                            String mUserName = Username.getText().toString();
                            String mPassword = Password.getText().toString();

                            if(mUserName.equals(UserNamedb) && mPassword.equals(Passworddb))
                            {
                                String Fullname = user.getFullName();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("Fullname", Fullname);
                                startActivity(intent);
                            }

                        }
                        Toast.makeText(LoginActivity.this, "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

                );
            }
        });

    }
}