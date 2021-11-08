package com.example.metar_taf;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomViewList extends ArrayAdapter<Aeroport> {
    /**private String nomAeroport;
     private String donnee;
     private Integer imageid;**/
     private Activity context;

    public CustomViewList(Activity context, ArrayList<Aeroport> aeroport){
        super(context,0,aeroport);
        this.context=context;
        /**this.context=context;
         this.nomAeroport=nomAeroport;
         this.donnee=donnee;
         this.imageid=imageid;**/
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aeroport aeroport=getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
        }
        TextView OACI = (TextView) convertView.findViewById(R.id.Aero_OACI);
        TextView city = (TextView) convertView.findViewById(R.id.Aero_City);
        //TextView date = (TextView) convertView.findViewById(R.id.Aero_date);
        //TextView time = (TextView) convertView.findViewById(R.id.Aero_hour);
        TextView temperature = (TextView) convertView.findViewById(R.id.Aero_temperature);
        TextView pression = (TextView) convertView.findViewById(R.id.Aero_pressure);
        //TextView nuages = (TextView) convertView.findViewById(R.id.Aero_clouds);
        TextView vent = (TextView) convertView.findViewById(R.id.Aero_wind);

        OACI.setText(aeroport.getOACI());
        aeroport.setMetar(aeroport.getMetar());
        aeroport.setStation(aeroport.getStation());
        city.setText(aeroport.getStation().getCity());

        temperature.setText(aeroport.getMetar().getTemperature().getValue().toString()+"°C");
        pression.setText(aeroport.getMetar().getAltimeter().getValue().toString()+"hPa");
        //nuages.setText(aeroport.getMetar().getClouds().get(0).getRepr().toString());
        vent.setText(aeroport.getMetar().getWindSpeed().getValue().toString()+"kt");
/**
        String[] arrOfStr = aeroport.getMetar().getMeta().getTimestamp().toString().split("T");
        date.setText(arrOfStr[0]);
        //String[] arrOfstr = arrOfStr[1].split(".");
        time.setText(arrOfStr[1]);
        city.setText(aeroport.getStation().getCity().toString()+" "+ aeroport.getStation().getName().toString());**/

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),MainActivity3.class);
                //intent.putExtra("aeroport",(Aeroport) getItem(i));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


        /**textViewAeroport.setText(nomAeroport);
         textViewDonnee.setText(donnee);**/
        //imageAeroport.setImageResource(imageid);**/
        return  convertView;
    }
}
