package com.example.stl.mapfragment.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.stl.mapfragment.MainActivity;
import com.example.stl.mapfragment.MapsActivity;
import com.example.stl.mapfragment.R;
import com.example.stl.mapfragment.model.Museums;

public class MuseumViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;


    public MuseumViewHolder(@NonNull View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.museum_text_view);
    }

    public void onBind(final Museums museums) {
        textView.setText(museums.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentInterface fragmentInterface = (FragmentInterface) itemView.getContext();
                fragmentInterface.startMap(museums);




            }
        });
    }


}

