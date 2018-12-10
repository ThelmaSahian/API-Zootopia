package com.example.brian.magichouses.Models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.brian.magichouses.API.Deserializer.Estudiante;
import com.example.brian.magichouses.R;


import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private ArrayList<Estudiante> dataset;
    private Context context;

    public ListaAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estudiante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Estudiante estudiante = dataset.get(position);
        holder.nombreTextView.setText(estudiante.getFirst());

        Glide.with(context)
                .load(estudiante.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaEstudiantes(ArrayList<Estudiante> listaEstudiantes){
        dataset.addAll(listaEstudiantes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView fotoImageView;
            private TextView nombreTextView;

            public ViewHolder(View itemView){
                super(itemView);

                fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
                nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            }
    }
}
