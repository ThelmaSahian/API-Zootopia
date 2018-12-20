package com.example.brian.zootopia.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brian.zootopia.API.ApiServices.ZootopiaServices;
import com.example.brian.zootopia.API.Deserializer.Habitante;
import com.example.brian.zootopia.Models.LisAdapterIndividual;
import com.example.brian.zootopia.Models.ZootopiaResponse;
import com.example.brian.zootopia.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.brian.zootopia.Activities.DatosHabitantes.BASE_URL;

public class Individual extends AppCompatActivity {
    ImageView imageInfo = findViewById(R.id.imageInfo);
    TextView textInfo = findViewById(R.id.textInfo);

    private LisAdapterIndividual lisAdapterIndividual;
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private static String TAG = "Zootopia";

    Habitante habitante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
        lisAdapterIndividual = new LisAdapterIndividual(this);


        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        //obtenerDatos();


    }



    /*public void obtenerDatos(){
        ZootopiaServices service = retrofit.create(ZootopiaServices.class);
        final Call<ZootopiaResponse> zResponseCall = service.getListaHabitantes();


        zResponseCall.enqueue(new Callback<ZootopiaResponse>() {

            @Override
            public void onResponse(Call<ZootopiaResponse> call, Response<ZootopiaResponse> response) {
                ZootopiaResponse zResponse = response.body();
                ArrayList<Habitante> listaHabitante = zResponse.getData();

                textInfo.setText(habitante.getFirst() + " " + habitante.getLast());
                Picasso.get().load(habitante.checarId());
                //lisAdapterIndividual.adicionarListaIndividual(listaHabitante);

            }

            @Override
            public void onFailure(Call<ZootopiaResponse> call, Throwable t){
                //cargar = true;
                Log.e(TAG, "onFailure: " + t.getMessage());
            }});
    }*/
}
