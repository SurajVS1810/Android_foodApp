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

    public void onBroasted(View v){
        Intent obj=new Intent("act_broasted");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onAlpham(View v){
        Intent obj=new Intent("act_alpham");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onSanwich(View v){
        Intent obj=new Intent("act_sanwich");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onGrilled(View v){
        Intent obj=new Intent("act_grilled");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onBucket(View v){
        Intent obj=new Intent("act_bucket");
        obj.putExtra("un",s2);
        startActivity(obj);
    }
    public void onCombo(View v){
        Intent obj=new Intent("act_combo");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onFries(View v){
        Intent obj=new Intent("act_fries");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onShawarma(View v){
        Intent obj=new Intent("act_shawarma");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onCart(View v){
        Intent obj=new Intent("act_cart");
        obj.putExtra("un",s2);
        startActivity(obj);
    }

    public void onOrder(View v){
        List<Corder> rec=db.getOrder(s2);
        String str="";
        for(Corder cr:rec){
            String log="Foodname: "+cr.foodname+" o_id:"+cr.o_id+" Quantity: "+cr.quantity+" Price: "+cr.price;
            log=log+"\n";
            str=str+log;
        }
        Intent obj=new Intent("act_order");
        obj.putExtra("un",s2);
        obj.putExtra("cart",str);
        startActivity(obj);
    }
}