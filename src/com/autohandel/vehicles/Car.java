package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.List;
public class Car {
    public enum Ownership {
        NoOne, Player, Client;
    }


    public CarModel model;
    public List<String> brokenParts = new ArrayList<>();
    public List<String> repairHistory = new ArrayList<>();
    public Ownership ownership = Ownership.NoOne;

    public Car( CarModel model, int value, int mileage,String  color,String budgetSegment){
        super( value,  mileage,  color, budgetSegment);  
}
}