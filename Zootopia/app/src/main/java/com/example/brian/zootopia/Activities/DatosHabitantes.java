package com.example.brian.zootopia.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.brian.zootopia.API.ApiServices.ZootopiaServices;
import com.example.brian.zootopia.API.Deserializer.Habitante;
import com.example.brian.zootopia.Models.LisAdapterIndividual;
import com.example.brian.zootopia.Models.ListaAdapter;

import com.example.brian.zootopia.Models.ZootopiaResponse;
import com.example.brian.zootopia.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatosHabitantes extends AppCompatActivity  {

    public static final String TAG = "Zootopia";
    public static final String BASE_URL = "https://zootopia-api.herokuapp.com/api/";

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaAdapter listaHabitantesAdapter;
    private int offset;
    private boolean aptoParaCargar;
    private Call<Habitante> habitantesCall;
    //ArrayList<Estudiante> listaEstudiante;
    private Habitante habitante;
    private LisAdapterIndividual lisAdapterIndividual;

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

        final GestureDetector mGestureDetector = new GestureDetector(DatosHabitantes.this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

        });

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                try{

                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if(child != null  && mGestureDetector.onTouchEvent(e)){

                        int position = recyclerView.getChildAdapterPosition(child);
                        //Toast.makeText(DatosHabitantes.this, "El habitante seleccionado es " + habitante.getFirst() + " " + habitante.getLast(), Toast.LENGTH_SHORT).show();
                        setContentView(R.layout.activity_individual);

                        return true;
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

   /* protected void onCreate2(Bundle saveInstance){
        super.onCreate(saveInstance);
        setContentView(R.layout.activity_individual);
    }*/


   public void obtenerDatos(){
       ZootopiaServices service = retrofit.create(ZootopiaServices.class);
       Call<ZootopiaResponse> zResponseCall = service.getListaHabitantes();


       zResponseCall.enqueue(new Callback<ZootopiaResponse>() {

            @Override
          public void onResponse(Call<ZootopiaResponse> call, Response<ZootopiaResponse> response) {
                ZootopiaResponse zResponse = response.body();
                ArrayList<Habitante> listaHabitante = zResponse.getData();
                listaHabitantesAdapter.adicionarListaHabitantes(listaHabitante);
                //lisAdapterIndividual.adicionarListaIndividual(listaHabitante);

            }

            @Override
            public void onFailure(Call<ZootopiaResponse> call, Throwable t){
                //cargar = true;
                Log.e(TAG, "onFailure: " + t.getMessage());
            }});
        }
}