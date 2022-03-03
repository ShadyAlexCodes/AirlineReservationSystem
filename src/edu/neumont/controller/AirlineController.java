package edu.neumont.controller;

import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.model.Plane;
import edu.neumont.utils.Console;

import java.util.ArrayList;

import static edu.neumont.controller.AirlineManagement.*;
import static edu.neumont.controller.CustomerManagement.*;
import static edu.neumont.view.View.viewCustomerFlights;

public class AirlineController {

    public static final ArrayList<Airline> airlines = new ArrayList<>();
    public static final ArrayList<Flights> flights = new ArrayList<>();
    public static final ArrayList<Plane> planes = new ArrayList<>();
    public static final ArrayList<Person> customers = new ArrayList<>();

    public void run() throws Exception {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Main Menu", new String[]{"Airline Management", "Customer Management"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> airlineManagement();
                case 2 -> customerManagement();
            }
        }
    }

    private void airlineManagement() throws Exception {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Airline Management", new String[]{"Manage Airlines", "Manage Planes", "Manage Flights", "Manage Customers"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> manageAirline();
                case 2 -> managePlanes();
                case 3 -> manageFlights();
                case 4 -> manageCustomers();
            }
        }
    }

    private void customerManagement() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Customer Management", new String[]{"Create Account", "Login to Account"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> createAccount();
                case 2 -> customerLogin();

            }
        }
    }

    private void customerLogin() {
        boolean quit = false;
        Person customer = loginToAccount();
        if (customer != null) {
            while (!quit) {
                int selection = Console.getMenuSelection("Customer Management", new String[]{"Check Balance", "Book a Flight", "Cancel a Flight", "View Flights"}, true);
                switch (selection) {
                    case 0 -> quit = true;
                    case 1 -> checkBalance(customer);
                    case 2 -> bookAFlight(customer);
                    case 3 -> cancelAFlight(customer, flights);
                    case 4 -> viewCustomerFlights(customer);

                }
            }
        }
    }
}
