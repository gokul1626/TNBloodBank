package com.example.admin.tnbloodbank;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondMainActivity extends AppCompatActivity {

    public Button done;
    public EditText username;
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    public RadioButton maleRadioButton, femaleRadioButton;
    public String name;
    public String sex;
    public Spinner spinner;
    public EditText number;
    public EditText email;
    public  EditText pass;
    public EditText adrs;
    public EditText area;
    public RadioGroup rgrp;
    public RadioButton rbtn;
    public RadioButton yesbtn,nobtn;
    public String bloodgroup;
    public String phone_whatsapp_no;
    public String email_id;
    public String password;
    public String address;
    public String district;
    public String previous_donationn;

    public static boolean validateLetters(String txt) {
        String regx = "[a-zA-Z]+\\.?";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        return matcher.find();
    }


  public Boolean validation() {




        if (name.isEmpty()) {
            Toast.makeText(SecondMainActivity.this, "Please enter the USERNAME", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!validateLetters(name)) {
            Toast.makeText(SecondMainActivity.this, "Please make sure that entered USERNAME is valid one", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (maleRadioButton.isChecked() || femaleRadioButton.isChecked()) {
            radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
            sex = radioButton.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), "Please select GENDER", Toast.LENGTH_SHORT).show();
            return false;
        }

         bloodgroup = spinner.getSelectedItem().toString();
        if (bloodgroup.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please select your BLOODGROUP", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (!Pattern.matches("[a-zA-Z]+", phone_whatsapp_no)) {
            if (phone_whatsapp_no.length() == 6 || phone_whatsapp_no.length() == 10 || phone_whatsapp_no.length() == 12 || phone_whatsapp_no.length() == 9 || phone_whatsapp_no.length() == 11) {
            } else if (phone_whatsapp_no.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please enter your NUMBER", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                Toast.makeText(getApplicationContext(), "Please enter a valid NUMBER", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please enter a valid NUMBER", Toast.LENGTH_SHORT).show();
            return false;
        }


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email_id.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please enter your EMAIL ADDRESS", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (!email_id.matches(emailPattern)) {

            Toast.makeText(getApplicationContext(), "Please enter a valid EMAIL ADDRESS", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter your PASSWORD", Toast.LENGTH_SHORT).show();
            return false;
        } else if (password.length() < 7) {
            Toast.makeText(getApplicationContext(), "Please make sure that PASSWORD length is greater dhn 6", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (address.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter your ADDRESS", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!(address.equals((String) address))) {
            Toast.makeText(getApplicationContext(), "Please enter a valid ADDRESS", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (district.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter your respective DISTRICT", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (yesbtn.isChecked() || nobtn.isChecked()) {
            rbtn = (RadioButton) findViewById(rgrp.getCheckedRadioButtonId());
            previous_donationn = rbtn.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), "Please select YES or NO", Toast.LENGTH_SHORT).show();
            return false;
        }
        return  true;
 }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rgrp=(RadioGroup)findViewById(R.id.rdyesno);
        username = (EditText) findViewById(R.id.etname);
        maleRadioButton = (RadioButton) findViewById(R.id.rdmale);
        femaleRadioButton = (RadioButton) findViewById(R.id.rdfemale);
        spinner = (Spinner) findViewById(R.id.spbloodgroup);
        number = (EditText) findViewById(R.id.etphone);
        email = (EditText) findViewById(R.id.etemailid);
        pass = (EditText) findViewById(R.id.etpassword);
        adrs = (EditText) findViewById(R.id.etaddress);
        area = (EditText) findViewById(R.id.etdistrict);
        yesbtn = (RadioButton) findViewById(R.id.rdyes);
        nobtn = (RadioButton) findViewById(R.id.rdno);




        done=(Button)findViewById(R.id.btnDone);
        done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            name = username.getText().toString();
            phone_whatsapp_no = number.getText().toString();
            email_id = email.getText().toString();
            password = pass.getText().toString();
            address = adrs.getText().toString();
            district = area.getText().toString().toUpperCase();

            if(validation())
            {
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success)
                            {
                                Intent intent=new Intent(SecondMainActivity.this,MainActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "REGISTERED successfully", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SecondMainActivity.this);
                                builder.setMessage("REGISTRATION failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {

                            e.printStackTrace();
                        }

                    }
                };

                Register_request register_request = new Register_request(name , sex, bloodgroup, phone_whatsapp_no, email_id, password, address, district, previous_donationn, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SecondMainActivity.this);
                queue.add(register_request);

            }
            }
         });
    }
    }
