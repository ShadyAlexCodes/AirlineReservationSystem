package edu.neumont.model;

import java.util.ArrayList;

public class Airline extends Airport {


    private ArrayList<Flights> flights = new ArrayList<Flights>();

    public Airline() {
    }

    public Airline(String name) {
        super.name = name;
    }


    public void setName(String name) {
        this.name = name;
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

    public void removeFlights(Flights flight) {
        this.flights.remove(flight);
    }

}
