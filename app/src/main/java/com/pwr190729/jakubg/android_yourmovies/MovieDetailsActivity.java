package com.pwr190729.jakubg.android_yourmovies;

//import android.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.pwr190729.jakubg.android_yourmovies.Fragments.*;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String TITLE_ONE = "actors";
    private static final String TITLE_TWO = "images";
    private static final int BANNER_WIDTH = 480;
    private static final int BANNER_HEIGHT = 240;
    public static final int DEFAULT_VALUE = 0;
    Movie theMovie;
    private ImageView banner;
    private TextView category, tittle;
    private Context context;
    private Intent intent;
    private TabLayout myTabs;
    private ViewPager myPage;
    int movieId;
    //private Movie currentMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.movie_detail_toolbar);
        //setSupportActionBar(toolbar);
        context = getBaseContext();
        intent = getIntent();
        setUpViews();

        movieId = intent.getIntExtra( MovieAdapter.MOVIE_POS, DEFAULT_VALUE );
        fillContent( movieId );

        if ( getResources().getConfiguration().orientation ==  Configuration.ORIENTATION_PORTRAIT){
            myTabs = (TabLayout) findViewById(R.id.movie_details_my_tabs);
            myPage = (ViewPager) findViewById(R.id.pager_layout_my_page);
            myTabs.setupWithViewPager(myPage);
            SetUpViewPager(myPage);
        } else {
            setUpFragmentsOnLandscape();

        }


        //theMovie = (Movie) intent.getSerializable("movie");
    }

    private void setUpFragmentsOnLandscape(){
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTrans = fragMan.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        bundle.putInt("screenWidth", getWidth());
        bundle.putInt("screenHeight", getHeight());
        // set Fragmentclass Arguments
        ActorsFragment actorsFragment = new ActorsFragment();
        ImagesFragment imagesFragment = new ImagesFragment();
        actorsFragment.setArguments(bundle);
        imagesFragment.setArguments(bundle);
        fragTrans.add( R.id.movie_details_fragment_actors, actorsFragment);
        fragTrans.add( R.id.movie_details_fragment_images, imagesFragment);
        fragTrans.commit();
    }

    public void SetUpViewPager (ViewPager viewPage){
        MyViewPageAdapter myPagerAdapter = new MyViewPageAdapter(getSupportFragmentManager());

        //ActorsFragment actorsFragment = new ActorsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("movieId", movieId);
        bundle.putInt("screenWidth", getWidth());
        bundle.putInt("screenHeight", getHeight());
        // set Fragmentclass Arguments
        ActorsFragment actorsFragment = new ActorsFragment();
        ImagesFragment imagesFragment = new ImagesFragment();
        actorsFragment.setArguments(bundle);
        imagesFragment.setArguments(bundle);

       //actorsFragment.setMyAdapter(); // TU NIE DZIAŁA  ?

        myPagerAdapter.addFragmentPage( actorsFragment, TITLE_ONE);
        myPagerAdapter.addFragmentPage( imagesFragment, TITLE_TWO);
        viewPage.setAdapter(myPagerAdapter);
    }

    private void setUpViews(){
        banner = (ImageView) findViewById(R.id.movie_details_icon) ;
        tittle = (TextView) findViewById(R.id.movie_details_tittle) ;
        category = (TextView) findViewById(R.id.movie_details_category) ;
    }

    // wrzucamy id filmu i wypełnia nam kontent samego filmu i wywoluje metode setActors() i setImages()
    private void fillContent(int id){
        Movie currentMovie = MovieDataServer.getInstance(context).getMovieMap(id);
        this.tittle.setText( currentMovie.getTittle());
        this.category.setText( currentMovie.getCategory());
        int bannerWidth = getHeight()/2;
        //bannerWidth = banner.getWidth();
        int bannerHeight = getWidth()/4;
        //int bannerHeight = banner.getHeight();
        Bitmap bannerImage = MovieDataServer.getInstance(this).imageToBanner(bannerWidth, bannerHeight, currentMovie);
        //this.banner.setImageBitmap( MovieDataServer.getInstance(context).getMovieMap(id).getImageResource());
        this.banner.setImageBitmap( bannerImage );
    }

    private int getHeight(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    private int getWidth(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

}

