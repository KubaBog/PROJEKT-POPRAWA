package com.autohandel.vehicles;

public class CarModel {
    public String modelName;
    public CarPart breaks;
    public CarPart suspension;
@ -8,4 +10,25 @@ public class CarModel {
    public CarPart body;
    public CarPart gearbox;
    public int internalVolume;
    public CarModel(String modelName, CarPart breaks, CarPart suspension, CarPart engine, CarPart body, CarPart gearbox) {
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
}
