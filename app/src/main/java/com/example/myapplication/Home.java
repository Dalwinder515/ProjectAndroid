package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    ListView l1;
    TextView t1;
    Button b1, b2;
    Switch s1;

    ArrayList<String> task=new ArrayList<>(); //Object for Patient Data
    ArrayList<String> loc=new ArrayList<>();
    /*Integer[] img={R.drawable.done, R.drawable.done, R.drawable.done, R.drawable.done, R.drawable.done};
    String[] str={getResources().getString(R.string.str1), getResources().getString(R.string.str2), getResources().getString(R.string.str3),
            getResources().getString(R.string.str4), getResources().getString(R.string.str5)};
    String[] locd={getResources().getString(R.string.t1), getResources().getString(R.string.t2), getResources().getString(R.string.t3),
            getResources().getString(R.string.t4), getResources().getString(R.string.t5)};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        l1=findViewById(R.id.l1);
        t1=findViewById(R.id.t1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        s1=findViewById(R.id.s1);

        task.add(getResources().getString(R.string.str1));
        task.add(getResources().getString(R.string.str2));
        task.add(getResources().getString(R.string.str3));
        task.add(getResources().getString(R.string.str4));
        task.add(getResources().getString(R.string.str5));

        loc.add(getResources().getString(R.string.t1));
        loc.add(getResources().getString(R.string.t2));
        loc.add(getResources().getString(R.string.t3));
        loc.add(getResources().getString(R.string.t4));
        loc.add(getResources().getString(R.string.t5));

        ArrayAdapter adaptor=new ArrayAdapter(this, R.layout.white_list_text,task);
        l1.setAdapter(adaptor);

        s1.setText("(Offline)");

        l1.setOnItemClickListener(this);
        s1.setOnCheckedChangeListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(Home.this, CreateReport.class);
        intent.putExtra("key", position);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=getMenuInflater();
        inflator.inflate(R.menu.menuhome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.update)
        {
            Intent intent=new Intent(Home.this, Update.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.logout)
        {
            Intent intent=new Intent(Home.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void PatientList(View v)
    {
        Intent intent=new Intent(Home.this, PatientList.class);
        startActivity(intent);
    }

    public void ReportList(View v)
    {
        //copy PatientList data
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked)
        {
            s1.setText("(Online)");
            Toast.makeText(this, "You are now Online", Toast.LENGTH_LONG).show();
        }
        else
        {
            s1.setText("(Offline)");
            Toast.makeText(this, "You are Offline", Toast.LENGTH_LONG).show();
        }
    }
}
