package com.autohandel;

import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.people.Mechanic;
import com.autohandel.state.CarsForSale;
import com.autohandel.state.Main;
import com.autohandel.state.MyCars;
import com.autohandel.state.StateManager;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

@ -10,6 +14,7 @@ import java.util.ArrayList;
import java.util.List;

public class Game {

    public int turn;
    public List<Car> cars;
    public List<Client> clients;
@ -17,6 +22,7 @@ public class Game {
    public Player player1;
    public boolean close;


    public Game(){
        this.turn = 0;
        this.mechanics = new ArrayList<>();
@ -27,11 +33,21 @@ public class Game {
        this.cars = CarGenerator.generateMany(14);
        this.player1 = new Player(10000000);
        this.close = false;
        StateManager.registerState(new Main(this));
        StateManager.registerState(new CarsForSale(this));
        StateManager.registerState(new MyCars(this));

        StateManager.changeState("Main");
    }

    public void update(){
        player1.printHeader();
        this.player1.printHeader();
        StateManager.update();
        
    }





}