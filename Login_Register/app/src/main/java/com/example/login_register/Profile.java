package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Profile extends AppCompatActivity {
    String s1,s2,s3;
    CDB db;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        Bundle b=getIntent().getExtras();
        s1=b.getString("name");
        s2=b.getString("un");
        s3=b.getString("pw");
        t1.setText(s1);
        t2.setText("Username : "+s2);
        t3.setText("Password : "+s3);
        db=new CDB(this);


    }
    public void onChange(View v){
        Intent obj=new Intent("act_update");
        obj.putExtra("un",s2);
        obj.putExtra("pw",s3);
        startActivity(obj);
    }
    public void onDelete(View v){

        db.deleteuser(s2);
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_LONG).show();
        Intent obj=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(obj);
    }

}