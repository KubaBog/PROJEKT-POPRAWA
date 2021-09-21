+package com.autohandel.state;

import com.autohandel.Game;
import com.autohandel.people.ClientGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Ads extends State{
    public Ads(Game currentGame) {
        super(currentGame);
    }

    @Override
    public void init(){
        addMessage("Buy Ads");
        addMenuItem("Paper 100PLN","0");
        addMenuItem("Internet 10PLN","1");
        this.addMenuItem("Back", "q");

    }

    @Override
    public void update() {
        printMenu();
        String userData = this.getUserInput();
        switch (userData) {
            case "q":
                StateManager.changeState("Main");
                break;
            case "0":
                this.currentGame.player1.balance -= 10000;
                this.currentGame.player1.move +=1;
                this.currentGame.player1.historyOfTransactions.add("Bought paper ads for 100PLN");
                int random = ThreadLocalRandom.current().nextInt(1, 6);
                for (int i = 0; i < random; i++)
                    this.currentGame.clients.add(ClientGenerator.generate());
                StateManager.changeState("Main");
                break;
            case "1":
                this.currentGame.player1.balance -= 1000;
                this.currentGame.player1.move +=1;
                this.currentGame.player1.historyOfTransactions.add("Bought internet ads for 10PLN");
                this.currentGame.clients.add(ClientGenerator.generate());
                StateManager.changeState("Main");
                break;
        }



    }

}
