package com.example.PlaceSystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrationFragment extends Fragment
{

    private EditText Name,UserName,UserPassword;
    //private Button BnRegister;
    ApiInterface apiInterface;
    private TextView BnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        Name = view.findViewById(R.id.txt_name);
        UserName = view.findViewById(R.id.txt_user_name);
        UserPassword = view.findViewById(R.id.txt_password);

//        apiInterface = new ApiClient.getApiClient().create(ApiInterface.class);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        BnRegister = view.findViewById(R.id.bn_register);

        BnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
            }
        });

        return view;
    }

    public void performRegistration()
    {
        String name = Name.getText().toString();
        String username = UserName.getText().toString();
        String password = UserPassword.getText().toString();

        Call<User> call = apiInterface.registration(name,username,password);
//        Call<User> call = apiInterface.registration(name,username,password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(response.body().getResponse().equals("ok"))
                {
                    MainActivity.preConfig.displayToast("Registration Successfully...");
                }else if(response.body().getResponse().equals("exist"))
                    {
                        MainActivity.preConfig.displayToast("User Alredy exist...");
                    }
                else if(response.body().getResponse().equals("error"))
                {
                    MainActivity.preConfig.displayToast("Something went wrong...");
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t)
            {

            }
        });

        Name.setText("");
        UserName.setText("");
        UserPassword.setText("");
    }
}
