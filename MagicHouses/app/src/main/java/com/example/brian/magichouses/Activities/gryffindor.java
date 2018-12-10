package com.example.brian.magichouses.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.brian.magichouses.API.ApiServices.MagicServices;
import com.example.brian.magichouses.API.Deserializer.Estudiante;
import com.example.brian.magichouses.Models.ListaAdapter;

import com.example.brian.magichouses.Models.MHResponse;
import com.example.brian.magichouses.R;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class gryffindor extends AppCompatActivity{

    public static final String TAG = "MagicHouses";
    public static final String BASE_URL = "https://zootopia-api.herokuapp.com/api/";

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaAdapter listaEstudiantesAdapter;
    private int offset;
    private boolean aptoParaCargar;
    private Call<Estudiante> estudiantesCall;
    //ArrayList<Estudiante> listaEstudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gryffindor);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaEstudiantesAdapter = new ListaAdapter(this);
        recyclerView.setAdapter(listaEstudiantesAdapter);
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
       Call<MHResponse> mhResponseCall = service.getListaEstudiantes();


       mhResponseCall.enqueue(new Callback<MHResponse>() {

            @Override
          public void onResponse(Call<MHResponse> call, Response<MHResponse> response) {
                MHResponse mhResponse = response.body();
                ArrayList<Estudiante> listaEstudiante = mhResponse.getData();
                listaEstudiantesAdapter.adicionarListaEstudiantes(listaEstudiante);

            }

            @Override
            public void onFailure(Call<MHResponse> call, Throwable t){
                //cargar = true;
                Log.e(TAG, "onFailure: " + t.getMessage());
            }});
        }
}