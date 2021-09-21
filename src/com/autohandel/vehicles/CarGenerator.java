package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class CarGenerator {
    public static List<String> brands = Arrays.asList( "BMW", "Citroen", "Nissan",  "Renault", "Skoda", "Toyota");
    public static List<String> modelNames = Arrays.asList("T", "D","F", "Model","XXL","Titanic","Stratos","Cyclone");
    public static List<String> colors = Arrays.asList("Black", "White","Black","Black","Black","Black", "White", "Sliver", "Yellow", "Green","Blue", "Purple", "Gray", "DarkGreen", "Pink","LightGray");
    public static List<String> parts = Arrays.asList("breaks","suspension","engine","body","gearbox");

    public static List<Car> generateMany(int number){
        List<Car> cars = new ArrayList<>();
}
}