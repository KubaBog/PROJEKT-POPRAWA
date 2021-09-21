package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;

import java.util.HashMap;
public class MyCars {
    public HashMap<String,Car> cars = new HashMap<>();


    public MyCars(Game currentGame){
        super(currentGame);
    }

    @Override
    public void init(){
        int i =0;
        for (Car car : this.currentGame.player1.myCars){
@ -21,6 +27,7 @@ public class MyCars extends State{
                }
            }
            int padding = 70 -( brandModel + String.valueOf(i) +" PLN" + String.format("%.2f",(double)car.value/100)).length();
            this.cars.put(String.valueOf(i),car);
            this.addMenuItem(brandModel+ " ".repeat(padding) + String.format("%.2f",(double)car.value/100) +" PLN" ,String.valueOf(i));
            i++;
        }
@ -28,11 +35,17 @@ public class MyCars extends State{

    }

    @Override
    public void update (){
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("b"))
            StateManager.changeState("Main");
            StateManager.changeState(this.lastState);
        else{
            StateManager.changeState("CarData");
            StateManager.getCurrentState().index1 = this.currentGame.cars.indexOf(this.cars.get(userData));
            StateManager.getCurrentState().init();
        }

    }
 
}
