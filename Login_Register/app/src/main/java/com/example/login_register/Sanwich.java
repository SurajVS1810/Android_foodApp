package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sanwich extends AppCompatActivity {
    TextView t4,t6,t7,t8,tprofile;
    CDB db;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanwich);
        db=new CDB(this);
        Bundle b=getIntent().getExtras();
        s=b.getString("un");
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t4=(TextView)findViewById(R.id.t4);
        tprofile=(TextView)findViewById(R.id.tprofile);
        tprofile.setText(s);
    }
    public void AddCart(View v){
        Ccart rec=new Ccart();
        rec.foodname=t4.getText().toString();
        rec.price=t8.getText().toString();
        rec.quantity=t7.getText().toString();
        rec.username=tprofile.getText().toString();
        db.AddCart(rec);
        Toast.makeText(this, "Successfully Added to cart", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(this, Cart.class);
//        intent.putExtra("buttonClicked", true);
//        startActivity(intent);
//        finishAndRemoveTask();
//        SharedPreferences sp;
//        sp=getSharedPreferences("SD", Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed=sp.edit();
//        ed.putString("un",ed1.getText().toString());
//        ed.putString("up",ed2.getText().toString());
//        ed.commit();
//        Intent obj=new Intent("act_cart");
//        obj.putExtra("un",s);
    }

    public void Add(View v){
        String s3= t7.getText().toString();
        int i=Integer.parseInt(s3);
        i++;
        String str=String.valueOf(i);
        t7.setText(str);
        String s2= t6.getText().toString();
        int n2=Integer.parseInt(s2);
        int n=i*n2;
        String tp=String.valueOf(n);
        t8.setText(tp);
    }

    public void Minus(View v){
        String s4= t7.getText().toString();
        int i=Integer.parseInt(s4);
        if(i!=0) {
            i--;
            String str = String.valueOf(i);
            t7.setText(str);
            String s2= t6.getText().toString();
            int n2=Integer.parseInt(s2);
            int n=i*n2;
            String tp=String.valueOf(n);
            t8.setText(tp);
        }
    }
    public void goCart(View v){
        Intent obj=new Intent("act_cart");
        obj.putExtra("un",s);
        startActivity(obj);
    }
}