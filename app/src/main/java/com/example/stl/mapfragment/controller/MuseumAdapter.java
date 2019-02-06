package com.example.stl.mapfragment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stl.mapfragment.R;
import com.example.stl.mapfragment.model.Museums;
import com.example.stl.mapfragment.view.MuseumViewHolder;

import java.util.List;

public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {
    private List<Museums> museumList;

    public MuseumAdapter(List<Museums> museumList) {
        this.museumList = museumList;
    }

    @NonNull
    @Override
    public MuseumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MuseumViewHolder museumViewHolder, int i) {
        Museums museums = museumList.get(i);
        museumViewHolder.onBind(museums);
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }
}
