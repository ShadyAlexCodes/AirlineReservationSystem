package edu.neumont.controller;

import edu.neumont.database.MySQL;
import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Plane;
import edu.neumont.utils.Console;
import edu.neumont.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

import static edu.neumont.controller.AirlineController.*;
import static edu.neumont.view.View.*;

public class AirlineManagement {

    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    MySQL sql = new MySQL();

    /* Menus */
    public void manageAirline() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Airline Management", new String[]{"Add Airline", "Remove Airline", "View Airlines"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createAirline();
                case 2 -> removeAirline();
                case 3 -> viewAirlines();
            }
        }
    }

    public void managePlanes() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Plane Management", new String[]{"Add a Plane", "Remove a Plane", "View Planes"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createPlane();
                case 2 -> removePlane();
                case 3 -> viewPlanes();
            }
        }
    }

    public void manageFlights() throws Exception {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Flight Management", new String[]{"Add a Flight", "Remove a Flight", "View Flights"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createFlight();
                case 2 -> removeFlight();
                case 3 -> viewFlights();
            }
        }
    }

    public void manageCustomers() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Plane Management", new String[]{"View Customers"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> viewCustomers();
            }
        }
    }

    /* Airlines */
    private void createAirline() {
        String airlineName = Console.getString("Enter an airline name: ");
        sql.addAirline(airlineName);
    }

    private void removeAirline() {
        viewAirlines();
        int airline_id = Console.getInteger("Enter the airline ID: ");
        sql.removeAirline(airline_id);
    }


    /* Planes */
    private void createPlane() {
        String plane_name = Console.getString("Enter a plane name: ");
        boolean snacks = Console.getBoolean("Does this plane hand out snacks", "yes", "no");
        int total_seats = Console.getInteger("How many seats does this plane have", 12, 75, true);
        sql.addPlane(plane_name, snacks, total_seats);

    }

    private void removePlane() {
        viewPlanes();
        int plane_id = Console.getInteger("Enter a plane id: ");
        sql.removePlane(plane_id);
    }

    /* Flights */
    private void createFlight() throws Exception {

        String flightName = Console.getString("Enter a flight name: ");
        String flightDeparting = Console.getString("Enter a departure location: ");
        String flightArriving = Console.getString("Enter an arriving location: ");
        String flightDuration = Console.getString("Enter the flight duration: ");
        String dateString = Console.getDateString("Enter departure date (mm-dd-yyyy): ", dateFormat);
        Date date = dateFormat.parse(dateString);
        // display plane types
        viewPlanes();
        int planeSelection = Console.getInteger("Enter a plane number: ");
        // display airlines
        viewAirlines();
        int airlineSelection = Console.getInteger("Enter a airline number: ");
         sql.addFlight(flightName, flightDeparting, flightArriving, flightDuration, 100, 0, planeSelection, airlineSelection);
        System.out.println("The flight " + flightName + " has been added!");
    }

    private void removeFlight() {
        viewFlights();
        String flightName = Console.getString("Enter flight name: ");
     /*   for (Flights flight : flights) {
            if (flight.compareType(flightName)) {
                flights.remove(flight);
                System.out.println("The plane " + flightName + " has been removed from the list.");
                break;
            } else {
                System.out.println("The plane " + flightName + " was not found!");
            }
        }*/
    }

}
