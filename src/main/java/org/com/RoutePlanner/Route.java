

package org.com.RoutePlanner;

public class Route implements Comparable<Route>{
    private String from;
    private String to;
    private int fare;
    private String distance;
    private String travelTime;

    public Route(String from, String to, int fare, String distance, String travelTime) {
        this.from = from;
        this.to = to;
        this.fare = fare;
        this.distance = distance;
        this.travelTime = travelTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }
    @Override
    public int compareTo(Route r)
    {
    	//System.out.println(this.to+" "+r.getTo());
    	return this.to.compareToIgnoreCase(r.getTo());
    }
}
