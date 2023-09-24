package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order extends AppCompatActivity {
    TextView t1;
    CDB db;
    String s,cart;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        db=new CDB(this);
        Bundle b=getIntent().getExtras();
        s=b.getString("un");
        cart=b.getString("cart");


        list=new ArrayList();
        List<Corder> rec=db.getorderlist(s);
        String[] log=new String[4];
        for(Corder cr:rec){
            log[0]="Foodname: "+cr.foodname;
            log[1]="o_id: "+cr.o_id;
            log[2]="Price: "+cr.price;
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

    public void onClear(View v){
        db.deleteorder(s);
        Toast.makeText(this, "Cleared Successfully", Toast.LENGTH_LONG).show();
    }

    public void onBack(View v){
        Intent obj=new Intent("act_login");
        obj.putExtra("un",s);
        startActivity(obj);
    }
}