package com.stockcharts.airplane.servlet;

import com.stockcharts.commons.net.*;
import java.io.IOException;
import java.util.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class AirplaneDAO {
    
    private static final Logger logger = Logger.getLogger(AirplaneDAO.class.getName());
    
    public static List<Airplane> getAirplanesFromFeed() throws IOException
    {
        RestResponse response = new RestRequest(AirplaneServlet.AIRPLANE_FEED_URL).doGet();
 
        String responseBody = response.getBody(); 
        JSONObject jo = new JSONObject(response.getBody());
        JSONArray features = jo.getJSONArray("acList");
        
        List<Airplane> airplanes = new ArrayList<>();
        
        for(int i = 0 ; i < features.length(); i++) // features.lenght()
        {
            JSONObject o = features.getJSONObject(i);
            
            airplanes.add(getAirplaneFromJSONObject(o));
        }
        
        return airplanes;
    }
    
    private static Airplane getAirplaneFromJSONObject(JSONObject jo) throws IOException
    {
        int id = jo.getInt("Id");
        String year = jo.optString("Year", "---");
        String speed = jo.optString("Spd", "---");
        String manufacturer = jo.optString("Man", "---");
        String model = jo.optString("Mdl", "---");
        String origin = jo.optString("From", "---");
        String destination = jo.optString("To", "---");
        
        Airplane airplane = new Airplane()
                .withId(id)
                .withYear(year)
                .withManufacturer(manufacturer)
                .withModel(model)
                .withSpeed(speed)
                .withOrigin(origin)
                .withDestination(destination);
        
        return airplane;
    }
    
}
