package com.stockcharts.airplane.servlet;

import java.util.Comparator;
import org.json.JSONObject;

public class Airplane {
    
    private String id;
    private float speed;
    private String model;
    private String manufacturer;
    private int year;
    
//    private String origin;
//    private String destination;
    
    public Airplane withId(String id)
    {
        this.id = id;
        return this;
    }
    
    public Airplane withSpeed(float speed)
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
    
    public Airplane withYear(int year)
    {
        this.year = year;
        return this;
    }
    
//    public Airplane withOrigin(String origin)
//    {
//        this.origin = origin;
//        return this;
//    }
//    
//    public Airplane withDestination()
//    {
//        this.destination = destination;
//        return this;
//    }

    public String getId() {
        return id;
    }

    public float getSpeed() {
        return speed;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYear() {
        return year;
    }
    
    @Override 
    public String toString()
    {
        JSONObject jo = new JSONObject(this);
        return jo.toString();
    }
    
    public static Comparator<Airplane> SPEED = new Comparator<Airplane>()
    {
        @Override
        public int compare(Airplane one, Airplane two)
        {
            return Float.compare(one.speed, two.speed);
        }
    };
    
    public static Comparator<Airplane> YAER = new Comparator<Airplane>()
    {
        @Override
        public int compare(Airplane one, Airplane two)
        {
            return Float.compare(one.year, two.year);
        }
    };
}
