package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarPart;


import java.util.HashMap;
public class CarData {
    public HashMap<String, CarPart> brokenParts = new HashMap<>();
    public CarData(Game currentGame) {
        super(currentGame);
    }

    @Override
    public void init(){
        if (this.indexOfCar != -1) {
            Car car  =this.currentGame.cars.get(this.indexOfCar);
            addMessage(car.model.brandName + " " + car.model.modelName);
            addMessage("price: "+ car.getValueAsString());
            addMessage("mileage: "+ car.mileage );
            addMessage("color: "+ car.color );
            addMessage("budgetSegment: "+ car.budgetSegment );
            addMessage(" ");
            if (car.brokenParts.size() >0 ) {
                addMessage(" Broken Parts: ");
                for (int i=0;i<car.brokenParts.size();i++){
                    if (car.ownership == Car.Ownership.Player) {
                        brokenParts.put(String.valueOf(i),car.model.carParts.get(car.brokenParts.get(i)));
                        addMenuItem("  Repair " + car.brokenParts.get(i) + "", String.valueOf(i));
                    }else{
                        addMessage("    Broken " + car.brokenParts.get(i) + "");
                    }

                }

            }
            if (car.ownership == Car.Ownership.Player){
                addMenuItem("Sell","s");
            }
            if (car.ownership == Car.Ownership.NoOne){
                addMenuItem("Buy","b");
            }
            if(car.repairHistory.size()>0){
                this.addMenuItem("History of repair", "h");
            }

            this.addMenuItem("Back", "q");


        }
    }

    @Override
    public void update() {
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("q"))
            StateManager.changeState(this.lastState);
        if (userData.equals("h")) {
            StateManager.changeState("HistoryOfRepair");
            StateManager.getCurrentState().indexOfCar = this.indexOfCar;
            StateManager.getCurrentState().lastState = this.lastState;
            StateManager.getCurrentState().init();
        }
        if (userData.equals("b")) {
            Car car  =this.currentGame.cars.get(this.indexOfCar);
            car.ownership = Car.Ownership.Player;
            this.currentGame.player1.myCars.add(car);
            this.currentGame.player1.balance -= (car.value*1.02);
            this.currentGame.player1.move +=1;
            this.currentGame.player1.historyOfTransactions.add("Bought \'"+ car.model.brandName + " " + car.model.modelName + "\' for "+ car.getValueAsString());
            StateManager.changeState("Main");
        }
        if (userData.equals("s")) {
            StateManager.changeState("Clients");
            StateManager.getCurrentState().indexOfCar = this.indexOfCar;
            StateManager.getCurrentState().lastState = this.lastState;
            StateManager.getCurrentState().init();
        switch (userData) {
            case "q":
                StateManager.changeState(this.lastState);
                break;
            case "h":
                StateManager.changeState("HistoryOfRepair");
                StateManager.getCurrentState().indexOfCar = this.indexOfCar;
                StateManager.getCurrentState().lastState = this.lastState;
                StateManager.getCurrentState().init();
                break;
            case "b":
                Car car = this.currentGame.cars.get(this.indexOfCar);
                car.ownership = Car.Ownership.Player;
                this.currentGame.player1.myCars.add(car);
                this.currentGame.player1.balance -= (car.value * 1.02);
                this.currentGame.player1.move += 1;
                this.currentGame.player1.historyOfTransactions.add("Bought \'" + car.model.brandName + " " + car.model.modelName + "\' for " + car.getValueAsString() + "PLN");
                StateManager.changeState("Main");
                break;
            case "s":
                StateManager.changeState("Clients");
                StateManager.getCurrentState().indexOfCar = this.indexOfCar;
                StateManager.getCurrentState().lastState = this.lastState;
                StateManager.getCurrentState().init();
                break;
            default:
                StateManager.changeState("Repair");
                StateManager.getCurrentState().indexOfCar = this.indexOfCar;
                StateManager.getCurrentState().dataStr = this.brokenParts.get(userData).name;
                StateManager.getCurrentState().init();
                break;
        }


}
 }
}