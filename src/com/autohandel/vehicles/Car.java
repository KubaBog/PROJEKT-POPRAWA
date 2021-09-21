package com.autohandel.vehicles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Car extends Vehicle{
    public enum Ownership {
        NoOne, Player, Client
    }


    public CarModel model;
    public List<String> brokenParts = new ArrayList<>();
    public List<String> repairHistory = new ArrayList<>();
    public Ownership ownership = Ownership.NoOne;

    public int costOfCleaning = 0;
    public Car( CarModel model, int value, int mileage,String  color,String budgetSegment){
        super( value,  mileage,  color, budgetSegment);
        this.model = model;
@ -39,6 +39,10 @@ public class Car extends Vehicle{
    public String getValueAsString(){
        return String.format("%.2f",(float)(this.value/100));
    }
    public String getCostOfCleaningAsString(){
        return String.format("%.2f",(float)(this.costOfCleaning/100));
    }



}
