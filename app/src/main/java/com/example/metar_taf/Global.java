package com.example.metar_taf;

import com.example.metar_taf.pojo_metar.METAR;
import com.example.metar_taf.pojo_station.Station;
import com.example.metar_taf.pojo_taf.Taf;

import java.util.ArrayList;
import java.util.List;

public class Global {

    public static METAR metar;
    public static Station station;
    public static Taf taf;
    public static Aeroport aeroport;
    public static List<Aeroport> tabAeroport = new ArrayList<>();

}
