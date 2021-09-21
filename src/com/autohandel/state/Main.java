package com.autohandel.state;
import com.autohandel.Game;
public class Main {
    public Main(Game currentGame) {
        super(currentGame);
        this.addMenuItem("View cars for sale", "1");
        this.addMenuItem("View cars in garage", "2");
        this.addMenuItem("View clients", "3");
        this.addMenuItem("View transaction history", "4");
        this.addMenuItem("Quit", "q");
    }

    @Override
    public void init(){

    }
    @Override
    public void update(){
        printMenu();
        String userData = this.getUserInput();
        switch (userData){
            case "1" :
                StateManager.changeState("CarsForSale");
                break;
            case "2" :
                StateManager.changeState("MyCars");
                break;
            case "q" :
                this.currentGame.close = true;
                break;
        }
    }

}

