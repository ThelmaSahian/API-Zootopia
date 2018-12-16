package com.example.brian.magichouses.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.brian.magichouses.API.ApiServices.MagicServices;
import com.example.brian.magichouses.API.Deserializer.Habitante;
import com.example.brian.magichouses.Models.ListaAdapter;

import com.example.brian.magichouses.Models.MHResponse;
import com.example.brian.magichouses.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatosHabitantes extends AppCompatActivity{

    public static final String TAG = "Zootopia";
    public static final String BASE_URL = "https://zootopia-api.herokuapp.com/api/";

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaAdapter listaHabitantesAdapter;
    private int offset;
    private boolean aptoParaCargar;
    private Call<Habitante> estudiantesCall;
    //ArrayList<Estudiante> listaEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datoshabitantes);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaHabitantesAdapter = new ListaAdapter(this);
        recyclerView.setAdapter(listaHabitantesAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatos();
    }


   private void obtenerDatos(){
       MagicServices service = retrofit.create(MagicServices.class);
       Call<MHResponse> mhResponseCall = service.getListaHabitantes();


       mhResponseCall.enqueue(new Callback<MHResponse>() {

            @Override
          public void onResponse(Call<MHResponse> call, Response<MHResponse> response) {
                MHResponse mhResponse = response.body();
                ArrayList<Habitante> listaHabitante = mhResponse.getData();
                listaHabitantesAdapter.adicionarListaHabitantes(listaHabitante);

            }

            @Override
            public void onFailure(Call<MHResponse> call, Throwable t){
                //cargar = true;
                Log.e(TAG, "onFailure: " + t.getMessage());
            }});
        }
}