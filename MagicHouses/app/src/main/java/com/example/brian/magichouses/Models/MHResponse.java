package com.example.brian.magichouses.Models;

import com.example.brian.magichouses.API.Deserializer.Habitante;

import java.util.ArrayList;

public class MHResponse {
    private ArrayList<Habitante> data;

    public ArrayList<Habitante> getData() {
        return data;
    }

    public void setData(ArrayList<Habitante> data) {
        this.data = data;
    }
}
