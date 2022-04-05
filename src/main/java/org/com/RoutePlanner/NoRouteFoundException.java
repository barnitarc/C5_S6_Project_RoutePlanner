

package org.com.RoutePlanner;

public class NoRouteFoundException extends Exception{
    public NoRouteFoundException(String message)
    {
        super(message);
    }
}
