package com.stockcharts.airplane.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.common.cache.*;
import java.util.Collections;
import org.json.JSONArray;


public class AirplaneServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(AirplaneServlet.class.getName());

    public static final String AIRPLANE_FEED_URL = "https://public-api.adsbexchange.com/VirtualRadar/AircraftList.json?fTypQN=";

    private Cache<String, List<Airplane>> airplaneCache;
    
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        
        logger.warn("==================================================");
        logger.warn("           airplane-servlet : init()");
        logger.warn("==================================================");
        
        logger.warn("Setting up Guava Cache...");
        airplaneCache = CacheBuilder.newBuilder()
                .expireAfterAccess(30, TimeUnit.SECONDS)
                .build();
        logger.warn("...success");
        
        logger.warn("==================================================");
        logger.warn("           airplane-servlet : init() - COMPLETE");
        logger.warn("==================================================");
    }
    
    @Override
    public void destroy()
    {
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        logger.warn("           airplane-servlet : destroy()");
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        logger.warn("           airplane-servlet : destroy() - COMPLETE");
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        List<Airplane> airplanes = airplaneCache.getIfPresent("all");
        
        if(airplanes == null)
        {
            try{
                logger.warn("in doGet try!");
                airplanes = AirplaneDAO.getAirplanesFromFeed();
                logger.warn("got airplanes from DAO");
                airplaneCache.put("all", airplanes);
            }
            catch(IOException e)
            {
                logger.error("IOException reading from Airplane Feed", e);
            }
        }
        
        String requestVal = request.getParameter("sort");
        
        logger.debug("requestVal: " + requestVal);
        
        if(requestVal == null) requestVal = "";
        
        switch(requestVal)
        {
            case "id":
            {
                Collections.sort(airplanes, Airplane.ID);
                break;
            }
            
            case "speed":
            {
                //Collections.sort(airplanes, Airplane.SPEED);
                break;
            }
            
            case "year":
            {
                //Collections.sort(airplanes, Airplane.YEAR);
                break;
            }

            case "manufacturer":
            {
                Collections.sort(airplanes, Airplane.MANUFACTURER);
                break;
            }

            default:
            {
                break;
            }
        }
        
        logger.debug("airplanes list size: " + airplanes.size());
        JSONArray ja = new JSONArray(airplanes);
        
        
        logger.debug("JSONArray length: " + ja.length());
        
        try(PrintWriter out = response.getWriter())
        {
            response.setHeader("Connection", "close");
            response.setContentType("application/json");
            
            out.print(ja.toString());
            out.flush();
            
        } catch(IOException e)
        {
            logger.error("Error writing response to client", e);
        }
        
        logger.debug("successfully wrote response to client");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        
    }
    
}
