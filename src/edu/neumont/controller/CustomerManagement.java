package edu.neumont.controller;

import edu.neumont.database.MySQL;
import edu.neumont.model.Flights;
import edu.neumont.model.Person;
import edu.neumont.utils.Console;

import java.util.ArrayList;

import static edu.neumont.view.View.viewCustomerFlights;
import static edu.neumont.view.View.viewFlights;

public class CustomerManagement {

    public static Person customer = null;
    static MySQL sql = new MySQL();

    /* Customer */
    public void createAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Create a user pin", 4, true);
        int age = Console.getInteger("What is your age: ");
        boolean isMinor = age < 18;

        if (checkCustomerExistence(firstName, lastName, userPin) == null) {
            customer = new Person(firstName, lastName, 1000, age, isMinor, userPin);
            sql.addUser(firstName, lastName, isMinor, age, 1000, userPin);
           // customers.add(customer);
            System.out.println("The customer " + customer.getFullName() + " has been created!");
            return;
        }

        System.out.println("The customer " + firstName + lastName + " already exists in the system.");
        customer = null;
    }


    /* Customer Book a Flight */
    public void bookAFlight(Person customer) {


        System.out.println("Welcome back " + customer.getFullName());

        viewFlights();
        //int selection = Console.getInteger("Select a flight: ", 0, flights.size(), true);
/*
        customer.addFlights(flights.get(selection));
        flights.get(selection).addPassengers(customer);*/
    }

    public void cancelAFlight(Person customer, ArrayList<Flights> flights) {
        viewCustomerFlights(customer);

        int selection = Console.getInteger("Enter a flight selection: ", 0, customer.getFlights().size(), true);
        customer.getFlights().remove(selection);
        flights.get(selection).getPassengers().remove(customer);
    }


    public void checkBalance(Person customer) {
        System.out.println(customer.getBalance());
    }

    public Person loginToAccount() {
        String firstName = Console.getString("Enter your first name: ");
        String lastName = Console.getString("Enter your last name: ");
        int userPin = Console.getInteger("Enter your user pin", 4, true);

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

    private Person checkCustomerExistence(String firstName, String lastName, int userPin) {
        int i = 0;

        return customer = sql.checkUserExistence(firstName, lastName, userPin);
    }
}
