package com.autohandel.state;

import com.autohandel.Game;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;
import com.autohandel.vehicles.CarPart;


@ -23,6 +24,7 @@ public class CarData extends State{
            addMessage("mileage: "+ car.mileage );
            addMessage("color: "+ car.color );
            addMessage("budgetSegment: "+ car.budgetSegment );
            addMessage("cost of cleaning and repair: "+ car.getCostOfCleaningAsString() );
            addMessage(" ");
            if (car.brokenParts.size() >0 ) {
                addMessage(" Broken Parts: ");
@ -72,25 +74,27 @@
                car.ownership = Car.Ownership.Player;
                this.currentGame.player1.myCars.add(car);
                this.currentGame.player1.balance -= (car.value * 1.02);
                car.costOfCleaning += (car.value * 0.02);
                this.currentGame.player1.move += 1;
                this.currentGame.player1.historyOfTransactions.add("Bought \'" + car.model.brandName + " " + car.model.modelName + "\' for " + car.getValueAsString() + "PLN");
                this.currentGame.player1.historyOfTransactions.add("Bought '" + car.model.brandName + " " + car.model.modelName + "' for " + car.getValueAsString() + "PLN");
                this.currentGame.cars.add(CarGenerator.generate());
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

