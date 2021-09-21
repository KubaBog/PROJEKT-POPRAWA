package com.autohandel;

import com.autohandel.people.Client;
import com.autohandel.people.ClientGenerator;
import com.autohandel.vehicles.Car;
import com.autohandel.vehicles.CarGenerator;

public class Main {
    public int turn =0;
    public static void main(String[] args) {

        System.out.println(CarGenerator.generateMany(10));

        System.out.println(ClientGenerator.generateMany(10));

    }
    }