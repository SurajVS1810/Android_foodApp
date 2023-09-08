package com.example.login_register;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Cart extends AppCompatActivity {
    TextView t1;
    CDB db;
    String s,cart;
//    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);
        db=new CDB(this);
        Bundle b=getIntent().getExtras();
        s=b.getString("un");
        cart=b.getString("cart");

//        rec=b.getParcelableArray("rec");

        t1=(TextView)findViewById(R.id.t1);
        t1.setText(cart);
      //  sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
//        ed1.setText(sp.getString("un","").toString());
//        ed2.setText(sp.getString("up","").toString());
    }

}