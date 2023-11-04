package com.example.bloodlink;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView namereq = (TextView) findViewById(R.id.namereq);
        TextView phonereq = (TextView) findViewById(R.id.phonereq);
        //CREATE VARIABLES TO ACCEPT THE STRING FROM EDIT TEXT (MAY OR MAY NOT BE IN STRING FORMAT)
        EditText editname =(EditText) findViewById(R.id.name);
        EditText editphone =(EditText) findViewById(R.id.phone);
        MaterialButton register =(MaterialButton) findViewById(R.id.register);
        //ON BUTTON CLICK
        register.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                //EDITTEXT ACCEPTED STRINGS CHANGES TO STRING FORMAT
                String name = editname.getText().toString();
                String phone1 = editphone.getText().toString();
                //CONDITIONS FOR WHETHER DATA IF GIVEN OR NOT OF NOT GIVEN DISPLAY ERROR
                if(name.equals("") || phone1.equals("")) {
                    if(name.equals("")==true) {
                        namereq.setText("  * pls enter your name");
                    }
                    else {
                        namereq.setText("");
                    }
                    if(phone1.equals("")==true) {
                        phonereq.setText("  * pls enter your number");
                    }
                    else {
                        phonereq.setText("");
                    }
                    Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();
                }
                //IF ALL CONDITIONS MET GO TO MAIN ACTIVITY 2
                else {
                    Intent next = new Intent(MainActivity.this, request_list.class);
                    //SENDING DATA TO MAIN ACTIVITY 2
                    next.putExtra("key1", name);
                    next.putExtra("key2", phone1);
                    startActivity(next);
                }
            }
        });
    }
}