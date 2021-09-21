package com.autohandel;

import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.people.Mechanic;
import com.autohandel.state.*;
import com.autohandel.state.Main;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public int turn;
    public List<Car> cars;
    public List<Client> clients;
    public List<Mechanic> mechanics;
    public Player player1;
    public boolean close;


    public Game(){
        this.turn = 0;
        this.mechanics = new ArrayList<>();
        this.mechanics.add( new Mechanic("Janusz","Kowalski",1.0,1.0,0.0));
        this.mechanics.add( new Mechanic("Marian","Kowalski",0.7,0.9,0.0));
        this.mechanics.add( new Mechanic("Adrian","Kowalski",0.5,0.8,0.02));
        this.clients = ClientGenerator.generateMany(4);
        this.cars = CarGenerator.generateMany(10);
        this.player1 = new Player(10000000);
        this.close = false;
        StateManager.registerState(new Main(this));
        StateManager.registerState(new CarsForSale(this));
        StateManager.registerState(new MyCars(this));
        StateManager.registerState(new CarData(this));
        StateManager.registerState(new Clients(this));
        StateManager.registerState(new Transactions(this));
        StateManager.registerState(new HistoryOfRepair(this));
        StateManager.registerState(new Selling(this));
        StateManager.registerState(new Repair(this));
        StateManager.registerState(new Ads(this));

        StateManager.changeState("Main");
    }

    public void update(){
        if (this.player1.balance > 20000000 ){
            System.out.println("\n\n\n\n    YOU WON IN " + this.player1.move + " MOVES\n\n");
            System.out.println("\n\n\n\n    YOU WON IN " + this.player1.move + " MOVES\n\n\n\n");
            this.close = true;
            return;
        }
        this.player1.printHeader();
        StateManager.update();
        //TODO
    }



}