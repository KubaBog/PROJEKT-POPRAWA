package com.autohandel.vehicles;

public class CarModel {
    public String brandName;
    public String modelName;
    public CarPart breaks;
    public CarPart suspension;
@ -10,26 +10,27 @@
    public CarPart body;
    public CarPart gearbox;
    public int internalVolume;
    public CarModel(String modelName, CarPart breaks, CarPart suspension, CarPart engine, CarPart body, CarPart gearbox) {
    public CarModel(String brandName,String modelName, CarPart breaks, CarPart suspension, CarPart engine, CarPart body, CarPart gearbox) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.breaks = breaks;
        this.suspension = suspension;
        this.engine = engine;
        this.body = body;
        this.gearbox = gearbox;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "\n        modelName= '" + modelName + '\'' +
                ",\n        breaks= " + breaks +
                ",\n        suspension= " + suspension +
                ",\n        engine= " + engine +
                ",\n        body= " + body +
                ",\n        gearbox= " + gearbox +
                ",\n        internalVolume= " + internalVolume +
                "\n     }";
    }
}
