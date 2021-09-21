package com.autohandel.state;
import com.autohandel.Game;
import com.autohandel.people.Client;
import com.autohandel.vehicles.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
public class Selling {
    public int price =0;
    public Selling(Game currentGame) {
        super(currentGame);
    }

    public String getPriceAsString(){
        return String.format("%.2f",(float)(this.price/100));
    }

    @Override
    public void init(){
        if(this.indexOfCar != -1 && this.indexOfClient !=-1) {

//            Car car  =this.currentGame.cars.get(this.indexOfCar);
//            Client client  =this.currentGame.clients.get(this.indexOfClient);
//            if (car.brokenParts.size() ==0 || car.brokenParts.size() ==1 && car.brokenParts.contains("suspension") && client.acceptBroken){
//                if (car.value < client.money){
//
//                }else{
//                    this.addMessage("Sell unsuccessful: Client doesn't have enough money");
//                }
//            }else{
//                this.addMessage("Sell unsuccessful: car is broken");
//            }
            if (price ==0) {
                this.addMessage("   input price");
            }
            this.addMenuItem("Back", "q");
        }else{
            this.price =0;
        }


    }

    @Override
    public void update() {
        printMenu();
        String userData = this.getUserInput();
        if (userData.equals("q"))
            StateManager.changeState("Main");
        else{
            if (price>0){

            }else{
                int price_int = parseInt(userData);
                float price_float = parseFloat(userData);
                if (price_float != price_int) {
                    this.price = (int)(price_float*100);
                }else {
                    this.price = price_int*100;
                }
                this.messages.clear();
                Car car  =this.currentGame.cars.get(this.indexOfCar);
                Client client  =this.currentGame.clients.get(this.indexOfClient);
                if (car.brokenParts.size() ==0 || car.brokenParts.size() ==1 && car.brokenParts.contains("suspension") && client.acceptBroken){
                    if (this.price <= client.money){
                        if (client.likes.contains(car.model.brandName)){
                            car.ownership = Car.Ownership.Client;
                            this.currentGame.player1.balance += (this.price*0.98);
                            this.currentGame.player1.myCars.remove(car);
                            this.currentGame.player1.move +=1;
                            this.currentGame.player1.historyOfTransactions.add("Sold \'"+ car.model.brandName + " " + car.model.modelName + "\' for "+ this.getPriceAsString());
                            this.currentGame.player1.historyOfTransactions.add("Sold '"+ car.model.brandName + " " + car.model.modelName + "' for "+ this.getPriceAsString() + "PLN");

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
}
