package com.autohandel.vehicles;

public class Vehicle {
    public int value;
    public String brand;
    public int mileage;
    public String color;
    public String budgetSegment;

    public Vehicle( int value, int mileage,String  color,String budgetSegment){
        this.value = value;
        this.mileage = mileage;
        this.color = color;
        this.budgetSegment = budgetSegment;
    }
}
