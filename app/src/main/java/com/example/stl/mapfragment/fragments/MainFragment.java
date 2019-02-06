package com.example.stl.mapfragment.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stl.mapfragment.R;
import com.example.stl.mapfragment.controller.MuseumAdapter;
import com.example.stl.mapfragment.model.MuseumList;
import com.example.stl.mapfragment.networks.MuseumService;
import com.example.stl.mapfragment.networks.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerview);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        MuseumService museumService = retrofit.create(MuseumService.class);
        Call<MuseumList> museumWrapperCall = museumService.getMuseumData();
        museumWrapperCall.enqueue(new Callback<MuseumList>() {
            @Override
            public void onResponse(Call<MuseumList> call, Response<MuseumList> response) {
                Log.d("tag", "onResponse: " + response.body().getMuseums().get(0).getName());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(new MuseumAdapter(response.body().getMuseums()));
            }

            @Override
            public void onFailure(Call<MuseumList> call, Throwable t) {
                Log.d("tag", "onFailure" + t.getMessage());
            }
        });

        return rootView;
    }
}