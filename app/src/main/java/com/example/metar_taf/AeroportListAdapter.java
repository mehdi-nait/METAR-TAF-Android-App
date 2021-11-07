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
        aero.setMetar(Global.metar);
        aero.setStation(Global.station);

        temperature.setText(Global.metar.getTemperature().getValue().toString()+"°C");
        pression.setText(aero.getMetar().getAltimeter().getValue().toString()+"hPa");
        nuages.setText(aero.getMetar().getClouds().get(0).getRepr().toString());
        vent.setText(aero.getMetar().getWindSpeed().getValue().toString()+"kt");

        String[] arrOfStr = aero.getMetar().getMeta().getTimestamp().toString().split("T");
        date.setText(arrOfStr[0]);
        //String[] arrOfstr = arrOfStr[1].split(".");
        time.setText(arrOfStr[1]);
        city.setText(aero.getStation().getCity().toString()+" "+ aero.getStation().getName().toString());

        //pression.setText(aero.getMetar().getAltimeter().getValue().toString()+"hPa");



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity3.class);
                //intent.putExtra("aeroport",(Aeroport) getItem(i));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
