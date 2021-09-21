package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;
public class CarsForSale {
    public CarsForSale(Game currentGame){
        super(currentGame);
    }

    public void init(){
        int i =0;
        for (Car car : this.currentGame.cars){
            String brandModel = (car.model.brandName + " " + car.model.modelName);
            if (car.brokenParts.size() > 0){
                if (car.brokenParts.size() ==1){
                    brandModel += " (broken "+car.brokenParts.get(0) + ")";
                }else{
                    brandModel += " (broken "+car.brokenParts.size() + " parts)";
                }
            }
            int padding = 70 -( brandModel + String.valueOf(i) +" PLN" + String.format("%.2f",(double)car.value/100)).length();
            this.addMenuItem(brandModel+ " ".repeat(padding) + String.format("%.2f",(double)car.value/100) +" PLN" ,String.valueOf(i));
            i++;
        }
        this.addMenuItem("Back", "b");

    }

    public void update (){
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("b"))
            StateManager.changeState("Main");

    }



}
}
