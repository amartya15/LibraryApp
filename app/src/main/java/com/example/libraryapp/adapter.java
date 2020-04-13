package com.example.libraryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adapter extends BaseAdapter {
    ArrayList<bookstructure> data;
    Context c;
    LayoutInflater in;
    int itemid;

    public adapter(ArrayList<bookstructure> data, Context c) {
        this.data = data;
        this.c = c;
        in = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = in.inflate(R.layout.lists,null);
        TextView nam = v.findViewById(R.id.nam);
        TextView cat = v.findViewById(R.id.cat);
        TextView wei = v.findViewById(R.id.wei);
        TextView price = v.findViewById(R.id.price);
        TextView location = v.findViewById(R.id.location);
        CheckBox ch= v.findViewById(R.id.check);

        ImageView edit=v.findViewById(R.id.update);
        ImageView icondelete =  v.findViewById(R.id.delete);

        edit.setTag(i);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos =(int)view.getTag();
                String uname=data.get(pos).name;
                String ucategory=data.get(pos).category;
                int uweight=data.get(pos).weight;
                int uprice=data.get(pos).price;
                int uid=data.get(pos).itemid;
                String ulocation=data.get(pos).location;
                Intent intent=new Intent(c,Updatethis.class);
                intent.putExtra("name",uname);
                intent.putExtra("category",ucategory);
                intent.putExtra("weight",uweight);
                intent.putExtra("price",uprice);
                intent.putExtra("itemid",uid);
                intent.putExtra("location",ulocation);
                c.startActivity(intent);


            }
        });
        icondelete.setTag(i);
        icondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=(int)view.getTag();
                itemid = data.get(pos).itemid;
                AlertDialog.Builder alertdialogbuilder=new AlertDialog.Builder(c);
                alertdialogbuilder.setTitle("do you want to delete this item from the list ?");
                alertdialogbuilder.setMessage("click yes to delete");
                alertdialogbuilder.setCancelable(false);
                alertdialogbuilder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbclass db= new dbclass(c);
                        db.deleteBook(itemid);
                        Toast.makeText(c,"book deleted sucesfully!!!",Toast.LENGTH_LONG).show();;
                        Intent intent=new Intent(c,MainActivity.class);
                        c.startActivity(intent);
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                dialog.cancel();


            }
        });
                AlertDialog alertDialog=alertdialogbuilder.create();
                alertDialog.show();
            }
        });



        nam.setText(data.get(i).name);
        cat.setText(data.get(i).category);
        cat.setText(data.get(i).category);
        wei.setText(""+data.get(i).weight);
        price.setText(""+data.get(i).price);
        location.setText(data.get(i).location);
        ch.isChecked();

        return  v;
    }


}
