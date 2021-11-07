package com.example.metar_taf;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.metar_taf.Aeroport;
import com.example.metar_taf.pojo_metar.METAR;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AeroportListAdapter extends BaseAdapter {
    private Context context;
    private List<Aeroport> list;
    private LayoutInflater inflater;

    public AeroportListAdapter(Context context, List<Aeroport> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_item,null);
        Aeroport aero = (Aeroport) getItem(i);

        TextView OACI = (TextView) view.findViewById(R.id.Aero_OACI);
        TextView city = (TextView) view.findViewById(R.id.Aero_City);
        TextView date = (TextView) view.findViewById(R.id.Aero_date);
        TextView time = (TextView) view.findViewById(R.id.Aero_hour);
        TextView temperature = (TextView) view.findViewById(R.id.Aero_temperature);
        TextView pression = (TextView) view.findViewById(R.id.Aero_pressure);
        TextView nuages = (TextView) view.findViewById(R.id.Aero_clouds);
        TextView vent = (TextView) view.findViewById(R.id.Aero_wind);

        OACI.setText(aero.getOACI());







        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(view.getContext(),MainActivity3.class);
                intent.putExtra("aeroport",(Aeroport) getItem(i));
                context.startActivity(intent);*/
            }
        });

        return view;
    }
}
