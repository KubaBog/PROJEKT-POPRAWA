package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    public int value;
    public int mileage;
    public String color;
    public String budgetSegment;
    public List<String> historyOfRepairs;

    public Vehicle( int value, int mileage,String  color,String budgetSegment){
        this.value = value;
        this.mileage = mileage;
        this.color = color;
        this.budgetSegment = budgetSegment;
        this.historyOfRepairs = new ArrayList<>();
    }

}
