package com.example.kisaan;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

public class getFertilizerPrediction extends AppCompatActivity {
    EditText temp,humid,mois,nitro,pota, phos;
    Spinner soil,crop;
    Button predict,back;
    TextView result,headlinee,details;
    ProgressBar pp;
    ImageView croppic,pic;
    static String cropname,cropvalue,soilname,soilvalue;
    private ArrayAdapter<CharSequence> soiladpater,cropadapter;
    String url = "https://fertilizer-recomm-45.herokuapp.com/predict";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_fertilizer_prediction);
        temp=findViewById(R.id.ferttemp);
        humid=findViewById(R.id.ferthumid);
        mois=findViewById(R.id.fertmois);
        soil=findViewById(R.id.soilfret);
        crop=findViewById(R.id.fertcrop);
        nitro=findViewById(R.id.fertnitro);
        pota=findViewById(R.id.potafert);
        phos =findViewById(R.id.phosfert);
        predict=findViewById(R.id.sbmtBtn);
        back=findViewById(R.id.backtohomee);
        pp=findViewById(R.id.progressBarinput2);
        result=findViewById(R.id.text21);
        details=findViewById(R.id.details);
        headlinee=findViewById(R.id.text2111);
        croppic=findViewById(R.id.fertimage);
        pic=findViewById(R.id.fertimage2);


        soiladpater=ArrayAdapter.createFromResource(this,R.array.array_soiltype, R.layout.spinner_layout);
        soiladpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soil.setAdapter(soiladpater);
        soil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                soilname=  soiladpater.getItem(i).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        cropadapter=ArrayAdapter.createFromResource(this,R.array.array_crops, R.layout.spinner_layout);
        cropadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crop.setAdapter(cropadapter);
        crop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cropname=cropadapter.getItem(i).toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ssecondActivityyIntent = new Intent(getFertilizerPrediction.this,MainActivity.class);
                startActivity(ssecondActivityyIntent);
            }
        });

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hit the ApI
                pp.setVisibility(VISIBLE);
                StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("placement1");
                            result.setText(data);
                            headlinee.setVisibility(INVISIBLE);
                            predict.setVisibility(INVISIBLE);
                            temp.setVisibility(INVISIBLE);
                            humid.setVisibility(INVISIBLE);
                            mois.setVisibility(INVISIBLE);
                            soil.setVisibility(INVISIBLE);
                            crop.setVisibility(INVISIBLE);
                            nitro.setVisibility(INVISIBLE);
                            pota.setVisibility(INVISIBLE);
                            phos.setVisibility(INVISIBLE);
                            pp.setVisibility(INVISIBLE);
                            if(data.matches("DAP"))
                            {
                                croppic.setImageResource(R.drawable.dap);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("Di-ammonium Phosphate popularly known as DAP is a preferred fertilizer in Bangladesh because it contains both Nitrogen and Phosphorus which are primary macro-nutrients and part of 18 essential plant nutrients. DAP (NH4)2HPO4: Fertilizer grade DAP Contains 18% Nitrogen and 46% Phosphorus (P2O5)");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("10-26-26"))
                            {
                                croppic.setImageResource(R.drawable.gromor102626);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("10:26:26 is a complex fertiliser containing all the three major plant nutrients viz. Nitrogen, Phosphorous and Potassium. It contains Phosphorous and Potassium in the ratio of 1:1, the highest among the NPK fertilisers.");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("14-35-14"))
                            {
                                croppic.setImageResource(R.drawable.fert1435);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("14-35-14 is a complex fertilizer containing all major nutrients viz. Nitrogen, Phosphorous and Potassium.\n" +
                                        "\n" +
                                        "The only complex having highest total nutrient content among the NPK complex fertilisers. (Total nutrients are 63%).\n" +
                                        "\n" +
                                        "N&P are available in 1:2.5 ratio as in the case of DAP. ");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("17-17-17"))
                            {
                                croppic.setImageResource(R.drawable.fert17);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("NPK 17:17:17 is a field grade fertilizer composed of Nitrogen, Phosphorous, and potassium in balanced proportions suitable for improved production of most crops. Its Universal, can be used on all the crops (from vegetables to fruit trees)");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("20-20"))
                            {
                                croppic.setImageResource(R.drawable.fert20);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("NPK 20 20 20 is a highly concentrated, balanced plant fertiliser. It contains equal parts nitrogen, phosphorus, and potassium. It is ideal for growing plants in poor quality soils as it provides a high amount of each of the three essential plant macronutrients. ");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("28-28"))
                            {
                                croppic.setImageResource(R.drawable.fert28);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("A complex fertiliser containing 2 major nutrients, Nitrogen at 28% and Phosphorus at 28%, provides instantaneous and prolonged greenness for crops.");
                                details.setVisibility(VISIBLE);
                            }
                            else if(data.matches("Urea"))
                            {
                                croppic.setImageResource(R.drawable.urea);
                                croppic.setVisibility(VISIBLE);
                                pic.setVisibility(VISIBLE);
                                details.setText("Urea (46% N). This is the most concentrated solid nitrogen fertiliser and it is marketed in the prilled form. It is sometimes used for aerial top-dressing. In the soil, urea changes to ammonium carbonate which may temporarily cause a harmful local high pH.");
                                details.setVisibility(VISIBLE);
                            }




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getFertilizerPrediction.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("temp",temp.getText().toString());
                        params.put("humid",humid.getText().toString());
                        params.put("mois",mois.getText().toString());
                        if(soilname.matches("BLACK")||soilname.matches("Black")||soilname.matches("black"))
                        {
                            soilvalue="0";
                        }
                        else if(soilname.matches("Clayey")||soilname.matches( "CLAYEY")||soilname.matches( "clayey"))
                        {
                            soilvalue="1";
                        }
                        else if(soilname.matches("LOAMY")||soilname.matches( "LOAMY")||soilname.matches( "loamy"))
                        {
                            soilvalue="2";
                        }
                        else if(soilname.matches( "Red")||soilname.matches( "RED")||soilname.matches( "red"))
                        {
                            soilvalue="3";
                        }
                        else if(soilname.matches( "Sandy")||soilname.matches( "SANDY")||soilname.matches( "sandy"))
                        {
                            soilvalue="4";
                        }
                        params.put("soil",soilvalue.trim());

                        if(cropname.matches("BARLEY")||cropname.matches("Barley")||cropname.matches("barley"))
                        {
                            cropvalue="0";
                        }
                        else if(cropname.matches("Cotton")||cropname.matches( "COTTON")||cropname.matches( "cotton"))
                        {
                            cropvalue="1";
                        }
                        else if(cropname.matches("Ground Nuts")||cropname.matches( "GROUND NUTS")||cropname.matches( "ground nuts"))
                        {
                            cropvalue="2";
                        }
                        else if(cropname.matches( "Maize")||cropname.matches( "MAIZE")||cropname.matches( "maize"))
                        {
                            cropvalue="3";
                        }
                        else if(cropname.matches( "MILLETS")||cropname.matches( "Millets")||cropname.matches( "millets"))
                        {
                            cropvalue="4";
                        }
                        else if(cropname.matches( "OIL SEEDS")||cropname.matches( "Oil seeds")||cropname.matches( "oil seeds"))
                        {
                            cropvalue="5";
                        }
                        else if(cropname.matches( "PADDY")||cropname.matches( "Paddy")||cropname.matches( "paddy"))
                        {
                            cropvalue="6";
                        }
                        else if(cropname.matches( "Pulses")||cropname.matches( "PULSES")||cropname.matches( "pulses"))
                        {
                            cropvalue="7";
                        }
                        else if(cropname.matches( "SUGARCANE")||cropname.matches( "Sugercane")||cropname.matches( "sugercane"))
                        {
                            cropvalue="8";
                        }
                        else if(cropname.matches( "Tobacco")||cropname.matches( "TOBACCO")||cropname.matches( "tobacco"))
                        {
                            cropvalue="9";
                        }
                        else if(cropname.matches( "WHEAT")||cropname.matches( "Wheat")||cropname.matches( "wheat"))
                        {
                            cropvalue="10";
                        }

                        params.put("crop",cropvalue);
                        params.put("nitro",nitro.getText().toString());
                        params.put("pota",pota.getText().toString());
                        params.put("phos",phos.getText().toString());
                        return params;

                    }
                };
                RequestQueue queue = Volley.newRequestQueue(getFertilizerPrediction.this);
                queue.add(stringRequest);
            }
        });

    }
}