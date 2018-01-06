package com.example.admin.tnbloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActiviy extends AppCompatActivity {

    public TextView username;
    public TextView gender;
    public TextView blood;
    public TextView phone;
    public TextView mail;
    public TextView adrs;
    public TextView area;
    public TextView donation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_activiy);
        username = (TextView)findViewById(R.id.tvname);
        gender = (TextView)findViewById(R.id.tvsex);
        blood = (TextView)findViewById(R.id.tvbloodgroup);
        phone = (TextView)findViewById(R.id.tvphone);
        mail = (TextView)findViewById(R.id.tvemailid);
        adrs = (TextView)findViewById(R.id.tvaddress);
        area = (TextView)findViewById(R.id.tvdistrict);
        donation = (TextView)findViewById(R.id.tvpreviousdonation);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String sex = intent.getStringExtra("sex");
        String bloodgroup = intent.getStringExtra("bloodgroup");
        String phone_whatsapp_no = intent.getStringExtra("phone_whatsapp_no");
        String email_id = intent.getStringExtra("email_id");
        String address = intent.getStringExtra("address");
        String district = intent.getStringExtra("district");
        String previous_donationn = intent.getStringExtra("previous_donationn");

        username.setText(name);
        gender.setText(sex);
        blood.setText(bloodgroup);
        phone.setText(phone_whatsapp_no);
        mail.setText(email_id);
        adrs.setText(address);
        area.setText(district);
        donation.setText(previous_donationn);




    }
}
