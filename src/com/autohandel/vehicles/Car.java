package com.autohandel.vehicles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Car {
    public enum Ownership {
        NoOne, Player, Client;
        NoOne, Player, Client
    }


@ -32,6 +32,10 @@ public class Car extends Vehicle{
                "\n}";
    }

    public String getFullName(){
        return (this.model.brandName + " " + this.model.modelName);
    }

    public String getValueAsString(){
        return String.format("%.2f",(float)(this.value/100));
    }
}
