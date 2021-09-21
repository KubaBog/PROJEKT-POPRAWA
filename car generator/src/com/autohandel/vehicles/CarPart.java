package com.autohandel.vehicles;

public class CarPart {
    public String name;
    public double priceUp;
    public double costOfRepair;
    public double priceUpPercentage;
    public int costOfRepair;

    public CarPart(String name, double priceUpPercentage, int costOfRepair) {
        this.name = name;
        this.priceUpPercentage = priceUpPercentage;
        this.costOfRepair = costOfRepair;
    }

    @Override
    public String toString() {
        return "CarPart{ " +
                "name='" + name + '\'' +
                ", priceUpPercentage=" + priceUpPercentage +
                ", costOfRepair=" + costOfRepair +
                " }";
    }
}

