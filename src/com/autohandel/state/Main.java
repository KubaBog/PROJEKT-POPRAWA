package com.autohandel.state;

import com.autohandel.Game;

public class Main extends State{
    public Main(Game currentGame) {
        super(currentGame);

    }

    @Override
    public void init(){
        this.addMenuItem("View cars for sale", "1");
        this.addMenuItem("View cars in garage", "2");
        this.addMenuItem("View clients", "3");
        this.addMenuItem("View transaction history", "4");
        this.addMenuItem("Buy Ads", "5");
        this.addMenuItem("Quit", "q");
    }
    @Override
@ -33,11 +34,14 @@
            case "4" :
                StateManager.changeState("Transactions");
                break;
            case "5" :
                StateManager.changeState("Ads");
                break;
            case "q" :
                this.currentGame.close = true;
                break;
        }
    }

}

