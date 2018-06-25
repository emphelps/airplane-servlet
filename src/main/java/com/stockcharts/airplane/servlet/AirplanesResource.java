package com.stockcharts.airplane.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.json.JSONArray;

@Path("data")
public class AirplanesResource {
    
    private final Logger logger = Logger.getLogger(AirplanesResource.class.getName());
    
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEarthquakes()
    {
        List<Airplane> airplanes = new LinkedList<>();
        
        try{
            airplanes = AirplaneDAO.getAirplanesFromFeed();
            
        }catch(IOException e)
        {
            logger.error("error reading earthquakes from feed", e);
        }
        
        return new JSONArray(airplanes).toString();
    }
    
}
