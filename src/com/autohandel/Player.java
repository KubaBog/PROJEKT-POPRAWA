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
