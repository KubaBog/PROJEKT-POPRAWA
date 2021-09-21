package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;
public class CarData {
    public CarData(Game currentGame) {
        super(currentGame);
    }

    @Override
    public void init(){
        if (this.index1 != -1) {
            addMessage(this.currentGame.cars.get(this.index1).model.brandName + " " + this.currentGame.cars.get(this.index1).model.modelName);



        }
    }

    @Override
    public void update() {
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("b"))
            StateManager.changeState(this.lastState);


    }
}
