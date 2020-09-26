package com.example.PlaceSystem.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("addStudent.php")
    Call<StudPojo>saveStud
            (

                    @Query("s_name") String nm,
                    @Query("s_addr") String addr,
                    @Query("s_birthdate") String birthdate,
                    @Query("s_ph1") String ph1,
                    @Query("s_ph2") String ph2,
                    @Query("s_gender") String gen,
                    @Query("s_ssc") String ssc,
                    @Query("s_hsc") String hsc,
                    @Query("s_degree") String ug,
                    @Query("s_pg") String pg
            );
    @GET("getAllProject.php")
    Call<List<StudPojo>> getProjects();

    @GET("getAllAdmin.php")
    Call<List<AdminPolo>> getAlladmin();

    @GET("addAdmin.php")
    Call<AdminPolo>saveAdmin
            (

                    @Query("a_id") String id,
                    @Query("a_name") String nm,
                    @Query("a_addr") String addr,
                    @Query("a_birthdate") String birthdate,
                    @Query("a_ph1") String ph1,
                    @Query("a_ph2") String ph2,
                    @Query("a_gender") String gen,
                    @Query("a_ssc") String ssc,
                    @Query("a_hsc") String hsc,
                    @Query("a_degree") String ug,
                    @Query("a_pg") String pg,
                    @Query("a_compname") String compname,
                    @Query("a_compjoinig") String compjoinig,
                    @Query("a_comptime") String comptime

            );

}
