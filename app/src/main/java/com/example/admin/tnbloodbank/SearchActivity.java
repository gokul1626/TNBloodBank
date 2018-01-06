package com.example.admin.tnbloodbank;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SearchActivity extends AppCompatActivity {

    public EditText area;
    public Spinner blood;
    public Button search;
    public String district;
    public String bloodgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        area = (EditText)findViewById(R.id.etdistrict);
        blood = (Spinner)findViewById(R.id.spbloodgroup);
        search = (Button)findViewById(R.id.btsearch);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                district = area.getText().toString().toUpperCase();
                bloodgroup = blood.getSelectedItem().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success)
                            {   Log.d("MyTag",jsonResponse.toString());
                                String name = jsonResponse.getString("name");
                                String sex = jsonResponse.getString("sex");
                                String phone_whatsapp_no = jsonResponse.getString("phone_whatsapp_no");
                                String email_id = jsonResponse.getString("email_id");
                                String address = jsonResponse.getString("address");
                                String previous_donationn = jsonResponse.getString("previous_donationn");


                                Intent intent = new Intent(SearchActivity.this,DisplayActiviy.class);
                                intent.putExtra("name", name);
                                intent.putExtra("sex", sex);
                                intent.putExtra("bloodgroup", bloodgroup);
                                intent.putExtra("phone_whatsapp_no", phone_whatsapp_no);
                                intent.putExtra("email_id", email_id);
                                intent.putExtra("address", address);
                                intent.putExtra("district", district);
                                intent.putExtra("previous_donationn", previous_donationn);

                                startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                                builder.setMessage("Search failed for this DISTRICT please enter any nearby DISTRICT")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                Search_request search_request = new Search_request(district,bloodgroup, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SearchActivity.this);
                queue.add(search_request);
            }
        });

    }
}
