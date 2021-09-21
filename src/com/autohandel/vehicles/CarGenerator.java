package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class CarGenerator {
    public static List<String> brands = Arrays.asList("Audi", "BMW", "Citroen", "Dacia", "Fiat", "Ford", "Honda", "Hyundai", "Kia", "Mercedes", "Nissan", "Peugeot", "Renault", "SEAT", "Skoda", "Toyota", "Volkswagen", "Volvo");
    public static List<String> brands = Arrays.asList( "BMW", "Citroen", "Nissan",  "Renault", "Skoda", "Toyota");
    public static List<String> modelNames = Arrays.asList("T", "D","F", "Model","XXL","Titanic","Stratos","Cyclone");
    public static List<String> colors = Arrays.asList("Black", "White","Black","Black","Black","Black", "White", "Sliver", "Yellow", "Green","Blue", "Purple", "Gray", "DarkGreen", "Pink","LightGray");

    public static List<Car> generateMany(int number){
        List<Car> cars = new ArrayList<>();
        for (int i =0;i<number;i++){
            cars.add(CarGenerator.generate());
        }
        return cars;
    }

    public static Car generate(){
        int price  = ThreadLocalRandom.current().nextInt(200000, 3000000 + 1);
        CarPart breaks = new CarPart("breaks",0.1,(int)(price*0.059 + ThreadLocalRandom.current().nextInt(20000, 400000 + 1)));
        CarPart suspension = new CarPart("suspension",0.2,(int)(price*0.1 + ThreadLocalRandom.current().nextInt(40000, 500000 + 1)));
        CarPart engine = new CarPart("engine",1,(int)(price*0.5 + ThreadLocalRandom.current().nextInt(200000, 1000000 + 1)));
        CarPart body = new CarPart("body",0.5,(int)(price*0.25 + ThreadLocalRandom.current().nextInt(80000, 1000000 + 1)));
        CarPart gearbox = new CarPart("gearbox",0.5,(int)(price*0.25 + ThreadLocalRandom.current().nextInt(80000, 1000000 + 1)));
        String carName;
        String carColor = colors.get(ThreadLocalRandom.current().nextInt(0, colors.size()));
        String brandName = brands.get(ThreadLocalRandom.current().nextInt(0, brands.size()));
        String budgetSegment = "Budget";

        if (ThreadLocalRandom.current().nextInt(0, 100)<50){
@ -43,7 +44,17 @@ public class CarGenerator {
            carName = modelNames.get(ThreadLocalRandom.current().nextInt(0, modelNames.size())) +" " + ThreadLocalRandom.current().nextInt(0, 999+1);
        }

        return new Car(new CarModel(carName,breaks, suspension,engine,body,gearbox), price , ThreadLocalRandom.current().nextInt(200, 150000 + 1),carColor,budgetSegment);

        Car car =  new Car(new CarModel(brandName,carName,breaks, suspension,engine,body,gearbox), price , ThreadLocalRandom.current().nextInt(200, 150000 + 1),carColor,budgetSegment);
        if (ThreadLocalRandom.current().nextInt(0, 100)<15)
            car.brokenParts.add("breaks");
        if (ThreadLocalRandom.current().nextInt(0, 100)<10)
            car.brokenParts.add("suspension");
        if (ThreadLocalRandom.current().nextInt(0, 100)<2)
            car.brokenParts.add("engine");
        if (ThreadLocalRandom.current().nextInt(0, 100)<5)
            car.brokenParts.add("body");
        if (ThreadLocalRandom.current().nextInt(0, 100)<5)
            car.brokenParts.add("gearbox");
        return car;
    }
}
}
