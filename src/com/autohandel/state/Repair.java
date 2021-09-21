package com.autohandel.state;

import com.autohandel.Game;
import com.autohandel.people.Mechanic;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;
import com.autohandel.vehicles.CarPart;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Repair extends State {

    public HashMap<String,Mechanic> mechanics = new HashMap<>();

    public Repair(Game currentGame) {
        super(currentGame);
    }

    @Override
    public void init(){
        if (this.indexOfCar != -1 && this.dataStr.length() > 0) {
            Car car =this.currentGame.cars.get(this.indexOfCar);
            CarPart carpart = car.model.carParts.get(this.dataStr);
            this.addMessage(car.getFullName() + "    broken "+ this.dataStr);
            this.addMessage("");
            this.addMessage("Choose mechanic: ");
            this.addMessage("Name ---- Price ---- Repair probability ---- Probability of breaking");
            int i=0;
            for (Mechanic mechanic : this.currentGame.mechanics){
                this.addMenuItem(mechanic.toString() + "    " + String.format("%.2f",(float)((carpart.costOfRepair/100)*mechanic.priceMultiplier)) +"PLN    "+ String.format("%.0f",mechanic.repairProbability*100)+"%    "+ String.format("%.0f",mechanic.breakProbability*100)+"%",String.valueOf(i));
                this.mechanics.put(String.valueOf(i),mechanic);
                i++;
            }
            this.addMenuItem("Back", "q");
        }

    }

    @Override
    public void update() {
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("q")) {
            StateManager.changeState("Main");
        }else{
            Mechanic mechanic = this.mechanics.get(userData);
            Car car =this.currentGame.cars.get(this.indexOfCar);
            CarPart carpart = car.model.carParts.get(this.dataStr);
            boolean failed = false;
            if (ThreadLocalRandom.current().nextInt(0, 100) >= mechanic.repairProbability*100){
                failed = true;
            }

            if (ThreadLocalRandom.current().nextInt(0, 100) < mechanic.breakProbability*100){
                failed = true;
                if (car.brokenParts.size() < 5) {
                    String new_broken_part = "";
                    do {
                        new_broken_part = CarGenerator.parts.get(ThreadLocalRandom.current().nextInt(0, CarGenerator.parts.size()));
                    } while (car.brokenParts.contains(new_broken_part));
                    car.brokenParts.add(new_broken_part);
                }
            }
            if (!failed){
                car.brokenParts.remove(carpart.name);
                car.value += carpart.priceUpPercentage*car.value;
                car.repairHistory.add("Repair of "+ carpart.name +" succeed");
            }else{
                System.out.println("Repair FAILED");
                car.repairHistory.add("Repair of "+ carpart.name +" failed");
            }
            this.currentGame.player1.historyOfTransactions.add("Repair of "+ carpart.name +" costed " + String.format("%.2f",(float)((carpart.costOfRepair/100)*mechanic.priceMultiplier))+ "PLN");
            this.currentGame.player1.balance -= ((carpart.costOfRepair)*mechanic.priceMultiplier);
            car.costOfCleaning += ((carpart.costOfRepair)*mechanic.priceMultiplier);
            this.currentGame.player1.move +=1;
            StateManager.changeState("Main");


        }



    }
}

