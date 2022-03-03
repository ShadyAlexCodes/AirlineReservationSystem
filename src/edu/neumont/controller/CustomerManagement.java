package edu.neumont.controller;

import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.utils.Console;

import static edu.neumont.controller.AirlineController.customers;
import static edu.neumont.controller.AirlineController.flights;
import static edu.neumont.view.View.viewFlights;

public class CustomerManagement {

    static Person customer = null;

    /* Customer */
    public static void createAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Create a user pin", 6, true);
        int age = Console.getInteger("What is your age: ");
        boolean isMinor = age < 18;


        if (checkCustomerExistence(firstName, lastName, userPin) == null) {
            customer = new Person(firstName, lastName, 1000, age, isMinor, userPin);
            customers.add(customer);
            System.out.println("The customer " + customer.getFullName() + " has been created!");
            return;
        }

        System.out.println("The customer " + customer.getFullName() + " already exists in the system.");
    }

    public static Person loginToAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Enter your user pin", 6, true);

        if (checkCustomerExistence(firstName, lastName, userPin) != null) {
            System.out.println("Welcome back " + customer.getFullName() + "!");
            System.out.println("You are booked for the following flights:");
            for (int i = 0; i < customer.getFlights().size(); i++) {
                System.out.println(customer.getFlights().get(i).getAirline() + ": " + customer.getFlights().get(i).getName() + " (" + customer.getFlights().get(i).getDateDepart() + ")");
            }
            return customer;
        } else {
            System.out.println("We could not find an account with the name " + firstName + " " + lastName + "!");
        }
        return null;
    }

    /* Customer Book a Flight */
    public static void bookAFlight(Person customer) {
        if (flights.isEmpty() || customers.isEmpty()) {
            System.out.println("We cannot book a flight because one of the following are missing: Flights, or Customers. Please create an flight or customers before booking a flight.");
            return;
        }

        System.out.println("Welcome back " + customer.getFullName());

        viewFlights(flights);
        int selection = Console.getInteger("Select a flight: ", 0, flights.size(), true);

        customer.addFlights(flights.get(selection));
        flights.get(selection).addPassengers(customer);
    }


    private static Person checkCustomerExistence(String firstName, String lastName, int userPin) {
        int i = 0;
        for (var customer : customers) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) && lastName.equalsIgnoreCase(customer.getLastName()) && userPin == customer.getUserPin()) {
                return customer = customers.get(i);
            }
            i++;
        }
        return null;
    }

    public static void checkBalance(Person customer) {
        System.out.println(customer.getBalance());
    }


}
