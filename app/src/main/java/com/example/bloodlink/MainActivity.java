package com.example.bloodlink;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
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
        //CHEAK IF APPLICATION IS OPENED FOR FIRST TIME
        SharedPreferences preferences= getSharedPreferences("PREFERANCE",MODE_PRIVATE);
        String FirstTime = preferences.getString("FirstTimeInstall", "");
        String Sname = preferences.getString("Name","");
        String SPhone = preferences.getString("Phone","");

        if(FirstTime.equals("Yes")){
            Intent next = new Intent(MainActivity.this, request_list.class);
            startActivity(next);
        }


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
                    //ONES PAGE FILLED IT DOES NOT RETURN BACK SO CHANGE VARIABLE(PERMANANTELY).
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("FirstTimeInstall","Yes");
                    editor.putString("Name",name);
                    editor.putString("Phone",phone1);
                    editor.apply();
                    Intent next = new Intent(MainActivity.this, request_list.class);
                    startActivity(next);
                }
            }
        });
    }

}