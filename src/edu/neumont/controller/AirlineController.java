package edu.neumont.controller;

import edu.neumont.utils.Console;

public class AirlineController {
    /**
     * - Create a GUI with Options
     *  - 1. Airline Management
     *      - Create Airline
     *         - Create Plane
     *         - Price
     *         - Sections
     *         - Seats
     *      - Create flight
     *          - Assign Airline, Plane
     *          - Start Location, Final Destination
     *          - Airline Price
     *          - Airline Avaliable Seats.
     *          - Confirmation
     *      - Remove Flight
     *          - Remove Airline, Customers (refund), Planes
     *      - Check Flight
     *          - Specific Airline / Plane / Flight #
     *  - 2. Customer Management
     *      - Create Account
     *      - Login to account
     *      - Check balance
     *      - Book Flight
     *          - Ask for a date
     *          - Ask for final destination
     *          - Check if flights exist
     *          - Ask for seat
     *          - Tell user the price
     *          - Confirm flight
     *      - Drop a flight
     *          - remove customer form flight
     *          - refund 85%
     *
     */


    public void run() {
        boolean quit = false;

        while(!quit) {
            int selection = Console.getMenuSelection(new String[]{"Airline Management", "Customer Management"}, true);

            switch(selection) {
                case 0 -> quit = true;
                case 1 -> airlineManagement();
                case 2 -> customerManagement();
            }
        }
    }

    private void airlineManagement() {
        boolean quit = false;

        while(!quit) {
            int selection = Console.getMenuSelection(new String[]{"Manage Airlines", "Manage Planes", "Manage Flights"}, true);

            switch(selection) {
                case 0 -> quit = true;
                case 1 -> System.out.println("Managing Airlines");
                case 2 -> System.out.println("Manage planes");
                case 3 -> System.out.println("Manage flights");
            }
        }
    }

    private void customerManagement() {
        boolean quit = false;

        while(!quit) {
            int selection = Console.getMenuSelection(new String[]{"Create Account", "Login to Account", "Check Balance", "Book a Flight", "Cancel a Flight"}, true);

            switch(selection) {
                case 0 -> quit = true;
                case 1 -> System.out.println("Create account");
                case 2 -> System.out.println("Login to account");
                case 3 -> System.out.println("Check balance");
                case 4 -> System.out.println("Book a flight");
                case 5 -> System.out.println("Cancel a flight");

            }
        }
    }

}
