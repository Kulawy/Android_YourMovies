package com.pwr190729.jakubg.android_yourmovies.Helper;

import com.pwr190729.jakubg.android_yourmovies.Remote.IMenuRequest;
import com.pwr190729.jakubg.android_yourmovies.Remote.RetrofitClient;

/**
 * Created by JakubG on 06.04.2018.
 */

public class Common {
    public static IMenuRequest getMenuRequest(){
        return RetrofitClient.getClient("http://api.androidhive.info/").create(IMenuRequest.class);
    }
}
