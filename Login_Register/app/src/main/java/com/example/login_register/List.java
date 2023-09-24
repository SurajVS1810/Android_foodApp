package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    CDB db;
    String s1,s2,s3,s4,s5;
    String s="";
    String f="";
    String q="";
    String p="";
    Integer i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Bundle b=getIntent().getExtras();
        t1=(TextView)findViewById(R.id.t11);
        t2=(TextView)findViewById(R.id.t12);
        t3=(TextView)findViewById(R.id.t13);
        t4=(TextView)findViewById(R.id.t14);
        s1=b.getString("un");
        s2=b.getString("foodname");
        for(int i=10;i<s2.length();i++){
            f=f+s2.charAt(i);
        }
        s3=b.getString("cart_id");
        for(int i=6;i<s3.length();i++){
            s=s+s3.charAt(i);
        }
        s4=b.getString("quantity");
        for(int i=10;i<s4.length();i++){
            q=q+s4.charAt(i);
        }
        s5=b.getString("prize");
        for(int i=7;i<s5.length();i++){
            p=p+s5.charAt(i);
        }
        t1.setText(s2);
        t2.setText(s);
        t3.setText(s4);
        t4.setText(s5);

        db=new CDB(this);
    }
    public void onDelete(View v) {
        db.deletecart(Integer.parseInt(s));
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_LONG).show();
    }
    public void onPlace(View v) {
        Corder rec=new Corder();
        rec.foodname=f;
        rec.price=p;
        rec.quantity=q;
        rec.username=s1;
        db.Insertorder(rec);
        Toast.makeText(this, "Successfully Order Placed", Toast.LENGTH_LONG).show();
    }

    public void onBack(View v) {
        Intent obj=new Intent("act_cart");
        obj.putExtra("un",s1);
        startActivity(obj);
    }


}