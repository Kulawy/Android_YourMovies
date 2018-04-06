package com.pwr190729.jakubg.android_yourmovies;

import android.content.res.Resources;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JakubG on 04.04.2018.
 */

public class MovieFiller {

    private Context context;
    private ArrayList<Movie> moviesArrayList;
    //Resources res =
    private final int[] moviesArrays = { R.array.movie00, R.array.movie01, R.array.movie02, R.array.movie03, R.array.movie04, R.array.movie05, R.array.movie06, R.array.movie07, R.array.movie08, R.array.movie09};
    private final int[] actorsArrays = { R.array.actors00, R.array.actors01, R.array.actors02, R.array.actors03, R.array.actors04, R.array.actors05, R.array.actors06, R.array.actors07, R.array.actors08, R.array.actors09};
    private final int[] iconImagesId = { R.drawable.anihilacja, R.drawable.baby_driver, R.drawable.black_panther, R.drawable.john_wick_2, R.drawable.kong_wyspa_czaszki, R.drawable.logan, R.drawable.thor_ragnarok, R.drawable.wonder_woman, R.drawable.baby_driver, R.drawable.black_panther};
    private ArrayList<Integer> imagesList;
    Random rnd = new Random();

    public MovieFiller(Context current, ArrayList<Movie> list){
        moviesArrayList = list;
        imagesList = new ArrayList<Integer>();
        this.context = current;
    }

    public ArrayList<Movie> fillTheList(){

        for (int i = 0; i < moviesArrays.length; i++){

            if ( !imagesList.isEmpty() ){
                imagesList.clear();
            }
            for (int j = 0; j < 6; j++){
                imagesList.add(iconImagesId[rnd.nextInt(8)]);
            }
            String[] stingArray = context.getResources().getStringArray(moviesArrays[i]) ;
            moviesArrayList.add( new Movie( stingArray[0], stingArray[1], decodeBitmapFromResource( context.getResources(), iconImagesId[i], 100, 100), imagesList, actorsArrays[i]));
        }

        return moviesArrayList;
    }

    private Bitmap decodeBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(context.getResources(), resId, options);
    }

    private int calculateInSampleSize( BitmapFactory.Options options, int reqWidth, int reqHeight){
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth){
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            while ( (halfHeight / inSampleSize) >= reqHeight && ( halfWidth / inSampleSize) >= reqWidth ){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }


}
