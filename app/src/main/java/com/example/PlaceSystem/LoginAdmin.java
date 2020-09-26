package com.example.PlaceSystem;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAdmin extends AppCompatActivity implements View.OnClickListener {
    EditText et_user, et_password;
   // Button btn_login;
    TextView btn_login;

    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);


        //DB Part starts
        db = openOrCreateDatabase("MyDB1", Context.MODE_PRIVATE, null);
        // db.execSQL("DROP TABLE IF EXISTS Login");
        db.execSQL("Create table if not exists Login(user varchar,password varchar)");
        //db.execSQL("insert into Login values('praju','praju123')");
        //db.execSQL("insert into Login values('arti','arti123')");


        et_user = (EditText) findViewById(R.id.user_name);
        et_password = (EditText) findViewById(R.id.user_pass);
        btn_login = (TextView) findViewById(R.id.login_bn);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.findViewById(R.id.login_bn) == btn_login)
        {
            login();
        }

      /*  if (v.findViewById(R.id.btn_login) == btn_login) {
            if (et_user.getText().length() == 0 || et_password.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), "All Fields are necessary...", Toast.LENGTH_SHORT).show();
                et_user.requestFocus();
            }
            else
                {
                try
                  {
                      c = db.rawQuery("select * from Login where user='" + et_user.getText().toString().trim() + "'and password='" + et_password.getText().toString().trim() + "'",null);

                    //String str = "select * from Login where user = '" + et_user.getText() + "' and password = '" + et_password.getText() + "'";
                    //db.execSQL(str);
                   // c.getString(db);
                    Toast.makeText(getApplicationContext(), "Login Successfull....", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(this, Home_page.class);
                    startActivity(i);
                  }
                    catch (Exception exp)
                    {

                    Toast.makeText(getApplicationContext(), "Invali Login....", Toast.LENGTH_SHORT).show();
                     }
            }

        }

    }*/
    }
    public void login()
    {
        String user = et_user.getText().toString().trim();
        String pass = et_password.getText().toString().trim();
        if (et_user.getText().toString().equals("")) {
            et_user.setError("Enter Admin Username Required !");
            et_user.requestFocus();
        } else if (et_password.getText().toString().equals("")) {
            et_password.setError("Enter Password !");
            et_password.requestFocus();
        }
        else if(user.equals("amruta") && pass.equals("am123") || user.equals("priya") && pass.equals("priya123"))
        {

            Toast.makeText(getApplicationContext(), "Login Successfull....", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, StudentDetails.class);
            startActivity(i);

        }
        else {
            Toast.makeText(getApplicationContext(), "Invali Login....", Toast.LENGTH_SHORT).show();

        }
    }

}