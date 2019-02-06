package com.example.stl.mapfragment.networks;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    //https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/



    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static Retrofit instance;



    public static Retrofit getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return instance;


        }
    }

}
