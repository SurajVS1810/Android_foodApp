package com.example.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart extends AppCompatActivity {

    CDB db;
    String s;
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
        list = new ArrayList<>();
        List<Ccart> rec = db.getcart(s);

        for (Ccart cr : rec) {
            Map<String, String> item = new HashMap<>();
            item.put("line1", "Foodname: " + cr.foodname);
            item.put("line2", "c_id: " + cr.c_id);
            item.put("line3", "Price: " + cr.price + " /-");
            item.put("line4", "Quantity: " + cr.quantity);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d}
        );

        ListView lst = findViewById(R.id.listview);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Retrieve the data for the clicked item
                Map<String, String> item = (Map<String, String>) list.get(i);
                String foodname = item.get("line1");
                String c_id = item.get("line2");
                String price = item.get("line3");
                String quantity = item.get("line4");

                // Now, you can use these values to create your Intent
                Intent obj = new Intent("act_list");
                obj.putExtra("un", s);
                obj.putExtra("foodname", foodname);
                obj.putExtra("cart_id", c_id);
                obj.putExtra("prize", price);
                obj.putExtra("quantity", quantity);
                startActivity(obj);
            }
        });

    }
    public void onBack(View v){
        Intent obj=new Intent("act_login");
        obj.putExtra("un",s);
        startActivity(obj);
    }

}