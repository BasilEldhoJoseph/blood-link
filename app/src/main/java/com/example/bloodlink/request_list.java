package com.example.bloodlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class request_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);
        //STORE THE VALUE PERMENTENTLY
        SharedPreferences sp = getApplicationContext().getSharedPreferences("PREFERANCE", Context.MODE_PRIVATE);
        String name = sp.getString("Name", "");
        String phone = sp.getString("Phone", "");

        //CREATE VARIABLES FOR MAKING CHANGES FOR TEXT VIEW
        TextView name1 = (TextView) findViewById(R.id.name1);
        TextView phone1 = (TextView) findViewById(R.id.phone1);
        //ACCEPT DATA FROM MAIN ACTIVITY
        name1.setText(name);
        phone1.setText(phone);
    }
}
