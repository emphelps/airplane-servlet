package com.stockcharts.airplane.servlet;

import com.stockcharts.commons.net.*;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class AirplaneDAO {
    
    private static final Logger logger = Logger.getLogger(AirplaneDAO.class.getName());
    
    public static List<Airplane> getAirplanesFromFeed() throws IOException
    {
        RestResponse response = new RestRequest(AirplaneServlet.AIRPLANE_FEED_URL).doGet();
        
        String responseBody = response.getBody();
        
        JSONObject jo = new JSONObject(response.getBody());
        JSONArray features = jo.getJSONArray("features");
        
        List<Airplane> airplanes = new ArrayList<>();
        
        for(int i = 0 ; i < features.length(); i++)
        {
            JSONObject o = features.getJSONObject(i);
            
            airplanes.add(getAirplaneFromJSONObject(o));
        }
        
        return airplanes;
    }
    
    private static Airplane getAirplaneFromJSONObject(JSONObject jo) throws IOException
    {
        Airplane airplane = new Airplane();
        
        return airplane;
    }
    
}
