package com.example.kisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
   Button back, call, post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        back=findViewById(R.id.toto);
        call=findViewById(R.id.callldi);
        post=findViewById(R.id.postdi);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ssecondActivityyIntent = new Intent(MainActivity3.this,MainActivity.class);
                startActivity(ssecondActivityyIntent);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ssssecondActivityyIntent = new Intent(MainActivity3.this,Callforhelp.class);
                startActivity(ssssecondActivityyIntent);
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent essecondActivityyIntent = new Intent(MainActivity3.this,MainImage.class);
                startActivity(essecondActivityyIntent);
            }
        });
    }
}