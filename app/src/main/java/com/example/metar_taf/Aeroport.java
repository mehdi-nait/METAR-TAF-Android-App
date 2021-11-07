package com.example.metar_taf;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.metar_taf.pojo_metar.METAR;
import com.example.metar_taf.pojo_taf.Taf;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Aeroport implements Serializable {
    private String OACI;
    private METAR metar;




    public Aeroport(String OACI)  {
        this.OACI = OACI;

    }

    public String getOACI() {
        return OACI;
    }

    public void setOACI(String OACI) {
        this.OACI = OACI;
    }

    public METAR getMetar() {
        return metar;
    }

    public void setMetar(METAR metar) {
        this.metar = metar;
    }
}
