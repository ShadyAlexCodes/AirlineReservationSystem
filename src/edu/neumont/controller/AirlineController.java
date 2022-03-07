package edu.neumont.controller;

import edu.neumont.model.Airline;
import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.model.Plane;
import edu.neumont.utils.Console;

import java.util.ArrayList;
import static edu.neumont.view.View.viewCustomerFlights;

public class AirlineController {

    protected ArrayList<Airline> airlines = new ArrayList<>();
    protected ArrayList<Flights> flights = new ArrayList<>();
    protected ArrayList<Plane> planes = new ArrayList<>();
    protected ArrayList<Person> customers = new ArrayList<>();

    CustomerManagement customerManagement = new CustomerManagement();
    AirlineManagement airlineManagement = new AirlineManagement();

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
                case 1 -> airlineManagement.manageAirline();
                case 2 -> airlineManagement.managePlanes();
                case 3 -> airlineManagement.manageFlights();
                case 4 -> airlineManagement.manageCustomers();
            }
        }
    }

    private void customerManagement() {
        boolean quit = false;

        while (!quit) {
            int selection = Console.getMenuSelection("Customer Management", new String[]{"Create Account", "Login to Account"}, true);
            switch (selection) {
                case 0 -> quit = true;
                case 1 -> customerManagement.createAccount();
                case 2 -> customerLogin();

            }
        }
    }

    private void customerLogin() {
        boolean quit = false;
        Person customer = customerManagement.loginToAccount();
        if (customer != null) {
            while (!quit) {
                int selection = Console.getMenuSelection("Customer Management", new String[]{"Check Balance", "Book a Flight", "Cancel a Flight", "View Flights"}, true);
                switch (selection) {
                    case 0 -> quit = true;
                    case 1 -> customerManagement.checkBalance(customer);
                    case 2 -> customerManagement.bookAFlight(customer);
                    //case 3 -> customerManagement.cancelAFlight(customer);
                    case 4 -> viewCustomerFlights(customer);

                }
            }
        }
    }
}
