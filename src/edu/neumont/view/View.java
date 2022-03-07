package edu.neumont.view;

import edu.neumont.database.MySQL;
import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.model.Plane;

import java.util.ArrayList;

public class View {

    static MySQL sql = new MySQL();

    public static void viewAirlines() {
        System.out.println("\n       Airlines\n-----------------------");
            sql.viewAirlines();
        System.out.println("-----------------------");
    }

    public static void viewPlanes() {
        System.out.println("\n       Planes\n-----------------------");
            sql.viewPlanes();
        System.out.println("-----------------------");
    }

    public static void viewFlights() {
        System.out.println("\n        Flights\n-----------------------");
            sql.viewFlights();
        System.out.println("-----------------------");
    }

    public static void viewCustomerFlights(Person customer) {
        System.out.println("\n        Customer Flights\n-----------------------");
        for (int i = 0; i < customer.getFlights().size(); i++) {
            System.out.println(customer.getFlights().get(i).getName());
        }
        System.out.println("-----------------------");
    }

    public static void viewCustomers() {
        System.out.println("\n        Customers\n-----------------------");
            sql.viewUsers();
        System.out.println("-----------------------");
    }
}
