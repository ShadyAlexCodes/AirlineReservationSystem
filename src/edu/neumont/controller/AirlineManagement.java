package edu.neumont.controller;

import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Plane;
import edu.neumont.utils.Console;

import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.neumont.controller.AirlineController.*;
import static edu.neumont.view.View.*;
import static edu.neumont.view.View.viewFlights;

public class AirlineManagement {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

    /* Menus */
    public static void manageAirline() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Airline Management", new String[]{"Add Airline", "Remove Airline", "View Airlines"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createAirline();
                case 2 -> removeAirline();
                case 3 -> viewAirlines(airlines);
            }
        }
    }

    public static void managePlanes() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Plane Management", new String[]{"Add a Plane", "Remove a Plane", "View Planes"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createPlane();
                case 2 -> removePlane();
                case 3 -> viewPlanes(planes);
            }
        }
    }

    public static void manageFlights() throws Exception {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Flight Management", new String[]{"Add a Flight", "Remove a Flight", "View Flights"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createFlight();
                case 2 -> removeFlight();
                case 3 -> viewFlights(flights);
            }
        }
    }

    public static void manageCustomers() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Plane Management", new String[]{"View Customers"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> viewCustomers(customers);
            }
        }
    }

    /* Airlines */
    private static void createAirline() {
        String airlineName = Console.getString("Enter an airline name: ").toLowerCase();
        boolean found = false;
        for (var airline : airlines) {
            if (airlineName.equalsIgnoreCase(airline.getName())) {
                found = true;
                System.out.println("The airline " + airlineName + " already exists!");
                break;
            }
        }
        if (!found) {
            airlines.add(new Airline(airlineName));
            System.out.println("The airline " + airlineName + " has been added to the list.");
        }
    }

    private static void removeAirline() {
        String airlineName = Console.getString("Enter an airline name: ").toLowerCase();
        for (Airline airline : airlines) {
            if (airline.compareType(airlineName)) {
                airlines.remove(airline);
                System.out.println("The airline " + airlineName + " has been removed from the list.");
                break;
            } else {
                System.out.println("The airline " + airlineName + " was not found!");
            }
        }
    }

    /* Planes */
    private static void createPlane() {
        String planeType = Console.getString("Enter a plane type: ").toLowerCase();
        boolean found = false;
        for (var plane : planes) {
            if (planeType.equalsIgnoreCase(plane.getName())) {
                found = true;
                System.out.println("The plane " + planeType + " already exists!");
                break;
            }
        }
        if (!found) {
            boolean snacks = Console.getBoolean("Does this plane hand out snacks", "yes", "no");
/*
            int classes = Console.getInteger("How many classes does this plane have", 1, 4, true);
*/
            int seats = Console.getInteger("How many seats does this plane have", 12, 75, true);

            planes.add(new Plane(planeType, snacks, seats));
            System.out.println("The plane " + planeType + " has been added!");
        }
    }

    private static void removePlane() {
        String planeType = Console.getString("Enter a plane type: ").toLowerCase();
        for (Plane plane : planes) {
            if (plane.compareType(planeType)) {
                planes.remove(plane);
                System.out.println("The plane " + planeType + " has been removed from the list.");
                break;
            } else {
                System.out.println("The plane " + planeType + " was not found!");
            }
        }
    }

    /* Flights */
    private static void createFlight() throws Exception {
        if (airlines.isEmpty() || planes.isEmpty()) {
            System.out.println("There are no airlines or planes in the system! Please create an airline or a plane before adding any flights");
            return;
        }

        String flightName = Console.getString("Enter a flight name: ");
        String flightDeparting = Console.getString("Enter a departure location: ");
        String flightArriving = Console.getString("Enter an arriving location: ");
        String flightDuration = Console.getString("Enter the flight duration: ");
        String dateString = Console.getDateString("Enter departure date (mm-dd-yyyy): ", dateFormat);
        Date date = dateFormat.parse(dateString);
        // display plane types
        viewPlanes(planes);
        int planeSelection = Console.getInteger("Enter a plane number: ", 0, planes.size(), true);
        Plane plane = planes.get(planeSelection);

        // display airlines
        viewAirlines(airlines);
        int airlineSelection = Console.getInteger("Enter a airline number: ", 0, airlines.size(), true);
        Airline airline = airlines.get(airlineSelection);

        Flights newFlight = new Flights(flightName, flightDeparting, flightArriving, plane, airline, date, plane.getTotalSeats(), plane.getTotalSeats() * 5, flightDuration);

        flights.add(newFlight);
        airline.addFlights(newFlight);
        System.out.println("The flight " + flightName + " has been added!");
    }

    private static void removeFlight() {
        viewFlights(flights);
        String flightName = Console.getString("Enter flight name: ").toLowerCase();
        for (Flights flight : flights) {
            if (flight.compareType(flightName)) {
                flights.remove(flight);
                System.out.println("The plane " + flightName + " has been removed from the list.");
                break;
            } else {
                System.out.println("The plane " + flightName + " was not found!");
            }
        }
    }

}
