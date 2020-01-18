package com.example.explorekarachi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        if(Data.mylist.isEmpty())
        {
            Toast.makeText(this, "List is empty", Toast.LENGTH_SHORT).show();
            TextView error = findViewById(R.id.textView3);
            error.setText("List is Empty");
            Button b = findViewById(R.id.button11);
            b.setClickable(false);
        }
        else
        {

            mRecyclerView = findViewById(R.id.recyclerView2);
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdapter(Data.mylist);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(final int position) {
                    Toast.makeText(MyList.this, Data.mylist.get(position).getText1(), Toast.LENGTH_SHORT).show();
                    new AlertDialog.Builder(MyList.this)
                            .setTitle("Location")
                            .setMessage("Do you wish to View on map")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MyList.this, "Dialog", Toast.LENGTH_SHORT).show();
                                    Data.latitude = Data.mylist.get(position).getLongitude();
                                    Data.longituide = Data.mylist.get(position).getLocation();
                                    Intent i = new Intent(MyList.this,ViewMap.class);
                                    startActivity(i);
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Toast.makeText(MyList.this, "Added to List", Toast.LENGTH_SHORT).show();
                                    //Data.mylist.add(Data.mylist.get(position));
                                }
                            })
                            .show();
                }
            });
        }
    }
    public void opencomp(View view)
    {
        Intent i = new Intent(this,ViewCompleteeMap.class);
        startActivity(i);
    }
    public void clearlist(View view)
    {

        new AlertDialog.Builder(MyList.this)
                .setTitle("Location")
                .setMessage("Do you wish to clear the List")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Data.mylist = new ArrayList<example_item>();
                        Intent i = new Intent(MyList.this,pickLocation.class);
                        startActivity(i);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MyList.this, "Added to List", Toast.LENGTH_SHORT).show();
                        //Data.mylist.add(Data.mylist.get(position));
                    }
                })
                .show();


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
        Intent setIntent = new Intent(this,LocationList.class);
        startActivity(setIntent);
    }
}
//serperate list logic here