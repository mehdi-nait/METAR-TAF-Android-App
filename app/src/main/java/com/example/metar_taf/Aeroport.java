package com.example.metar_taf;

import java.io.Serializable;

public class Aeroport implements Serializable {
    private String OACI;
    private String City;
    private String date;
    private String time;
    private String temperature;
    private String pression;
    private String nuages;
    private String vent;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPression() {
        return pression;
    }

    public void setPression(String pression) {
        this.pression = pression;
    }

    public String getNuages() {
        return nuages;
    }

    public void setNuages(String nuages) {
        this.nuages = nuages;
    }

    public String getVent() {
        return vent;
    }

    public void setVent(String vent) {
        this.vent = vent;
    }

    public Aeroport(String OACI) {
        this.OACI = OACI;
        this.City = "Paris";
        this.date = "2021-11-06";
        this.time = "00:04UTC";
        this.temperature = "8";
        this.nuages = "couvert";
        this.pression = "1024hPa";

    }

    public String getOACI() {
        return OACI;
    }

    public void setOACI(String OACI) {
        this.OACI = OACI;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
