package org.com.RoutePlanner;

import java.util.List;

public interface RouteServices {
     List<Route> findDirectFlightFromLocation(String from) throws NoRouteFoundException;
     List<Route> findFlights(String from,String to);

}
