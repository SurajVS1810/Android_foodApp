package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    TextView t,tprofile;
    CDB db;
    String s2,s3,s1;
    List<Ccart> recList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db=new CDB(this);
        t=(TextView)findViewById(R.id.t1);
        tprofile=(TextView)findViewById(R.id.tprofile);
        Bundle b=getIntent().getExtras();
        s1=b.getString("name");
        s2=b.getString("un");
        s3=b.getString("pw");
        tprofile.setText(s2);
        t.setText("Welcome "+s1+"\n To Food Court");
    }

    public void onSignout(View v){
        Intent obj=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(obj);
    }
    public void onProfile(View v){
        Intent obj=new Intent("act_profile");
        obj.putExtra("name",s1);
        obj.putExtra("un",s2);
        obj.putExtra("pw",s3);
        startActivity(obj);
    }
    public void onBurger(View v){
        Intent obj=new Intent("act_burger");
        obj.putExtra("un",s2);
        startActivity(obj);
    }
    public void onCart(View v){
        List<Ccart> rec=db.getcart(s2);
        String str="";
        for(Ccart cr:rec){
            String log="Foodname: "+cr.foodname+"c_id: "+cr.c_id+"Quantity: "+cr.quantity+"Price: "+cr.price+"username: "+cr.username;
            log=log+"\n";
            str=str+log;
        }
        Intent obj=new Intent("act_cart");
        obj.putExtra("un",s2);
        obj.putExtra("cart",str);
        startActivity(obj);
    }

    public void onOrder(View v){
        Intent obj=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(obj);
    }
}