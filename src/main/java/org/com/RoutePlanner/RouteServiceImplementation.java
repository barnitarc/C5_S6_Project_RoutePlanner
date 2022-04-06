


package org.com.RoutePlanner;

import java.util.Arrays;
import java.util.*;

public class RouteServiceImplementation implements RouteServices {
    RouteDAOImplementation obj;
    private int index=0;
    private List<Route> routeArray;
    
    private int i=0;
    RouteServiceImplementation x;
   public RouteServiceImplementation()
    {
        obj= new RouteDAOImplementation();
        routeArray =new ArrayList<>();
        
    }
    public void addFlight(String from, String to, int fare, String distance, String travelTime)
    {
     routeArray.add(new Route(from,to,fare,distance,travelTime)) ;
     
    }
    @Override
    public List<Route> findDirectFlightFromLocation(String from) throws NoRouteFoundException
    {
        
     List<Route> tempFlights=new ArrayList<>();
     int index=0;
     for(Route flight: routeArray)
     {
         if(flight.getFrom().equalsIgnoreCase(from)) {
             tempFlights.add(flight);
         
         }
     }
     
     //Collections.sort(tempFlights);
     if(tempFlights==null)
    	 throw new NoRouteFoundException("No Route Found");
     if(tempFlights!=null) {
    	 //Arrays.sort(tempFlights);
         return tempFlights;
     }
     
     throw new NoRouteFoundException("No Route Found");
    
    }
    
    public List<Route> findSortedDirectFlightFromLocation(List<Route> r)
    {
    	Collections.sort(r);
    	return r;
    }
    
    public boolean isAvailable(String from,String to)
    {
    	for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                return true;
            }
        }
    	return false;
    }
    public Route interFlight(String from,String to)
    {
    	for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                return flight;
            }
        }
    	return null;
    }
    public List<Route> findDirectFlights(String from,String to)
    {
    	List<Route> tempFlights=new ArrayList<>();
        
        for(Route flight: routeArray)
        {
        	if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                tempFlights.add(flight);
                
            }
        }
        if(tempFlights!=null) {
            return tempFlights;
        }
        return null;
    }
    
    public List<Route> findInterFlights(String from,String to)
    {
    	List<Route> tempFlights=new ArrayList<>();
        for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && isAvailable(flight.getTo(),to))
            {
            	
            	tempFlights.add(flight);
                
                tempFlights.add(interFlight(flight.getTo(),to));
                
            }
        }
        if(tempFlights!=null) {
            return tempFlights;
        }
        return null;
    }
    
}

