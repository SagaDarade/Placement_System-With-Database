package com.example.PlaceSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

public class SendPlaceStudent extends AppCompatActivity implements  View.OnClickListener {
    EditText edt1,edt2,edt3,edt4;
    Button btn_sendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_place_student);

        edt1=findViewById(R.id.editText1);
        edt2=findViewById(R.id.editText2);
        edt3=findViewById(R.id.editText3);
        edt4=findViewById(R.id.editText4);
        btn_sendsms=(Button)findViewById(R.id.button1);
        btn_sendsms.setOnClickListener(this);

        Bundle ban = getIntent().getExtras();
//        cid = ban.getInt("c00cid");
        //id = ban.getString("c00cid");
        edt1.setText(ban.getString("c01Name"));
         edt2.setText(ban.getString("c04Ph1"));
        edt4.setText(ban.getString("c12compname"));
    }

    @Override
    public void onClick(View v) {

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.SEND_SMS)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {

                        String no=edt2.getText().toString();
                        String msg=edt3.getText().toString();

                        //Getting intent and PendingIntent instance
                        Intent intent=new Intent(getApplicationContext(),SendPlaceStudent.class);
                        PendingIntent pi= PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

                        //Get the SmsManager instance and call the sendTextMessage method to send message
                        SmsManager sms= SmsManager.getDefault();
                        sms.sendTextMessage(no, null, msg, pi,null);

                        Toast.makeText(getApplicationContext(), "Message Sent successfully!",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {

                    }
                }).check();
    }
}
