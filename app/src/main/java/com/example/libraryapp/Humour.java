package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Humour extends AppCompatActivity {
ListView li;
ArrayList<bookstructure> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humour);

        li= findViewById(R.id.humourid);

        dbclass db = new dbclass(Humour.this);


        data = db.getalloil();
        final Adapteruser a = new Adapteruser(data,Humour.this);
        li.setAdapter(a);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                bookstructure b = data.get(i);
                if(b.isIsselected())
                {
                    b.setIsselected(true);
                }
                else
                    b.setIsselected(false);
                data.set(i,b);
                a.updaterecord(data);
            }
        });

    }


}



