package com.example.stl.mapfragment.networks;

import com.example.stl.mapfragment.model.MuseumList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MuseumService {

    @GET("JDVila/storybook/master/museums.json")
    Call<MuseumList> getMuseumData();
}
