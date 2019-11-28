package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PatientList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText e1;
    ListView l1;
    TextView t1;

    ArrayList<String> patients=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        e1=findViewById(R.id.e1);
        l1=findViewById(R.id.l1);
        t1=findViewById(R.id.t1);

        patients.add(getResources().getString(R.string.n1));
        patients.add(getResources().getString(R.string.n2));
        patients.add(getResources().getString(R.string.n3));
        patients.add(getResources().getString(R.string.n4));
        patients.add(getResources().getString(R.string.n5));
        patients.add(getResources().getString(R.string.n6));
        patients.add(getResources().getString(R.string.n7));

        ArrayAdapter adaptor=new ArrayAdapter(this, R.layout.white_list_text, patients);
        l1.setAdapter(adaptor);

        l1.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //create click functionality, this can lead to another activity PatientDetails
    }
}
