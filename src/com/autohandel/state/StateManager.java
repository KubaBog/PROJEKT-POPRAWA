package com.autohandel.state;
import java.util.ArrayList;
import java.util.List;
public class StateManager {
    public static List<State> states = new ArrayList<>();
    public static int current = -1;

    public static void registerState(State state){
        states.add(state);
    }

    public static void update(){
        if (current >= 0)
            states.get(current).update();
    }

    public static void changeState(String stateName){
        for (State state : states){
            if (stateName.equals(state.name)){
                current = states.indexOf(state);
                state.init();
                return;
            }
        }
    }
 
}
