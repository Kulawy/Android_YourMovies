package com.pwr190729.jakubg.android_yourmovies;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by JakubG on 22.03.2018.
 */

public class Movie {

    private String tittle;
    private String category;
    private Bitmap imageResource;
    private ArrayList<Integer> imagesListResourceId;
    private int actorsArrayResourceId;

    public Movie(String tittle, String category, Bitmap imageResource, ArrayList<Integer> imagesListResourceId, int actorsArrayResourceId){
        this.tittle = tittle;
        this.category = category;
        this.imageResource = imageResource;
        this.imagesListResourceId = imagesListResourceId;
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

    public ArrayList<Integer> getImagesListResourceId() {
        return imagesListResourceId;
    }

    public void setImagesListResourceId(ArrayList<Integer> imagesListResourceId) {
        this.imagesListResourceId = imagesListResourceId;
    }

    public int getActorsArrayResourceId() {
        return actorsArrayResourceId;
    }

    public void setActorsArrayResourceId(int actorsArrayResourceId) {
        this.actorsArrayResourceId = actorsArrayResourceId;
    }

}

