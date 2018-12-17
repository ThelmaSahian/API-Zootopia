package com.example.brian.zootopia.API.Deserializer;

import android.widget.Adapter;

public class Habitante {


    private String first;

    private int id;
    private int ss;
    private String image;
    private String last;

    public Habitante(String first, int id, int ss, String last) {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }

    public String checarId() {
        /*if(id == 1){
            String image_0 = "http://img08.deviantart.net/8c0b/i/2016/084/0/f/zootopia___nick_wilde_by_ruby__art-d9weg5a.jpg";
            this.image = image_0;
        }
        if (id == 2){
            String image_1 = "http://vignette3.wikia.nocookie.net/disney/images/1/17/Character_zootopia_judy_e67f6fcc.jpeg/revision/latest?cb=20151205065823";
            this.image = image_1;
        }

        if(id == 3){
            String image_2 = "https://i.ytimg.com/vi/JQ_ETZyUhcc/maxresdefault.jpg";
            this.image = image_2;
        }
        if (id == 4){
            String image_3 = "https://vignette2.wikia.nocookie.net/zootopia/images/4/49/Mayor_Lionheart.png/revision/latest/scale-to-width-down/350?cb=20160214012420\"";
            this.image = image_3;
        }

        if(id == 20){
            String image_19 = "http://iv1.lisimg.com/image/12756939/617full-officer-francine-pennington.jpg";
            this.image = image_19;
        }



    }*/
        return checarId();
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
