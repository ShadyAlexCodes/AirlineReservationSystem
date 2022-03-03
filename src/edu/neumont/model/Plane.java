package edu.neumont.model;

public class Plane extends Airport {

    private boolean snacks;
    private int classes;
    private int totalSeats;


    public Plane(String name, boolean snacks, int classes, int totalSeats) {
        super.name = name;
        this.snacks = snacks;
        this.classes = classes;
        this.totalSeats = totalSeats;
    }

    public Plane() {}

    public boolean haveSnacks() {
        return snacks;
    }

    public int getClasses() {
        return classes;
    }

    public int getTotalSeats() {
        return totalSeats;
    }
}
