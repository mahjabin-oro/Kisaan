package com.example.kisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class spashscreen extends AppCompatActivity {
    Animation leftanim,rightanim;
    ImageView logo,logotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spashscreen);
        leftanim= AnimationUtils.loadAnimation(this
                ,R.anim.left_right_animation);
        rightanim= AnimationUtils.loadAnimation(this ,R.anim.right_left_animation);
        logo=findViewById(R.id.logo);
        logotext=findViewById(R.id.logotext);
        logo.setAnimation(rightanim);
        logotext.setAnimation(leftanim);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();



        if( firebaseUser != null) {
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }
        else {
            final Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(), register.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }





    }
    }
