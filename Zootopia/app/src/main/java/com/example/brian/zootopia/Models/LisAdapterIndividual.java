package com.example.brian.zootopia.Models;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.brian.zootopia.API.Deserializer.Habitante;
import com.example.brian.zootopia.R;

import java.util.ArrayList;

public class LisAdapterIndividual extends AppCompatActivity {
    private ArrayList<Habitante> dato;
    private Context cont;

    public LisAdapterIndividual(Context cont){

        this.cont = cont;
        dato = new ArrayList<>();
    }

    public void onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_individual, parent, false);

    }


    public void onBindViewHolder(LisAdapterIndividual.ViewHolder holder, int position) {
        Habitante habitante = dato.get(position);
        holder.textInfo.setText(habitante.getFirst() + " " + habitante.getLast());

        Glide.with(cont)
                .load(habitante.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageInfo);
    }


    public int getItemCount() {
        return dato.size();
    }

    public void adicionarListaIndividual(ArrayList<Habitante> listaIndividual){
        dato.addAll(listaIndividual);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageInfo;
        private TextView textInfo;

        public ViewHolder(View itemView, int position){
            super(itemView);

            imageInfo = (ImageView)itemView.findViewById(R.id.imageInfo);
            textInfo = (TextView)itemView.findViewById(R.id.textInfo);



        }
    }

}
