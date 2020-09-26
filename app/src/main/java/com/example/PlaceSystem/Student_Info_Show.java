package com.example.PlaceSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.PlaceSystem.Retrofit.AdminPolo;
import com.example.PlaceSystem.Retrofit.Api;
import com.example.PlaceSystem.Retrofit.Connection;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Info_Show extends AppCompatActivity implements  View.OnClickListener
{
    EditText ed_rno, ed_name,ed_addrs,ed_birth,ed_contact,ed_contact2,ed_email,ed_adhaarCard,
            ed_PANCard,ed_initDate,ed_endDate,ed_compname,ed_comjoining,ed_comptime;
    int cid;
    String id=null;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14;
    Button save,show,clear;
    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__info__show);
        api = Connection.getApiCon().create(Api.class);

        ed_rno = findViewById(R.id.ed_rno);

        ed_name = findViewById(R.id.ed_name);
        ed_addrs = findViewById(R.id.ed_addrs);
        ed_birth = findViewById(R.id.ed_birth);
        ed_contact = findViewById(R.id.ed_contact);
        ed_contact2 = findViewById(R.id.ed_contact2);
        ed_email = findViewById(R.id.ed_email);
        ed_adhaarCard = findViewById(R.id.ed_adhaarCard);
        ed_PANCard = findViewById(R.id.ed_PANCard);
        ed_initDate = findViewById(R.id.ed_initDate);
        ed_endDate = findViewById(R.id.ed_endDate);

        ed_compname=findViewById(R.id.ed_comp);
        ed_comjoining=findViewById(R.id.ed_compjoin);
        ed_comptime=findViewById(R.id.ed_comptime);
        //ed_mtrReading = findViewById(R.id.ed_mtrReading);

        save=findViewById(R.id.btn_Asave);
        show=findViewById(R.id.btn_Ashow);
        clear=findViewById(R.id.btn_clear);


       // save.setOnClickListener(this);


        Bundle ban = getIntent().getExtras();
//        cid = ban.getInt("c00cid");
        //id = ban.getString("c00cid");
        ed_rno.setText(ban.getString("c00cid"));
        ed_name.setText(ban.getString("c01Name"));
        ed_addrs.setText(ban.getString("c02Addr"));
        ed_birth.setText(ban.getString("c03BDate"));
        ed_contact.setText(ban.getString("c04Ph1"));
        ed_contact2.setText(ban.getString("c05Ph2"));
        ed_email.setText(ban.getString("c06Gen"));
        ed_adhaarCard.setText(ban.getString("c07Hsc"));
        ed_PANCard.setText(ban.getString("c08Ssc"));
        ed_initDate.setText(ban.getString("c09ug"));
        ed_endDate.setText(ban.getString("c10pg"));
       // ed_mtrReading.setText(ban.getString("c11Mtr"));


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),showAllAdmin.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }

            private void insert() {
                s1 = ed_rno.getText().toString();
                s2 = ed_name.getText().toString();
                s3 = ed_addrs.getText().toString();
                s4 = ed_birth.getText().toString();
                s5 = ed_contact.getText().toString();
                s6 = ed_contact2.getText().toString();
                s7 = ed_email.getText().toString();
                s8 = ed_adhaarCard.getText().toString();
                s9 = ed_PANCard.getText().toString();
                s10 = ed_initDate.getText().toString();
                s11 = ed_endDate.getText().toString();
                s12 = ed_compname.getText().toString();
                s13 = ed_comjoining.getText().toString();
                s14 = ed_comptime.getText().toString();


                Call<AdminPolo> call = api.saveAdmin(s1,s2,s3, s4, s5, s6, s7, s8, s9, s10,s11,s12,s13,s14);
                call.enqueue(new Callback<AdminPolo>() {
                    @Override
                    public void onResponse(Call<AdminPolo> call, Response<AdminPolo> response) {
                        if (response.body().getRespo().equals("ok")) {
                            Toast.makeText(Student_Info_Show.this, "Profile Complete Successfully !", Toast.LENGTH_SHORT).show();
                        } else if (response.body().getRespo().equals("fail")) {
                            Toast.makeText(Student_Info_Show.this, "Couldn't Store", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<AdminPolo> call, Throwable t) {
                        Toast.makeText(Student_Info_Show.this, "No Internet Found", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

    }

    @Override
    public void onClick(View v) {
//        Dexter.withActivity(this)
//                .withPermission(Manifest.permission.SEND_SMS)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse response) {
//
//                        String no=ed_contact.getText().toString();
//                        String msg=ed_contact2.getText().toString();
//
//                        //Getting intent and PendingIntent instance
//                        Intent intent=new Intent(getApplicationContext(),SendPlaceStudent.class);
//                        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
//
//                        //Get the SmsManager instance and call the sendTextMessage method to send message
//                        SmsManager sms= SmsManager.getDefault();
//                        sms.sendTextMessage(no, null, msg, pi,null);
//
//                        //Toast.makeText(getApplicationContext(), "Message Sent successfully!",Toast.LENGTH_LONG).show();
//
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse response) {
//
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {
//
//                    }
//                }).check();

    }
}
