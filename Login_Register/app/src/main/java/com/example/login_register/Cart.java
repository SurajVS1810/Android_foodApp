package com.example.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart extends AppCompatActivity {

    CDB db;
    String s,cart;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        db=new CDB(this);
        Bundle b=getIntent().getExtras();
        s=b.getString("un");
        cart=b.getString("cart");
        list=new ArrayList();
        List<Ccart> rec=db.getcart(s);
        String[] log=new String[4];
        for(Ccart cr:rec){
            log[0]="Foodname: "+cr.foodname;
            log[1]="c_id: "+cr.c_id;
            log[2]="Price: "+cr.price+" /-";
            log[3]="Quantity: "+cr.quantity;

            item =new HashMap<String,String>();
            item.put("line1",log[0]);
            item.put("line2",log[1]);
            item.put("line3",log[2]);
            item.put("line4",log[3]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,new String[]{"line1","line2","line3","line4"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d}
        );
        ListView lst=findViewById(R.id.listview);
        lst.setAdapter(sa);

    }
    public void onPlace(View v){

    }

}