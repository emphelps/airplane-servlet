package com.stockcharts.airplane.servlet;

import java.util.Comparator;
import org.json.JSONObject;

public class Airplane {
    
    private int id;
    private String speed;
    private String model;
    private String manufacturer;
    private String year;
    
    private String origin;
    private String destination;

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }
    
    public Airplane withId(int id)
    {
        this.id = id;
        return this;
    }
    
    public Airplane withSpeed(String speed)
    {
        this.speed = speed;
        return this;
    }
    
    public Airplane withModel(String model)
    {
        this.model = model;
        return this;
    }
    
    public Airplane withManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
        return this;
    }
    
    public Airplane withYear(String year)
    {
        this.year = year;
        return this;
    }
    
    public Airplane withOrigin(String origin)
    {
        this.origin = origin;
        return this;
    }
    
    public Airplane withDestination(String destination)
    {
        this.destination = destination;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getSpeed() {
        return speed;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getYear() {
        return year;
    }
    
    @Override 
    public String toString()
    {
        JSONObject jo = new JSONObject(this);
        return jo.toString();
    }
    
//    public static Comparator<Airplane> SPEED = new Comparator<Airplane>()
//    {
//        @Override
//        public int compare(Airplane one, Airplane two)
//        {
//            return Float.compare(one.speed, two.speed);
//        }
//    };
    
//    public static Comparator<Airplane> YEaR = new Comparator<Airplane>()
//    {
//        @Override
//        public int compare(Airplane one, Airplane two)
//        {
//            return Float.compare(one.year, two.year);
//        }
//    };
}
