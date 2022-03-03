package edu.neumont;

import edu.neumont.controller.AirlineController;

public class Main {
    /**
     * - Create a GUI with Options
     * - 1. Airline Management
     * - Create Airline
     * - Create Plane
     * - Price
     * - Sections
     * - Seats
     * - Create flight
     * - Assign Airline, Plane
     * - Start Location, Final Destination
     * - Airline Price
     * - Airline Avaliable Seats.
     * - Confirmation
     * - Remove Flight
     * - Remove Airline, Customers (refund), Planes
     * - Check Flight
     * - Specific Airline / Plane / Flight #
     * - 2. Customer Management
     * - Create Account
     * - Login to account
     * - Check balance
     * - Book Flight
     * - Ask for a date
     * - Ask for final destination
     * - Check if flights exist
     * - Ask for seat
     * - Tell user the price
     * - Confirm flight
     * - Drop a flight
     * - remove customer form flight
     * - refund 85%
     */

    public static void main(String[] args) {
        AirlineController controller = new AirlineController();
        try {
            controller.run();
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
