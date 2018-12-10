package com.example.brian.magichouses.Models;

import com.example.brian.magichouses.API.Deserializer.Estudiante;

import java.util.ArrayList;

public class MHResponse {
    private ArrayList<Estudiante> data;

    public ArrayList<Estudiante> getData() {
        return data;
    }

    public void setData(ArrayList<Estudiante> data) {
        this.data = data;
    }
}
