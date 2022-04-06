package org.com.RoutePlanner;

import java.util.List;

public interface RouteServices {
     List<Route> findDirectFlightFromLocation(String from) throws NoRouteFoundException;
     List<Route> findDirectFlights(String from,String to);
     List<Route> findInterFlights(String from,String to);

}
