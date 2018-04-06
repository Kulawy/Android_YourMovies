package com.pwr190729.jakubg.android_yourmovies;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.pwr190729.jakubg.android_yourmovies.Helper.RecyclerItemTouchHelper;
import com.pwr190729.jakubg.android_yourmovies.Helper.RecyclerItemTouchHelperListener;
import com.pwr190729.jakubg.android_yourmovies.Remote.IMenuRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {


    private final String URL_API = "https://api.androidhive.info/json/menu.json";

    private RecyclerView mainRecyclerView;
    private RecyclerView.Adapter buildAdapter;
    private MovieAdapter myAdapter;
    private RecyclerView.LayoutManager mainLayoutManager;
    private CoordinatorLayout rootLayout;


    IMenuRequest mService;

    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        mainRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        rootLayout = (CoordinatorLayout) findViewById(R.id.movie_list_row_root);
        movieArrayList = new ArrayList<>();
        fillList();

        myAdapter = new MovieAdapter(movieArrayList);

        mainLayoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(mainLayoutManager);
        mainRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mainRecyclerView.setAdapter(myAdapter);

        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new RecyclerItemTouchHelper( 0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mainRecyclerView);
        //mainRecyclerView.setHasFixedSize(true);
    }

    private void fillList(){
        MovieFiller filler = new MovieFiller(this, movieArrayList);
        movieArrayList = filler.fillTheList();
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MovieAdapter.MyViewHolder){
            String tittle = movieArrayList.get(viewHolder.getAdapterPosition()).getTittle();

            final Movie deletedMovie = movieArrayList.get(viewHolder.getAdapterPosition());
            final int deleteIndex = viewHolder.getAdapterPosition();

            myAdapter.removeItem(deleteIndex);

            /*
            Je... , nie działa, jak będę bardziej ogarniał Snackbar to poprwię ..., a program działa bez tego, tyle wygrac

            Snackbar snackbar = Snackbar.make(rootLayout, tittle + " removed from cart!", Snackbar.LENGTH_SHORT);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAdapter.restoreItem(deletedMovie, deleteIndex);
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();*/
        }
    }
}
