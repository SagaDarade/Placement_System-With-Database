package com.example.PlaceSystem;

import com.google.gson.annotations.SerializedName;

public class User
{
    @SerializedName("response")
    private String Response;

    @SerializedName("user_name")
    private String Name;

    public String getResponse() {
        return Response;
    }

    public String getName() {
        return Name;
    }
}
