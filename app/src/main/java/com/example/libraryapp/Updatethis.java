package com.example.libraryapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Updatethis extends AppCompatActivity {

    String name,category,location;
    int price,weight;
    int itemid;

    EditText edname,edcatagory,edweight,edprice,edlocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatethis);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        category = bundle.getString("category");
        price =  bundle.getInt("price");
        itemid = bundle.getInt("itemid");
        location = bundle.getString("location");
        weight =  bundle.getInt("weight");

        edname = findViewById(R.id.edname);
        edcatagory = findViewById(R.id.edcatagory);
        edweight= findViewById(R.id.edweight);
        edprice=findViewById(R.id.edprice);
        edlocation=findViewById(R.id.edlocation);


        //edname = (EditText) findViewById(R.id.edname);
       /* edauthor = (EditText) findViewById(R.id.edaut);
        ednum=(EditText)findViewById(R.id.edno);
        edcategory=findViewById(R.id.edcat);*/
        edname.setText(name);
        edcatagory.setText(category);
        edweight.setText(""+weight);
        edprice.setText(""+price);
        edlocation.setText(location);

    }

    public void addnewbook(View view) {

        String name = edname.getText().toString();
        String category = edcatagory.getText().toString();
        String location = edlocation.getText().toString();

        int weight = Integer.parseInt(edweight.getText().toString());
        int price = Integer.parseInt(edprice.getText().toString());


        dbclass db = new dbclass(Updatethis.this);
        db.updateBook(name,category,weight,itemid,price,location);

        Toast.makeText(Updatethis.this,"Data Updated successfully!!",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Updatethis.this,MainActivity.class);
        startActivity(intent);

    }
}
