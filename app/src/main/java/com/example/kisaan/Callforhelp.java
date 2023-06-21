package com.example.kisaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Callforhelp extends AppCompatActivity {
    TextView phoneNo;
    FloatingActionButton callbtn;
    static int PERMISSION_CODE= 100;
    Button back;
    private Spinner spinner;
    public String districtt;
    private ArrayAdapter<CharSequence> districtAdapter;
    public String phoneno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callforhelp);

        phoneNo = findViewById(R.id.editTextPhone);
        callbtn = findViewById(R.id.callbtn);
        back = findViewById(R.id.backfromcall);
        spinner=findViewById(R.id.districtcall);

        districtAdapter= ArrayAdapter.createFromResource(this,R.array.array_districts, R.layout.spinner_layout);
        districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(districtAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                districtt=  districtAdapter.getItem(i).toString();
                if(districtt.matches("Rajshahi")){
                    phoneno="+8801771254912";
                }
                 else if(districtt.matches("Dhaka")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Khulna")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Barishal")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Sylhet")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Chittagong")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Mymensingh")){
                    phoneno="+8801771254912";
                }
                else if(districtt.matches("Rangpur")){
                    phoneno="+8801771254912";
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });



        if (ContextCompat.checkSelfPermission(Callforhelp.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(Callforhelp.this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CODE);

        }

        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+phoneno));
                startActivity(i);

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sssecondActivityyIntent = new Intent(Callforhelp.this,MainActivity.class);
                startActivity(sssecondActivityyIntent);
            }
        });






    }
}