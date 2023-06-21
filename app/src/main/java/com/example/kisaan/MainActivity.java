package com.example.kisaan;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   Button getcrop;
   Button getfert;
    Button getpost;
    TextView verifyMsg;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    Button resendCode;
    Button resetPassLocal,changeProfileImage,soiltype;
    FirebaseUser user;

    DrawerLayout drawerlayoutt;
    NavigationView navigationvieww;
    Toolbar toolbarr;

    private  long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetPassLocal = findViewById(R.id.resetPasswordLocal);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        resendCode = findViewById(R.id.resendCode);
        verifyMsg = findViewById(R.id.verifyMsg);


        userId = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        drawerlayoutt = findViewById(R.id.drawer_logoutt);
        navigationvieww=findViewById(R.id.nav_view);
        toolbarr=findViewById(R.id.toolbar1);
        getfert=findViewById(R.id.extra2);
        soiltype=findViewById(R.id.extra34);
        soiltype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abczz = new Intent(MainActivity.this, MainPrediction.class);
                startActivity(abczz);
            }
        });
        setSupportActionBar(toolbarr);
        getSupportActionBar().setTitle("  ");
        navigationvieww.bringToFront();

        ActionBarDrawerToggle toggle1 = new ActionBarDrawerToggle(this,drawerlayoutt,toolbarr,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerlayoutt.addDrawerListener(toggle1);
        toggle1.syncState();

        navigationvieww.setNavigationItemSelectedListener(this);






        if(!user.isEmailVerified()){
            verifyMsg.setVisibility(View.VISIBLE);
            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification Email Has been Sent.", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag", "onFailure: Email not sent " + e.getMessage());
                        }
                    });
                }
            });
        }


        resetPassLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetPassword = new EditText(v.getContext());

                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter New Password > 6 Characters long.");
                passwordResetDialog.setView(resetPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String newPassword = resetPassword.getText().toString();
                        user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "Password Reset Successfully.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Password Reset Failed.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close
                    }
                });

                passwordResetDialog.create().show();

            }
        });

        getcrop= findViewById(R.id.extra);
        getcrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ssecondActivityIntent = new Intent(MainActivity.this,getCropPrediction.class);
                startActivity(ssecondActivityIntent);
            }
        });
        getpost=findViewById(R.id.extra3);
        getpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orooo = new Intent(MainActivity.this,MainActivity3.class);
                startActivity(orooo);
            }
        });
        getfert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oro = new Intent(MainActivity.this,getFertilizerPrediction.class);
                startActivity(oro);
            }
        });
    }




    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        Intent sfsecondActivityIntent = new Intent(MainActivity.this,login.class);
        startActivity(sfsecondActivityIntent);
        finish();
    }




    @Override
    public void onBackPressed() {
        if(drawerlayoutt.isDrawerOpen(GravityCompat.START))
        {
            drawerlayoutt.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

        if(backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;}
        else
        {
            backToast= Toast.makeText(getBaseContext(),"PRESS BACK AGAIN TO EXIT",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.drawer_logout:
                FirebaseAuth.getInstance().signOut();
                Intent kn = new Intent(MainActivity.this, login.class);
                startActivity(kn);
                finish();
                break;
            case R.id.phone:
                FirebaseAuth.getInstance().signOut();
                Intent keeen = new Intent(MainActivity.this, Callforhelp.class);
                startActivity(keeen);
                finish();
                break;
            case R.id.resetyourpass:
                resetPassLocal.performClick();
                break;
            case R.id.articles:
                Intent abcde = new Intent(MainActivity.this, agricultural_articles.class);
                startActivity(abcde);
                finish();
                break;


        }
        drawerlayoutt.closeDrawer(GravityCompat.START);
        return true;
    }



}