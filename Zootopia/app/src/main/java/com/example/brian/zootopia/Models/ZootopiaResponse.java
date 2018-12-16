package com.example.brian.zootopia.Models;

import com.example.brian.zootopia.API.Deserializer.Habitante;

import java.util.ArrayList;

public class ZootopiaResponse {
    private ArrayList<Habitante> data;

    public ArrayList<Habitante> getData() {
        return data;
    }

    public void setData(ArrayList<Habitante> data) {
        this.data = data;
    }
}
