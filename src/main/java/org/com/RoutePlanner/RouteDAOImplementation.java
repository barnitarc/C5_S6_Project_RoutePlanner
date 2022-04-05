

package org.com.RoutePlanner;

import java.util.ArrayList;
import java.util.List;

public class RouteDAOImplementation implements RouteDAO{
    private List<Route> route;
    public RouteDAOImplementation()
    {
        route=new ArrayList<>();
    }

    @Override
    public List<Route> findAll()
    {
        return route;
    }
}
