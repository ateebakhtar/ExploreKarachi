package com.example.explorekarachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class enterData extends AppCompatActivity {
    Spinner time;
    Spinner people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        time = findViewById(R.id.spinner2);
        //people = findViewById(R.id.spinner);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        String[] objects = {"1 person","3 or less","5 or less","more than 5"};
        String[] objects2 = {"1 Hour","less than 3 hours","more than 3 hours"};

        //s = findViewById(R.id.spinner3);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1 ,objects);
        time.setAdapter(adapter);


    }
    public void openit(View view)
    {
 //       Data.people = people.getSelectedItem().toString();
        Data.people = time.getSelectedItem().toString();

        Intent i = new Intent(this,LocationList.class);
        startActivity(i);
    }
}
