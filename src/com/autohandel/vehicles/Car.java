package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.List;
public class Car {
    public CarModel model;
    public List<String> brokenParts = new ArrayList<>();

    public Car( CarModel model, int value, int mileage,String  color,String budgetSegment){
        super( value,  mileage,  color, budgetSegment);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{\n" +
                "     model=" + model +
                ",\n     value=" + value +
                ",\n     mileage=" + mileage +
                ",\n     color='" + color + '\'' +
                ",\n     budgetSegment='" + budgetSegment + '\'' +
                ",\n     brokenParts='" + brokenParts + '\'' +
                "\n}";
    }
}