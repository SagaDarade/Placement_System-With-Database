package com.example.PlaceSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.PlaceSystem.Retrofit.Api;
import com.example.PlaceSystem.Retrofit.Connection;
import com.example.PlaceSystem.Retrofit.StudPojo;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfo extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4,edt5,edt6,edt7,edt8,edt9,edt10;
    Button btnInsert,btn_show;
    Api api;
    String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    StudentAdapter projectAdapter;
    List<StudPojo>studPojoList ;

    DatePickerDialog datePickerDialog;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        api = Connection.getApiCon().create(Api.class);

        edt1=findViewById(R.id.ed_name);
        edt2=findViewById(R.id.ed_birth);
        edt3=findViewById(R.id.ed_addrs);
        edt4=findViewById(R.id.ed_contact);
        edt5=findViewById(R.id.ed_contact2);
        edt6=findViewById(R.id.ed_gender);
        edt7=findViewById(R.id.ed_ssc);
        edt8=findViewById(R.id.ed_hsc);
        edt9=findViewById(R.id.ed_degree);
        edt10=findViewById(R.id.ed_pg);

        btnInsert = findViewById(R.id.btn_insert);
        btn_show = findViewById(R.id.btn_show);

        edt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(StudentInfo.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                //edt2.setText(day + "/" + (month + 1) + "/" + year);
                                edt2.setText(year +"-" + (month+1) + "-" + day);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        //recyclerView = findViewById(R.id.recyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setHasFixedSize(true);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GettAll_Student.class));
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
    }


    private void insert() {

        if (edt1.getText().toString().equals("")) {
            edt1.setError("Student Name Required !");
            edt1.requestFocus();
        } else if (edt3.getText().toString().equals("")) {
            edt3.setError("Enter Address !");
            edt3.requestFocus();
        } else if (edt2.getText().toString().equals("")) {
            edt2.setError("Enter Birth Date !");
            edt2.requestFocus();
        }else if (edt4.getText().toString().equals("")) {
            edt4.setError("Enter Phone no ?");
            edt4.requestFocus();

        } else if (edt5.getText().toString().equals("")) {
            edt5.setError("Enter Phone no  ?");
            edt5.requestFocus();
        }
        else if (edt6.getText().toString().equals("")) {
            edt6.setError(" Enter Gender ?");
            edt6.requestFocus();
        }
        else if (edt8.getText().toString().equals("")) {
            edt8.setError(" Enter 10th Marks ?");
            edt8.requestFocus();
        }
        else if (edt7.getText().toString().equals("")) {
            edt7.setError(" Enter 12th Marks ?");
            edt7.requestFocus();
        }
        else if (edt9.getText().toString().equals("")) {
            edt9.setError(" Enter Graduation Marks ?");
            edt9.requestFocus();
        }
        else if (edt10.getText().toString().equals("")) {
            edt10.setError(" Enter POST Graduation Marks ?");
            edt10.requestFocus();
        }
        else {
            s1 = edt1.getText().toString();
            s3 = edt3.getText().toString();
            s2 = edt2.getText().toString();
            s4 = edt4.getText().toString();
            s5 = edt5.getText().toString();
            s6 = edt6.getText().toString();
            s7 = edt7.getText().toString();
            s8 = edt8.getText().toString();
            s9 = edt9.getText().toString();
            s10 = edt10.getText().toString();

            Call<StudPojo> call = api.saveStud(s1,s3,s2, s4, s5, s6, s7, s8, s9, s10);
            call.enqueue(new Callback<StudPojo>() {
                @Override
                public void onResponse(Call<StudPojo> call, Response<StudPojo> response) {
                    if (response.body().getRespo().equals("ok")) {
                        Toast.makeText(StudentInfo.this, "Record Saved Successfully !", Toast.LENGTH_SHORT).show();
                    } else if (response.body().getRespo().equals("fail")) {
                        Toast.makeText(StudentInfo.this, "Couldn't Store", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<StudPojo> call, Throwable t) {
                    Toast.makeText(StudentInfo.this, "No Internet Found", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
