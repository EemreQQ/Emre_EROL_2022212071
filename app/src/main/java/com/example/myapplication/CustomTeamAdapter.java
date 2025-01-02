package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomTeamAdapter extends BaseAdapter {

    Context context;
    ArrayList<Teams> data;

    public CustomTeamAdapter(Context context, ArrayList<Teams> teams) {
        this.data = teams;
        this.context = context;
    }

    @Override
    public int getCount() {
       return data.size();
    }

    @Override
    public Object getItem(int position) {
       return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        @SuppressLint("ViewHolder") View view = li.inflate(R.layout.team_data,null);

        TextView takimAdi = view.findViewById(R.id.takimAdi);
        ImageView takimLogo = view.findViewById(R.id.imageView31);
        TextView takimMilliyeti = view.findViewById(R.id.takimMilliyeti);
        TextView takimSiralama = view.findViewById(R.id.takimSiralamasi);



        Teams currentTeam = data.get(position);

        takimAdi.setText(currentTeam.getakimAdi());
        takimSiralama.setText(String.valueOf(currentTeam.getTakimSiralama()));
        takimMilliyeti.setText(currentTeam.getTakimMilliyeti());

        ProgressBar Progress = view.findViewById(R.id.progressBar);
        Picasso.get()
                .load(currentTeam.getTakimLogo())
                .into(takimLogo, new Callback() {
                    @Override
                    public void onSuccess()
                    {
                        Progress.setVisibility(View.INVISIBLE);
                        takimLogo.onVisibilityAggregated(true);

                    }

                    @Override
                    public void onError(Exception e)
                    {
                        Toast.makeText(context, "Bir hata oluştu..", Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }

}