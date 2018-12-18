package com.example.brian.zootopia.Models;

import android.content.Context;
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

public class LisAdapterIndividual extends RecyclerView.Adapter<LisAdapterIndividual.ViewHolder>{
    private ArrayList<Habitante> dataset;
    private Context context;

    public LisAdapterIndividual(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public LisAdapterIndividual.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_individual, parent, false);
        return new LisAdapterIndividual.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LisAdapterIndividual.ViewHolder holder, int position) {
        Habitante habitante = dataset.get(position);
        holder.textInfo.setText(habitante.getFirst() + " " + habitante.getLast());

        Glide.with(context)
                .load(habitante.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageInfo);




    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaIndividual(ArrayList<Habitante> listaIndividual){
        dataset.addAll(listaIndividual);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageInfo;
        private TextView textInfo;

        public ViewHolder(View itemView){
            super(itemView);

            imageInfo = (ImageView)itemView.findViewById(R.id.imageInfo);
            textInfo = (TextView)itemView.findViewById(R.id.textInfo);

        }
    }

}
