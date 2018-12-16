package com.example.brian.magichouses.API.ApiServices;

import com.example.brian.magichouses.Models.MHResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MagicServices {

    @GET("information")
    Call<MHResponse> getListaHabitantes();

    /*@GET("7182468")
    Call<MHResponse> getListaJudy();*/

    }
