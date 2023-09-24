package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Order extends AppCompatActivity {
    TextView t1;
    CDB db;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        db=new CDB(this);
        Bundle b=getIntent().getExtras();
        s=b.getString("un");
        t1=(TextView)findViewById(R.id.t1);
        

    }

    public void onClear(View v){

    }
}