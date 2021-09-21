package com.autohandel.state;

import com.autohandel.Game;
import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

import java.io.BufferedReader;
import java.io.IOException;
@ -51,14 +53,14 @@ public class Selling extends State{

    @Override
    public void update() {


        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("q"))
            StateManager.changeState("Main");
        else{
            if (price>0){

            }else{
            if (!(price>0)){
                int price_int = parseInt(userData);
                float price_float = parseFloat(userData);
                if (price_float != price_int) {
@ -74,63 +76,67 @@
                        if (client.likes.contains(car.model.brandName)){
                            car.ownership = Car.Ownership.Client;
                            this.currentGame.player1.balance += (this.price*0.98);
                            car.costOfCleaning += (this.price*0.02);
                            this.currentGame.player1.myCars.remove(car);
                            this.currentGame.player1.move +=1;
                            this.currentGame.player1.historyOfTransactions.add("Sold '"+ car.model.brandName + " " + car.model.modelName + "' for "+ this.getPriceAsString() + "PLN");

                            this.currentGame.clients.add(ClientGenerator.generate());
                            this.currentGame.clients.add(ClientGenerator.generate());
                            this.currentGame.clients.remove(client);
//                            this.currentGame.cars.add(CarGenerator.generate());
                            StateManager.changeState("Main");
                        }else{
                            this.addMessage("Sell unsuccessful: Client doesn't like brand of Car");
                        }
                    }else{
                        this.addMessage("Sell unsuccessful: Client doesn't have enough money");
                    }
                }else{
                    this.addMessage("Sell unsuccessful: Car is broken");
                }


            }
        }


    }
    @Override
    public String getUserInput(){
        String s = "";
        System.out.print(" Choose option: ");
        boolean is_legal = false;
        while (s.length() <1 && !is_legal){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                s = reader.readLine();
                for (String character : menuActions){
                    if (s.toLowerCase().startsWith(character)){
                        is_legal = true;
                        break;
                    }
                }
                if (s.matches("[0-9]+"))
                {
                    is_legal = true;
                    break;
                }
                if (!is_legal){
                    System.out.println(" Wrong Input");
                    System.out.print(" Choose option: ");
                    s = "";
                }
            }catch (IOException e){
                System.out.print("Wrong Input");
                System.out.print(" Choose option: ");
                s = "";
            }

        }
        return s.toLowerCase();
    }



}

