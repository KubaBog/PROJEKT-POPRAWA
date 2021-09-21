package com.autohandel.people;

public class Mechanic {
    public double priceMultiplier;
    public double repairProbability;
    public double breakProbability;

    public Mechanic(String firstName, String lastName, double priceMultiplier, double repairProbability, double breakProbability) {
        super(firstName, lastName);
        this.priceMultiplier = priceMultiplier;
        this.repairProbability = repairProbability;
        this.breakProbability = breakProbability;
    }
}
