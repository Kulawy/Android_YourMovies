package com.pwr190729.jakubg.android_yourmovies;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by JakubG on 22.03.2018.
 */

public class Movie {

    private int id;
    private String tittle;
    private String category;
    private Bitmap imageResource;
    private ArrayList<Bitmap> imagesList;
    private ArrayList<Integer> actorsArrayResourceId;


    public Movie(int id, String tittle, String category, Bitmap imageResource, ArrayList<Integer> actorsArrayResourceId){
        this.id = id;
        this.tittle = tittle;
        this.category = category;
        this.imageResource = imageResource;
        this.actorsArrayResourceId = actorsArrayResourceId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bitmap getImageResource() {
        return imageResource;
    }

    public void setImageResource(Bitmap imageResource) {
        this.imageResource = imageResource;
    }

    public ArrayList<Bitmap> getImagesListResourceId() {
        return imagesList;
    }

    public void setImagesListResourceId(ArrayList<Bitmap> imagesList) {
        this.imagesList = imagesList;
    }

    public ArrayList<Integer> getActorsArrayResourceId() {
        return actorsArrayResourceId;
    }

    public void setActorsArrayResourceId(ArrayList<Integer> actorsArrayResourceId) {
        this.actorsArrayResourceId = actorsArrayResourceId;
    }

    public int getId() {
        return id;
    }

}

