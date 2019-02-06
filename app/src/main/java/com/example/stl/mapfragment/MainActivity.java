package com.example.stl.mapfragment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.stl.mapfragment.controller.MuseumAdapter;
import com.example.stl.mapfragment.fragments.MainFragment;
import com.example.stl.mapfragment.model.MuseumList;
import com.example.stl.mapfragment.model.Museums;
import com.example.stl.mapfragment.networks.MuseumService;
import com.example.stl.mapfragment.networks.RetrofitSingleton;
import com.example.stl.mapfragment.view.FragmentInterface;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void startMap(Museums museum) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("name", museum.getName());
        intent.putExtra("address", museum.getAddress());
        intent.putExtra("city",museum.getCity());
        intent.putExtra("state", museum.getState());
        intent.putExtra("zip", museum.getZip());
        startActivity(intent);
    }
}

