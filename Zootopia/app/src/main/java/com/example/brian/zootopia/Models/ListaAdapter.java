package com.example.brian.zootopia.Models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.brian.zootopia.API.Deserializer.Habitante;
import com.example.brian.zootopia.Activities.DatosHabitantes;
import com.example.brian.zootopia.R;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private ArrayList<Habitante> dataset;
    private Context context;

    public ListaAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_habitante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Habitante habitante = dataset.get(position);
        holder.nombreTextView.setText(habitante.getFirst() + " " + habitante.getLast());

        Glide.with(context)
                .load(habitante.getImage())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);




    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaHabitantes(ArrayList<Habitante> listaHabitantes){
        dataset.addAll(listaHabitantes);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            private ImageView fotoImageView;
            private TextView nombreTextView;
        private ImageView imageInfo;
        private TextView textInfo;

            public ViewHolder(View itemView){
                super(itemView);

                fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
                nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);

                imageInfo = (ImageView)itemView.findViewById(R.id.imageInfo);
                textInfo = (TextView)itemView.findViewById(R.id.textInfo);

            }
    }


}

