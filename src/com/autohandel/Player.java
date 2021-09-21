package com.autohandel;
import com.autohandel.vehicles.Car;

import java.util.ArrayList;
import java.util.List;
public class Player {
    public List<Car> myCars;
    public int balance;
    public List<String> historyOfTransactions;
    public int move;


    public Player(int balance) {
        this.myCars = new ArrayList<>();
        this.balance = balance;
        this.historyOfTransactions = new ArrayList<>();
        this.move = 0;
    }


    public void printHeader(){
        String balance_str = String.valueOf(this.balance);
        String carSize_str = String.valueOf(this.myCars.size());
@ -33,7 +34,6 @@ public class Player {
            System.out.print(' ');
        System.out.print("|\n");
        System.out.println("|-------------------------------------------------------------------------------|");

    }

}
}