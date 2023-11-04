package com.example.bloodlink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class request_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);
        //CREATE VARIABLES FOR MAKING CHANGES FOR TEXT VIEW
        TextView name1 = (TextView) findViewById(R.id.name1);
        TextView phone1 =(TextView) findViewById(R.id.phone1);
        //ACCEPT DATA FROM MAIN ACTIVITY
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String name= extras.getString("key1");
            name1.setText(name);
            String phone= extras.getString("key2");
            phone1.setText(phone);
        }

    }
}