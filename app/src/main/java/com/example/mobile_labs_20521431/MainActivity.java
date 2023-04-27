package com.example.mobile_labs_20521431;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.HashMap;
import java.util.Map;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button AddBtn, GetBtn;
    EditText InName, Inphone;
    TextView textViewData;

    FirebaseFirestore db;
    CollectionReference Ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AddBtn= findViewById(R.id.addBtn);
        GetBtn= findViewById(R.id.getBtn);
        InName= findViewById(R.id.inputName);
        Inphone = findViewById(R.id.inputPhone);
        textViewData = findViewById(R.id.tvData);

        db = FirebaseFirestore.getInstance();
        Ref =db.collection("users");




        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = InName.getText().toString();
                int Phone = Integer.parseInt(Inphone.getText().toString());
                Infor user = new Infor(Name,Phone);

                Ref.add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Success",Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Failure",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



        GetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        String data = "";
                        for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots)
                        {
                            Infor user = documentSnapshot.toObject(Infor.class);
                            String Name = user.getName();
                            int Phone= user.getPhone();
                            if(Name != null && Phone != 0)
                            {data += "Name:  " + Name + "    Phone:" + Phone + "\n";}
                        }
                        textViewData.setText(data);

                    }
                });
            }
        });

    }

}
