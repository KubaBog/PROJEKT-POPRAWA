package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;
public class HistoryOfReapair {
    public HistoryOfRepair(Game currentGame) {
        super(currentGame);
    }

    @Override
    public void init(){
        if (this.indexOfCar != -1) {
            Car car =this.currentGame.cars.get(this.indexOfCar);
            for (String history : car.repairHistory){
                this.addMessage(history);
            }
            this.addMenuItem("Back", "q");
        }
        this.addMenuItem("Back", "q");


    }
}
