package edu.neumont.view;

import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.model.Plane;

import java.util.ArrayList;

public class View {

    public static void viewAirlines(ArrayList<Airline> airlines) {
        int i = 0;
        System.out.println("\n       Airlines\n-----------------------");
        for (var airline : airlines) {
            System.out.println(i + ": " + airline.getName() + " | " + airline.getFlights());
            i++;
        }
        System.out.println("-----------------------");
    }

    public static void viewPlanes(ArrayList<Plane> planes) {
        int i = 0;
        System.out.println("\n       Planes\n-----------------------");
        for (var plane : planes) {
            System.out.println(i + ": " + plane.getName() +
                    "  | Seats: " + plane.getTotalSeats() +
                    "  | Classes: " + plane.getClasses() +
                    "  | Snacks: " + plane.haveSnacks());
            i++;
        }
        System.out.println("-----------------------");
    }

    public static void viewFlights(ArrayList<Flights> flights) {
        int i = 0;
        System.out.println("\n        Flights\n-----------------------");
        for(var flight : flights) {
            System.out.println(i + ": " + flight.getName() +
                    "  | Departing: " + flight.getLocationDepart() +
                    "  | Arriving: " + flight.getLocationArrive() +
                    "  | Plane Type: " + flight.getPlane().getName() +
                    "  | Airline: " + flight.getAirline().getName() +
                    "  | Departing Date: " + flight.getDateDepart() +
                    "  | Total Passengers: " + flight.getTotalSeats() +
                    "  | Total Duration: " + flight.getDuration() +
                    "\n  | Passengers: " + flight.getPassengers());
        }
        System.out.println("-----------------------");
    }

    public static void viewCustomerFlights(Person customer) {
        System.out.println("\n        Customer Flights\n-----------------------");
        for (int i = 0; i < customer.getFlights().size(); i++) {
            System.out.println(customer.getFlights().get(i).getName());
        }
        System.out.println("-----------------------");
    }

    public static void viewCustomers(ArrayList<Person> customers) {
        System.out.println("\n        Customers\n-----------------------");
        for(var customer : customers) {
            System.out.println(customer.getFullName() +
                    "  | Age: " + customer.getAge() +
                    "  | Minor: " + customer.isMinor() +
                    "  | Balance: " + customer.getBalance() +
                    "  | Flights: " + customer.getFlights());
        }
        System.out.println("-----------------------");
    }
}
