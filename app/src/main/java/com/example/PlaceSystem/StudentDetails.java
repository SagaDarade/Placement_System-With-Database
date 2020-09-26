package com.example.PlaceSystem;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.PlaceSystem.Retrofit.Api;
import com.example.PlaceSystem.Retrofit.Connection;
import com.example.PlaceSystem.Retrofit.StudPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentDetails extends AppCompatActivity {

    LinearLayout coordinatorLayout;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    StudentAdapter projectAdapter;
    List<StudPojo> studs;

    Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        coordinatorLayout = findViewById(R.id.linear);


        api = Connection.getApiCon().create(Api.class);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        loadJSON();


    }
    public void loadJSON() {
        //startActivity(new Intent(getApplicationContext(), GettAll_Student.class));
        Call<List<StudPojo>> call = api.getProjects();
        call.enqueue(new Callback<List<StudPojo>>() {

            @Override
            public void onResponse(Call<List<StudPojo>> call, Response<List<StudPojo>> response) {
                studs = response.body();
                System.out.println("Response Body: " + response.body().toString());
                projectAdapter = new StudentAdapter(studs,StudentDetails.this);
                recyclerView.setAdapter(projectAdapter);
            }

            @Override
            public void onFailure(Call<List<StudPojo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Unable to fetch...!", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
