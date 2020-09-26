package com.example.PlaceSystem.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {

        public static final String BASE_URL="http://192.168.43.245/sa/";
       // public static final String BASE_URL="http://192.168.137.1/sa/";

    public static Retrofit retrofit ;


    public static Retrofit getApiCon(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        System.out.println("Retrofit returns: "+retrofit);
        return retrofit;
    }
}
