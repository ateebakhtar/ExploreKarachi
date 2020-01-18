package com.example.explorekarachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class pickLocation extends AppCompatActivity implements View.OnClickListener {

    private CardView dha, saddar, nazimabad,all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_location);

        all = findViewById(R.id.allClick);
        dha = findViewById(R.id.DefenceClick);
        saddar = findViewById(R.id.saddarClick);
        nazimabad = findViewById(R.id.nazimabadClick);
        //dha.setOnClickListener(this);
        ///saddar.setOnClickListener(this);
        //nazimabad.setOnClickListener(this);
        //all.setOnClickListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Choose A Place To Explore");

        actionBar.setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,CreateAccount.class);
        startActivity(intent);

    }
    public void opennaz(View view)
    {
        Data.pos = 1;
        Intent intent = new Intent(this,enterData.class);
        startActivity(intent);
    }
    public void opendef(View view)
    {
        Data.pos = 2;
        Intent intent = new Intent(this,enterData.class);
        startActivity(intent);
    }
    public void opensad(View view)
    {
        Data.pos = 3;
        Intent intent = new Intent(this,enterData.class);
        startActivity(intent);
    }
    public void openall(View view)
    {
        Data.pos = 0;
        Intent intent = new Intent(this,enterData.class);
        startActivity(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {

            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        //Log.d("CDA", "onBackPressed Called");
        Intent setIntent = new Intent(this,splashScreeen.class);
        startActivity(setIntent);
    }
}
