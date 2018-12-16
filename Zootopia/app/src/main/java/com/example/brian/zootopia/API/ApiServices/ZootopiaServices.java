package com.example.brian.zootopia.API.ApiServices;

import com.example.brian.zootopia.Models.ZootopiaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ZootopiaServices {

    @GET("information")
    Call<ZootopiaResponse> getListaHabitantes();

    /*@GET("7182468")
    Call<MHResponse> getListaJudy();*/

    }
