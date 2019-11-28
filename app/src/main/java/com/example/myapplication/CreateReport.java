package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class CreateReport extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    EditText e1, e2;
    Button b1;
    TextView t1;
    Switch s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report);

        t1=findViewById(R.id.t1);
        s1=findViewById(R.id.s1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        b1=findViewById(R.id.b1);

        s1.setText("(In-Progress)");
        s1.setOnCheckedChangeListener(this);

        Intent intent = getIntent();
        int key = intent.getIntExtra("key", 0);
        switch(key)
        {
            case 0:e1.setText(getResources().getString(R.string.str1));
            break;
            case 1:e1.setText(getResources().getString(R.string.str2));
            break;
            case 2:e1.setText(getResources().getString(R.string.str3));
            break;
            case 3:e1.setText(getResources().getString(R.string.str4));
            break;
            case 4:e1.setText(getResources().getString(R.string.str5));
            break;
        }

    }

    public void SaveReport(View v)
    {
        //Save report
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            s1.setText("(Completed)");
        }
        else
        {
            s1.setText("(In-Progress)");
        }
    }
}
