package edu.neumont.model;

public abstract class Airport {

    String name;

    public boolean compareType(String name) {
        return this.name.equalsIgnoreCase(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
