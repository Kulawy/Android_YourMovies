package com.pwr190729.jakubg.android_yourmovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager mainLayoutManager;

    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mainRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        mainRecyclerView.setHasFixedSize(true);

        mainLayoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(mainLayoutManager);

        MovieFiller filler = new MovieFiller(this);
        movieArrayList = filler.fillTheList();

        myAdapter = new MovieAdapter(movieArrayList);
        mainRecyclerView.setAdapter(myAdapter);

    }


}
