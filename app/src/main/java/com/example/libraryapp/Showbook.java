package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Showbook extends AppCompatActivity {
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbook);
        lv= findViewById(R.id.showbooks);


    }

   /* public void add(View view) {
        dbclass db = new dbclass(Showbook.this);
        db.showbooks(name,author,number,category);
        Toast.makeText(Showbook.this, "update sucessfully", Toast.LENGTH_SHORT).show();
    }*/
}
