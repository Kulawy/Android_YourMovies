package com.pwr190729.jakubg.android_yourmovies;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JakubG on 22.03.2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private ArrayList<Movie> moviesArrayList;
    private Context context;

    public MovieAdapter(ArrayList<Movie> moviesArrayList){
        this.moviesArrayList = moviesArrayList;
        context = MyApplication.getAppContext();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, category;
        public ImageView iconImage;
        public ConstraintLayout root, viewForeground;

        public MyViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.main_titleText);
            category = (TextView) view.findViewById(R.id.main_categoryText);
            iconImage = (ImageView) view.findViewById(R.id.main_icon);
            root = (ConstraintLayout) view.findViewById(R.id.movie_list_row_root);
            viewForeground = (ConstraintLayout) view.findViewById(R.id.movie_list_row_view_foreground);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //super.onBindViewHolder(holder, position, payloads);
        Movie movie = moviesArrayList.get(position);
        holder.title.setText(movie.getTittle());
        holder.category.setText(movie.getCategory());
        //holder.iconImage.setImageResource(movie.getImageResourceId());
        //Bitmap icon = BitmapFactory.decodeResource(context.getResources(), movie.getImageResourceId());
        holder.iconImage.setImageBitmap( movie.getImageResource());

        holder.viewForeground.setBackgroundColor(context.getColor(setColourByPosition(position)));
    }

    private int setColourByPosition(int pos){
        int colorId = R.color.colorAccent;
        if ( pos % 4 == 0)
            colorId = R.color.color_for_0;
        if ( pos % 4 == 1)
            colorId = R.color.color_for_1;
        if ( pos % 4 == 2)
            colorId = R.color.color_for_2;
        if ( pos % 4 == 3)
            colorId = R.color.color_for_3;
        /*switch ( position % 4 ){
            case 0:
                colorId =  R.color.color_for_0;
                break;
            case 1:
                colorId =  R.color.color_for_1;
                break;
            case 2:
                colorId = R.color.color_for_2;
                break;
            case 3:
                colorId = R.color.color_for_3;
                break;
        }*/
        return colorId;
    }

    // czy ładowanie bit mapy jest kosztowniejsze czy przekazywanie całej bitmapy zamiast Resource.Id bo
    //czy ładować pomniejszoną bit mapę w MovieFiller i przekazywać całą bitMapę czy tak jak zrobiłem i przekazywać tylko id a magia w Adapterze

    /*private Bitmap resizeImage(Bitmap original){
        Bitmap resized = Bitmap.createScaledBitmap(original, 60, 60, true);
        return resized;
    } */

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    //używamy viewholdera a viewholder podmienia obiekty

    public void removeItem(int position){
        moviesArrayList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Movie movie, int position){
        moviesArrayList.add(position, movie);
        notifyItemInserted(position);
    }

}
