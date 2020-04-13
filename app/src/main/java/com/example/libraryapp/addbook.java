package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class addbook extends AppCompatActivity {
    EditText edname,edcatagory,edweight,edprice,edlocation,editemid,edisselected,edkg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
        edname = findViewById(R.id.edname);
        edcatagory = findViewById(R.id.edcatagory);
        edweight= findViewById(R.id.edweight);
        edprice=findViewById(R.id.edprice);
        edlocation=findViewById(R.id.edlocation);


     //   edisselected=findViewById(R.id.edisselected);
      /*  LinearLayout constraintLayout = findViewById(R.id.layout2);
        AnimationDrawable animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
    }

    public void addnewbook(View view) {
        String name = edname.getText().toString().toLowerCase();
        String category = edcatagory.getText().toString().toLowerCase();
        String location=edlocation.getText().toString().toLowerCase();
        int weight=0;
        int price=0;
       // int number=0;
        try {
            //;number = Integer.parseInt(edno.getText().toString());
            weight = Integer.parseInt(edweight.getText().toString());
           // price = Integer.parseInt(edprice.getText().toString());
        }catch (Exception e)
        {
            Log.e("exception",e.toString());
        }
        try {
            //;number = Integer.parseInt(edno.getText().toString());
           // weight = Integer.parseInt(edweight.getText().toString());
             price = Integer.parseInt(edprice.getText().toString());
        }catch (Exception e)
        {
            Log.e("exception",e.toString());
        }
        int flag=1;
        if(name.length()==0)
        {
            edname.setError("Please Enter name!");
            flag=0;
        }
        if(category.length()==0)
        {
            edcatagory.setError("Please Enter category!");
            flag=0;
        }
        if(location.length()==0)
        {
            edlocation.setError("Please Enter location!");
            flag=0;
        }


        if(flag==1) {
            dbclass db = new dbclass(addbook.this);
            db.addbooks(name,category,weight,price,location);
            Toast.makeText(addbook.this, "added sucessfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(addbook.this, MainActivity.class);
            startActivity(i);

        }
    }
}
