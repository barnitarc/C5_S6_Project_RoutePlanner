
package org.com.RoutePlanner;
import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
public class FrontEnd {

    RouteServiceImplementation obj=new RouteServiceImplementation();

    public void add()
    {
		File file = new File("src\\main\\java\\org\\com\\resources\\flights.csv");
		Reader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			bufferedReader.readLine();
			String data;
			System.out.printf("%15s | %15s | %15s | %15s | %15s\n" ,"From","To","Fare","Distance","Time");
			System.out.println("---------------------------------------------------------------------------------------------");
			while ((data = bufferedReader.readLine()) != null) {
				String record[] = data.split(",");
				
				
				int fare = Integer.parseInt(record[2]);
				String distance = record[3];
				String from = record[0];
				String to = record[1];
				String time = record[4];
				System.out.format("%15s | %15s | %15s | %15s | %15s\n", from,to,String.valueOf(fare),distance,time);
				obj.addFlight(from,to,fare,distance,time);
				
				
			}
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
        /*obj.addFlight("Kolkata","Bangalore",8000,"1500","8");
        obj.addFlight("Kolkata","UP",1500,"6000","7");
        obj.addFlight("Mumbai","Singapore",7000,"2000","9");
        obj.addFlight("Mumbai","Singapore",12000,"3000","5");*/
    }
    public void displayDirectFlights(String loc)
    {
        try {
           List<Route> flights= obj.findDirectFlightFromLocation(loc);
           //Arrays.sort(flights);
           //System.out.println(flights.toString());
           if(flights.size()==0)
        	   System.out.println("Sorry we dont have a flight from this loaction");
           else {
           System.out.printf("%15s | %15s | %15s | %15s | %15s\n" ,"From","To","Fare","Distance","Time");
			System.out.println("---------------------------------------------------------------------------------------------");
			int c=0;
           for(Route flight:flights)
           {
               if(flight!=null) {
                   //System.out.println("From :" + flight.getFrom() +"\n"+"To:" + flight.getTo() +"\n"+ "Fare :" + flight.getFare() +"\n"+ "Distance:" + flight.getDistance()+"\n"+"TravelTime:"+flight.getTravelTime());
                   //System.out.println();
                   System.out.format("%15s | %15s | %15s | %15s | %15s\n", flight.getFrom(),flight.getTo(),String.valueOf(flight.getFare()),flight.getDistance(),flight.getTravelTime());
   					c=1;
               }
           }
           if(c==0)
        	   System.out.println("Sorry we dont have a flight from this loaction");

        }
        }
        catch(Exception e)
        {
            String s= e.getMessage();
            System.out.println(s);
        }
    }
    public void displayFindFlights(String from,String to)
    {
        List<Route> flights= obj.findDirectFlights(from,to);
        System.out.printf("%15s | %15s | %15s | %15s | %15s\n" ,"From","To","Fare","Distance","Time");
		System.out.println("---------------------------------------------------------------------------------------------");
		if(flights.size()==0)
			System.out.println("                            No direct flight available");
        for(Route flight:flights)
        {
            if(flight!=null) {
                //System.out.println("From :"+ flight.getFrom() +"\n"+"To:" + flight.getTo() +"\n"+"Fare :" + flight.getFare()+ "\n"+"Distance:" + flight.getDistance()+"\n"+"TravelTime:"+flight.getTravelTime());
            //System.out.println();
            System.out.format("%15s | %15s | %15s | %15s | %15s\n", flight.getFrom(),flight.getTo(),String.valueOf(flight.getFare()),flight.getDistance(),flight.getTravelTime());
            }
            
        }
        List<Route> iflights= obj.findInterFlights(from,to);
        //System.out.printf("%15s | %15s | %15s | %15s | %15s\n" ,"From","To","Fare","Distance","Time");
		System.out.println("---------------------------------------------------------------------------------------------");
		
        for(Route flight:iflights)
        {
            if(flight!=null) {
                //System.out.println("From :"+ flight.getFrom() +"\n"+"To:" + flight.getTo() +"\n"+"Fare :" + flight.getFare()+ "\n"+"Distance:" + flight.getDistance()+"\n"+"TravelTime:"+flight.getTravelTime());
            //System.out.println();
            System.out.format("%15s | %15s | %15s | %15s | %15s\n", flight.getFrom(),flight.getTo(),String.valueOf(flight.getFare()),flight.getDistance(),flight.getTravelTime());
            }
            
        }


    }
}
