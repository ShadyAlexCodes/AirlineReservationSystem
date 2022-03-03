package edu.neumont.controller;

import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.utils.Console;

import java.util.ArrayList;

import static edu.neumont.controller.AirlineController.*;
import static edu.neumont.view.View.*;

public class CustomerManagement {

    static Person customer = null;
    static Flights flight = null;

    /* Customer */
    public static void createAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Create a user pin", 6, true);
        int age = Console.getInteger("What is your age: ");
        boolean isMinor = false;
        if(age < 18) isMinor = true;


        if(!checkCustomerExistence(firstName, lastName, userPin)) {
            customer = new Person(firstName, lastName, 1000, age, isMinor, userPin);
            customers.add(customer);
            System.out.println("The customer " + customer.getFullName() + " has been created!");
            return;
        }

        System.out.println("The customer " + customer.getFullName() + " already exists in the system.");
    }

    public static void loginToAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Enter your user pin",  6, true);

        if(checkCustomerExistence(firstName, lastName, userPin)) {
            System.out.println("Welcome back " + customer.getFullName() + "!");
            System.out.println("You are booked for the following flights:");
            for (int i = 0; i < customer.getFlights().size(); i++) {
                System.out.println(customer.getFlights().get(i).getAirline() + ": " + customer.getFlights().get(i).getName() + " (" + customer.getFlights().get(i).getDateDepart() + ")");
            }
        } else {
            System.out.println("We could not find an account with the name " + firstName + " " + lastName + "!");
        }
    }

    /* Customer Book a Flight */
    public static void bookAFlight() {
        if (flights.isEmpty() || customers.isEmpty()) {
            System.out.println("We cannot book a flight because one of the following are missing: Flights, or Customers. Please create an flight or customers before booking a flight.");
            return;
        }

        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Enter your user pin",  6, true);

        if(checkCustomerExistence(firstName, lastName, userPin)) {
            viewFlights(flights);
            int selection = Console.getInteger("Select a flight: ", 0, flights.size(), true);

            customer.addFlights(flights.get(selection));
            flights.get(selection).addPassengers(customer);
        }

    }

    private static boolean checkCustomerExistence(String firstName, String lastName, int userPin) {
        int i = 0;
        for (var customer : customers) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) && lastName.equalsIgnoreCase(customer.getLastName()) && userPin == customer.getUserPin()) {
                customer = customers.get(i);
                return true;
            }
            i++;
        }
        return false;
    }


    public static void viewCustomerFlights() {
        System.out.println("\n        Customer Flights\n-----------------------");
        for (int i = 0; i < customer.getFlights().size(); i++) {
            System.out.println(customer.getFlights().get(i).getName());
        }
        System.out.println("-----------------------");
    }
}
