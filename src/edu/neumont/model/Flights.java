package edu.neumont.model;

import java.util.ArrayList;
import java.util.Date;

public class Flights extends Airport {


    private String locationDepart;
    private String locationArrive;
    private Plane plane;
    private Airline airline;
    private Date dateDepart;
    private int totalSeats;
    private int price;
    private String duration;
    private ArrayList<Person> passengers = new ArrayList<>();


    public Flights(String name, String locationDepart, String locationArrive, Plane plane, Airline airline, Date dateDepart, int totalSeats, int price, String duration) {
        super.name = name;
        this.locationDepart = locationDepart;
        this.locationArrive = locationArrive;
        this.plane = plane;
        this.airline = airline;
        this.dateDepart = dateDepart;
        this.totalSeats = totalSeats;
        this.price = price;
        this.duration = duration;
    }



    public String getLocationDepart() {
        return locationDepart;
    }

    public void setLocationDepart(String locationDepart) {
        this.locationDepart = locationDepart;
    }

    public String getLocationArrive() {
        return locationArrive;
    }

    public void setLocationArrive(String locationArrive) {
        this.locationArrive = locationArrive;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane planeType) {
        this.plane = planeType;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Person> getPassengers() {
        return passengers;
    }

    public void addPassengers(Person person) {
        if(this.passengers.size() >= totalSeats) {
            System.out.println("You cannot add any more people to this flight!");
            return;
        }
        this.passengers.add(person);
    }
}
