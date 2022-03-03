package edu.neumont.model;

import java.util.ArrayList;

public class Person {

    private String firstName;
    private String lastName;
    private int balance;
    private int age;
    private int totalLuggage;
    private int userPin;
    private boolean isMinor;

    public boolean isMinor() {
        return isMinor;
    }

    public Person(String firstName, String lastName, int balance, int age, boolean isMinor, int userPin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.age = age;
        this.isMinor = isMinor;
        this.userPin = userPin;
    }

    private ArrayList<Flights> flights = new ArrayList<>();


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalLuggage() {
        return totalLuggage;
    }

    public void setTotalLuggage(int totalLuggage) {
        this.totalLuggage = totalLuggage;
    }

    public int getUserPin() {
        return userPin;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

    public ArrayList<Flights> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
    }

    public void addFlights(Flights flight) {
        this.flights.add(flight);
    }
}