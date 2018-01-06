package com.example.admin.tnbloodbank;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ThirdMainActivity extends AppCompatActivity {

    public EditText usermailId, userpassword;
    public Button submit;
    public String email_id;
    public String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_main);

        usermailId = (EditText) findViewById(R.id.etemailid);
        userpassword = (EditText) findViewById(R.id.etuserpassword);

        submit = (Button) findViewById(R.id.btnsubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email_id = usermailId.getText().toString();
                password = userpassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success)
                            {
                                Intent intent = new Intent(ThirdMainActivity.this, ToEditDetailsActivity.class);
                                startActivity(intent);

                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdMainActivity.this);
                                builder.setMessage("Login failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


                Login_request login_request = new Login_request(email_id, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ThirdMainActivity.this);
                queue.add(login_request);
            }
        });
    }

}




