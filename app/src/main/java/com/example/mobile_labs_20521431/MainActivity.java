package com.example.mobile_labs_20521431;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText GrossSalary, FullName;
    ListView LV;
    protected Button CalculateBtn;
    ArrayList<NetSalary> NetList ;
    //ArrayList<NetSalary> NetList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NetList = new ArrayList<>();
        LV = findViewById(R.id.LV);
        FullName = findViewById(R.id.FullName);
        GrossSalary = findViewById(R.id.GrossSalary);
        CalculateBtn = findViewById(R.id.CalculateBtn);

        ListSalaryApdater adapter = new ListSalaryApdater (
                MainActivity.this,
                0,
                NetList);
        //khoi tao adapter
        LV.setAdapter(adapter);

        CalculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = FullName.getText().toString();
                double Salary = Double.parseDouble(GrossSalary.getText().toString());
                NetSalary NetSalary = new NetSalary(Name, Salary);  //nhan thong tin user nhap vao va tao doi tuong
                NetSalary.CalculateButton();
                NetList.add(NetSalary);
                adapter.notifyDataSetChanged();

            }
        });
    }
}