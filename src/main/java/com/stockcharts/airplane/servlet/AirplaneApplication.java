package com.stockcharts.airplane.servlet;

import com.google.common.cache.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.apache.log4j.Logger;

@ApplicationPath("servlet")
public class AirplaneApplication extends Application{
    
    private final Logger logger = Logger.getLogger(AirplaneApplication.class.getName());
    public static final String AIRPLANE_FEED_URL = "https://public-api.adsbexchange.com/VirtualRadar/AircraftList.json?fTypQN=";
    
    private Cache<String, List<Airplane>> airplaneCache;
    @PostConstruct
    public void init()
    {
        
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
    
    @PreDestroy
    public void destroy()
    {
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        logger.warn("           airplane-servlet : destroy()");
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        logger.warn("           airplane-servlet : destroy() - COMPLETE");
        logger.warn("<<<<<<<<<<<<<<<<<<<< ######## >>>>>>>>>>>>>>>>>>>>");
        
    }
    
}
