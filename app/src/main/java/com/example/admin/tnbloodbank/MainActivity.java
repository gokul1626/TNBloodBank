package com.example.admin.tnbloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public Button btn;
    public void init()
    {
        btn=(Button)findViewById(R.id.btnregister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(MainActivity.this, SecondMainActivity.class);
                startActivity(reg);
            }
        });
    }
    public Button bt;
    public void login()
    {
        bt=(Button)findViewById(R.id.btnlogin);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,ThirdMainActivity.class);
                startActivity(login);
            }
        });

    }
    public Button btsearch;
    public void search()
    {
        btsearch=(Button)findViewById(R.id.btndetails);
        btsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent search_details = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(search_details);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        login();
        search();
    }
}
