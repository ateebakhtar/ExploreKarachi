package com.example.explorekarachi;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class CreateAccount extends AppCompatActivity {

    EditText x;
    EditText x1;
    EditText x2;
    EditText x3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        x = findViewById(R.id.editText);
        x1 = findViewById(R.id.editText2);
        x2 = findViewById(R.id.editText3);
        x3 = findViewById(R.id.editText4);

    }

    int u = 0;
    void setu()
    {
        u = 1;
    }
    public void setdata(View view)
    {
        UserData m = new UserData();
        final String temp = x.getText().toString();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("User")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(Task<QuerySnapshot> task) {
                        String x3 = null, x1 = null, x2 = null,x4 = null;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot x : task.getResult())
                            {
                                System.out.println("SOMEGING");
                                if(x.getString("username").equals(temp))
                                {
                                    setu();
                                    break;
                                }
                            }

                        }
                        else
                        {
                            System.out.println("Eorrrosr");
                        }
                    }
                });

        if(x.getText().length() < 3 || x.getText() == null)
        {
            x.setError("Username is to Small");
            Toast.makeText(this, "UserName is to Small", Toast.LENGTH_LONG).show();
        }
        else if(x.getText().length() > 20)
        {
            x.setError("Username is to Large");
            Toast.makeText(this, "UserName is to Large", Toast.LENGTH_LONG).show();
        }
        else if(x1.getText().length() < 8 || x1.getText() == null)
        {
            x1.setError("Password is to Small");
            Toast.makeText(this, "Password is to Small", Toast.LENGTH_LONG).show();
        }
        else if(x3.getText().length() < 8 || x3.getText() == null)
        {
            x3.setError("Enter Valid Number");
            Toast.makeText(this, "Enter Valid Number", Toast.LENGTH_LONG).show();
        }
        else if(android.util.Patterns.EMAIL_ADDRESS.matcher(x2.getText().toString()).matches() == false || x2.getText() == null)
        {
            x2.setError("Enter Valid Email");
            Toast.makeText(this, "Enter Valid Email", Toast.LENGTH_LONG).show();
        }
        else
        {
            m.setdata(x.getText().toString(),x1.getText().toString(),x2.getText().toString(),x3.getText().toString());
            //FirebaseFirestore db = FirebaseFirestore.getInstance();
            db.collection("User").add(m);
            Intent p = new Intent(this,pickLocation.class);
            startActivity(p);
        }
    }
    public void opencreate(View view)
    {
        Intent i = new Intent(this,CreateAccount.class);
        startActivity(i);
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
        Intent setIntent = new Intent(this,Login.class);
        startActivity(setIntent);
    }
}
