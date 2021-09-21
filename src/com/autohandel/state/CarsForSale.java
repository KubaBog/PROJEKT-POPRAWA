package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;

import java.util.HashMap;
public class CarsForSale {
    
    public HashMap<String,Car> cars = new HashMap<>();

    public CarsForSale(Game currentGame){
        super(currentGame);
    }

    @Override
    public void init(){
        int i =0;
        for (Car car : this.currentGame.cars){
            String brandModel = (car.model.brandName + " " + car.model.modelName);
            if (car.brokenParts.size() > 0){
                if (car.brokenParts.size() ==1){
                    brandModel += " (broken "+car.brokenParts.get(0) + ")";
                }else{
                    brandModel += " (broken "+car.brokenParts.size() + " parts)";
            if (car.ownership == Car.Ownership.NoOne) {
                String brandModel = (car.model.brandName + " " + car.model.modelName);
                if (car.brokenParts.size() > 0) {
                    if (car.brokenParts.size() == 1) {
                        brandModel += " (broken " + car.brokenParts.get(0) + ")";
                    } else {
                        brandModel += " (broken " + car.brokenParts.size() + " parts)";
                    }
                }
                int padding = 70 - (brandModel + String.valueOf(i) + " PLN" + String.format("%.2f", (double) car.value / 100)).length();
                this.cars.put(String.valueOf(i),car);
                this.addMenuItem(brandModel + " ".repeat(padding) + String.format("%.2f", (double) car.value / 100) + " PLN", String.valueOf(i));
                i++;
            }
            int padding = 70 -( brandModel + String.valueOf(i) +" PLN" + String.format("%.2f",(double)car.value/100)).length();
            this.addMenuItem(brandModel+ " ".repeat(padding) + String.format("%.2f",(double)car.value/100) +" PLN" ,String.valueOf(i));
            i++;
        }
        this.addMenuItem("Back", "b");

    }

    @Override
    public void update (){
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("b"))
            StateManager.changeState("Main");

        else{
            StateManager.changeState("CarData");
            StateManager.getCurrentState().index1 = this.currentGame.cars.indexOf(this.cars.get(userData));
            StateManager.getCurrentState().init();
        }
    }
        }
