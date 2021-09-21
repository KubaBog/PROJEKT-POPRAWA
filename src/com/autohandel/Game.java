package com.autohandel;

import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.people.Mechanic;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
@ -14,15 +15,18 @@ public class Game {
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
        this.clients = ClientGenerator.generateMany(6);
        this.cars = CarGenerator.generateMany(14);
        this.player1 = new Player(10000000);
        this.close = false;
    }

    public void update(){