package com.example.brian.zootopia.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.brian.zootopia.API.ApiServices.ZootopiaServices;
import com.example.brian.zootopia.API.Deserializer.Habitante;
import com.example.brian.zootopia.Models.ListaAdapter;

import com.example.brian.zootopia.Models.ZootopiaResponse;
import com.example.brian.zootopia.R;

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
    private Call<Habitante> habitantesCall;
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
       ZootopiaServices service = retrofit.create(ZootopiaServices.class);
       Call<ZootopiaResponse> zResponseCall = service.getListaHabitantes();


       zResponseCall.enqueue(new Callback<ZootopiaResponse>() {

            @Override
          public void onResponse(Call<ZootopiaResponse> call, Response<ZootopiaResponse> response) {
                ZootopiaResponse zResponse = response.body();
                ArrayList<Habitante> listaHabitante = zResponse.getData();
                listaHabitantesAdapter.adicionarListaHabitantes(listaHabitante);

            }

            @Override
            public void onFailure(Call<ZootopiaResponse> call, Throwable t){
                //cargar = true;
                Log.e(TAG, "onFailure: " + t.getMessage());
            }});
        }
}