package com.example.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Register extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    CDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        db=new CDB(this);
    }
    public void onRegister(View v){
        String cpw;
        int i=0;
        CLogin cl=new CLogin();
        cl.name=e4.getText().toString();
        cl.username=e1.getText().toString();
        cl.password=e2.getText().toString();
        cpw=e3.getText().toString();
//        Toast.makeText(this,dn +dl,Toast.LENGTH_LONG).show();
        if(cl.name.equals("")||cl.username.equals("")||cl.password.equals("")||cpw.equals("")) {
            Toast.makeText(this, "Please fill the requirments", Toast.LENGTH_LONG).show();
        }
        else{
            List<CLogin> rec = db.Search();
            for (CLogin cr : rec) {
                if (cr.username.equals(cl.username)) {
                    Toast.makeText(this, "Enter another username", Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e4.setText("");
                    e2.setText("");
                    e3.setText("");
                    i++;
                }
            }
            if(i==0) {
                if (cl.password.equals(cpw)) {
                    db.Insert(cl);
                    e1.setText("");
                    e4.setText("");
                    e2.setText("");
                    e3.setText("");
                    Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
                    Intent obj=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(obj);
                } else {
                    Toast.makeText(this, "password is not same", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}