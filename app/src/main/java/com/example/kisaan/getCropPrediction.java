package com.example.kisaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class getCropPrediction extends AppCompatActivity {
    EditText N,P,K,temperature,humidity,ph,rainfall;
    Button predict,back;
    ProgressBar pp;
    TextView result,header,details;
    ImageView imagee,imagee2;
    String url = "https://crop-recommendation-45.herokuapp.com/predict";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_crop_prediction);


        N=findViewById(R.id.nitogen);
        P=findViewById(R.id.phosphorus);
        K=findViewById(R.id.pottasium);
        temperature=findViewById(R.id.temp);
        humidity=findViewById(R.id.humidity);
        ph=findViewById(R.id.ph);
        rainfall=findViewById(R.id.rainn);
        predict=findViewById(R.id.enterBtn);
        result=findViewById(R.id.text222);
        pp=findViewById(R.id.progressBarinput);
        back=findViewById(R.id.backto);
        header=findViewById(R.id.text2);
        imagee=findViewById(R.id.imageViewC);
        imagee2=findViewById(R.id.imageViewCback);
        details=findViewById(R.id.texttviewC);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ssecondActivityyIntent = new Intent(getCropPrediction.this,MainActivity.class);
                startActivity(ssecondActivityyIntent);
            }
        });
        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hit the ApI
                pp.setVisibility(View.VISIBLE);
                StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("placement");
                            result.setText(data);
                            header.setVisibility(View.INVISIBLE);
                            N.setVisibility(View.INVISIBLE);
                            P.setVisibility(View.INVISIBLE);
                            K.setVisibility(View.INVISIBLE);
                            temperature.setVisibility(View.INVISIBLE);
                            humidity.setVisibility(View.INVISIBLE);
                            ph.setVisibility(View.INVISIBLE);
                            rainfall.setVisibility(View.INVISIBLE);
                            predict.setVisibility(View.INVISIBLE);
                            pp.setVisibility(View.INVISIBLE);
                            if(data.matches("rice"))
                            {
                                imagee.setImageResource(R.drawable.ricecrop);
                                details.setText("The plant is grown on submerged land in the coastal plains, tidal deltas, and river basins of tropical, semitropical, and temperate regions. The seeds are sown in prepared beds, and when the seedlings are 25 to 50 days old, they are transplanted to a field, or paddy, that has been enclosed by levees and submerged under 5 to 10 cm (2 to 4 inches) of water, remaining submerged during the growing season. ");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("maize"))
                            {
                                imagee.setImageResource(R.drawable.maizecrop);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("jute"))
                            {
                                imagee.setImageResource(R.drawable.jutecrop);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("cotton"))
                            {
                                imagee.setImageResource(R.drawable.cottoncrop);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("coconut"))
                            {
                                imagee.setVisibility(View.VISIBLE);
                                imagee.setImageResource(R.drawable.coconutcroopmain);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                                details.setText("");
                            }
                            else if(data.matches("papaya"))
                            {
                                imagee.setImageResource(R.drawable.papaya);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("watermelon"))
                            {
                                imagee.setImageResource(R.drawable.watermelon);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("orange"))
                            {
                                imagee.setImageResource(R.drawable.orangee);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("apple"))
                            {
                                imagee.setImageResource(R.drawable.apple);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("grape"))
                            {
                                imagee.setImageResource(R.drawable.grapess);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("banana"))
                            {
                                imagee.setImageResource(R.drawable.banana);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("pomegranate"))
                            {
                                imagee.setImageResource(R.drawable.bedona);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("lentil"))
                            {
                                imagee.setImageResource(R.drawable.dall);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("blackgram"))
                            {
                                imagee.setImageResource(R.drawable.blackgram);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("mungbean"))
                            {
                                imagee.setImageResource(R.drawable.mungbean);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("mothbean"))
                            {
                                imagee.setImageResource(R.drawable.mothbean);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("kidneybean"))
                            {
                                imagee.setImageResource(R.drawable.kidneybeans);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("chickpea"))
                            {
                                imagee.setImageResource(R.drawable.chickpea);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }
                            else if(data.matches("coffee"))
                            {
                                imagee.setImageResource(R.drawable.coffee);
                                details.setText("");
                                imagee.setVisibility(View.VISIBLE);
                                imagee2.setVisibility(View.VISIBLE);
                                details.setVisibility(View.VISIBLE);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getCropPrediction.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("N",N.getText().toString());
                        params.put("P",P.getText().toString());
                        params.put("K",K.getText().toString());
                        params.put("temperature",temperature.getText().toString());
                        params.put("humidity",humidity.getText().toString());
                        params.put("ph",ph.getText().toString());
                        params.put("rainfall",rainfall.getText().toString());
                        return params;

                    }
                };
                RequestQueue queue = Volley.newRequestQueue(getCropPrediction.this);
                queue.add(stringRequest);
            }
        });


    }
    }



