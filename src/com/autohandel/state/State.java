package com.autohandel.state;
import com.autohandel.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class State {
    public Game currentGame;
    public String name;
    public String lastState = null;
    public List<String> messages = new ArrayList<>();
    public List<String> menuItems = new ArrayList<>();
    public List<String> menuActions = new ArrayList<>();
    public int index1 = -1;
    public int index2 = -1;
    public int index3 = -1;

    public void init(){}
    public void update(){}

@ -27,17 +33,21 @@ public class State {
        this.menuActions.add(action);
    }

    public void addMessage(String message){
        this.messages.add(message);
    }

    public static void printBar(){
        System.out.println("|-------------------------------------------------------------------------------|");
    }

    public void printMenu(){
        for (int i=0;i<this.messages.size();i++){
            System.out.print("| " + messages.get(i) + " ".repeat(77 - messages.get(i).length())+" |\n");
        }
        if (this.menuActions.size() == this.menuItems.size() && this.menuItems.size() > 0){
            for (int i=0;i<this.menuItems.size();i++){
                System.out.print("| "+ this.menuActions.get(i) + ". " + this.menuItems.get(i));
                for (int a=0;a<76-(this.menuItems.get(i).length()+this.menuActions.get(i).length());a++)
                    System.out.print(' ');
                System.out.print("|\n");
                System.out.print("| "+ this.menuActions.get(i) + ". " + this.menuItems.get(i) + " ".repeat(76-(this.menuItems.get(i).length()+this.menuActions.get(i).length())) + "|\n");
            }
        }
        State.printBar();
}
