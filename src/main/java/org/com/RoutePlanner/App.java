package org.com.RoutePlanner;

import java.util.Scanner;

public class App {
    public static void main(String args[])
    {
        FrontEnd obj=new FrontEnd();
        System.out.println("Showing all the available flights:-");
        obj.add();
        System.out.println("Enter the location to get all direct flights details");
        Scanner sc=new Scanner(System.in);
        String loc=sc.next();
        System.out.println("*********************Displaying direct Flights from Location*******************");
        obj.displayDirectFlights(loc);
        System.out.println("Enter Your Boarding loaction");
        String from=sc.next();
        System.out.println("Enter Your destination");
        String to=sc.next();
        System.out.println("*********************Displaying Available Flights********************");
        obj.displayFindFlights(from,to);



		
    }
}

