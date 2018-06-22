package com.stockcharts.airplane.servlet;

import java.util.*;
import java.util.logging.Logger;

public class AirplaneDAO {
    
    private static final Logger logger = Logger.getLogger(AirplaneDAO.class.getName());
    
    public static List<Airplane> getAirplanesFromFee()
    {
        List<Airplane> airplanes = new ArrayList<>();
        
        return airplanes;
    }
    
    private static Airplane getAirplaneFromJSONObject()
    {
        Airplane airplane = new Airplane();
        
        return airplane;
    }
    
}
