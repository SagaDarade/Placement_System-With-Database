package com.example.PlaceSystem.Retrofit;

import com.google.gson.annotations.SerializedName;


public class StudPojo
{

    @SerializedName("sid")
    private int sid;

    @SerializedName("sname")
    private String name;

    @SerializedName("saddress")
    private String addrs;

    @SerializedName("sbirthdate")
    private String birthdate;

    @SerializedName("smobile")
    private String mob1;

    @SerializedName("smobile2")
    private String mob2;

    @SerializedName("sgender")
    private String gender;

    @SerializedName("ssc")
    private String ssc;

    @SerializedName("hsc")
    private String hsc;

    @SerializedName("degree")
    private String ug;

    @SerializedName("pg")
    private String pg;

    @SerializedName("user_name")
    private String SName;

    @SerializedName("response")
    private String respo;

   /* public StudPojo(int sid, String name, String addrs, String mob1, String mob2, String gender, String ssc, String hsc, String ug, String pg) {
        this.sid = sid;
        this.name = name;
        this.addrs = addrs;
        this.mob1 = mob1;
        this.mob2 = mob2;
        this.gender = gender;
        this.ssc = ssc;
        this.hsc = hsc;
        this.ug = ug;
        this.pg = pg;
    }*/

    public String getSName() {
        return SName;
    }

    public int getSid() { return sid; }

    public String getName() {
        return name;
    }

    public String getAddrs() {
        return addrs;
    }

    public String getBirthdate() { return birthdate; }

    public String getMob1() {
        return mob1;
    }

    public String getMob2() {
        return mob2;
    }

    public String getGender() {
        return gender;
    }

    public String getSsc() {
        return ssc;
    }

    public String getHsc() {
        return hsc;
    }

    public String getUg() {
        return ug;
    }

    public String getPg() {
        return pg;
    }



    public String getRespo() {
        return respo;
    }
}
