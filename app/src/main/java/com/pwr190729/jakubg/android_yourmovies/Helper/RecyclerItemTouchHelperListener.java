package com.pwr190729.jakubg.android_yourmovies.Helper;

import android.support.v7.widget.RecyclerView;

/**
 * Created by JakubG on 06.04.2018.
 */

public interface RecyclerItemTouchHelperListener {
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
}
