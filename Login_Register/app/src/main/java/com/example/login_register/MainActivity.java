package com.example.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    CDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new CDB(this);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
    }
    public void onLogin(View v) {
//        Intent obj = new Intent("act_login");
//        startActivity(obj);
        String un;
        String pw;
        un = e1.getText().toString();
        pw = e2.getText().toString();
        int i=0;
        if(un.equals("")||pw.equals("")){
            Toast.makeText(this,"Fill the requirements", Toast.LENGTH_LONG).show();
        }
        else {
            List<CLogin> rec = db.getAllvalues(un, pw);
            for (CLogin cr : rec) {
                if (cr.username.equals(un) && cr.password.equals(pw)) {
                    i++;
                    Toast.makeText(this, "Login Succesfully", Toast.LENGTH_LONG).show();
                    e1.setText("");
                    e2.setText("");
                    Intent obj = new Intent("act_login");
                    obj.putExtra("name",cr.name);
                    obj.putExtra("un",cr.username);
                    obj.putExtra("pw",cr.password);
                    startActivity(obj);
                }
            }
            if(i==0) {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_LONG).show();
                e1.setText("");
                e2.setText("");
            }
        }
    }
    public void onRegister(View v){
        Intent obj=new Intent("act_register");
        startActivity(obj);
    }
}