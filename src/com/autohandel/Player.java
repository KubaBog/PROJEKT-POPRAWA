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
        String move_str = String.valueOf(this.move);


        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.print("| Balance: ");
        System.out.printf("%.2f", (double)this.balance/100);
        System.out.print("    MyCarsCount: " + carSize_str+"    Moves: " + move_str);
        for (int i=0;i<(40-balance_str.length() - carSize_str.length()-move_str.length());i++)
            System.out.print(' ');
        System.out.print("|\n");
        System.out.println("|-------------------------------------------------------------------------------|");

    }

}
