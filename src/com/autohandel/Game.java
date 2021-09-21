package com.autohandel;

import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.people.Mechanic;
import com.autohandel.state.CarsForSale;
import com.autohandel.state.*;
import com.autohandel.state.Main;
import com.autohandel.state.MyCars;
import com.autohandel.state.StateManager;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

@ -36,7 +34,7 @@ public class Game {
        StateManager.registerState(new Main(this));
        StateManager.registerState(new CarsForSale(this));
        StateManager.registerState(new MyCars(this));

        StateManager.registerState(new CarData(this));
        StateManager.changeState("Main");
    }