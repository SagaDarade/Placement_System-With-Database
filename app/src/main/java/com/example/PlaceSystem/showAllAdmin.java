package com.example.PlaceSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.PlaceSystem.Retrofit.AdminPolo;
import com.example.PlaceSystem.Retrofit.Api;
import com.example.PlaceSystem.Retrofit.Connection;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class showAllAdmin extends AppCompatActivity {

    EditText edt1,edt2,edt3,edt4;
    LinearLayout coordinatorLayout;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterAdmin projectAdapter;
    List<AdminPolo> studlist;

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_admin);



        coordinatorLayout = findViewById(R.id.linear1);

        api = Connection.getApiCon().create(Api.class);


        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        loadJSON();


    }
    public void loadJSON() {


        Call<List<AdminPolo>> call = api.getAlladmin();
        call.enqueue(new Callback<List<AdminPolo>>() {

            @Override
            public void onResponse(Call<List<AdminPolo>> call, Response<List<AdminPolo>> response) {
                studlist = response.body();
                System.out.println("Response Body: " + response.body().toString());
                projectAdapter = new AdapterAdmin(studlist,showAllAdmin.this);
                recyclerView.setAdapter(projectAdapter);
            }

            @Override
            public void onFailure(Call<List<AdminPolo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to fetch...!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
