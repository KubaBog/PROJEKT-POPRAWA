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
    public int indexOfCar = -1;
    public int indexOfClient = -1;
    public int index3 = -1;
    public String dataStr = "";

    public void init(){}
    public void update(){}
@ -28,7 +28,7 @@ public class State {
        this.menuItems.clear();
        this.indexOfCar = -1;
        this.indexOfClient = -1;
        this.index3 = -1;
        this.dataStr = "";
    }


@ -51,45 +51,45 @@
    }

    public void printMenu(){
        for (int i=0;i<this.messages.size();i++){
            System.out.print("| " + messages.get(i) + " ".repeat(77 - messages.get(i).length())+" |\n");
        for (String message : this.messages) {
            System.out.print("| " + message + " ".repeat(77 - message.length()) + " |\n");
        }
        if (this.menuActions.size() == this.menuItems.size() && this.menuItems.size() > 0){
            for (int i=0;i<this.menuItems.size();i++){
                System.out.print("| "+ this.menuActions.get(i) + ". " + this.menuItems.get(i) + " ".repeat(76-(this.menuItems.get(i).length()+this.menuActions.get(i).length())) + "|\n");
            }
        }
        State.printBar();
    }

    public String getUserInput(){
        String s = "";
        System.out.print(" Choose option: ");
        boolean is_legal = false;
        while (s.length() <1 && !is_legal){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                s = reader.readLine();
                for (String character : menuActions){
                    if (s.toLowerCase().startsWith(character)){
                        is_legal = true;
                        break;
                    }
                }
                if (!is_legal){
                    System.out.println(" Wrong Input");
                    System.out.print(" Choose option: ");
                    s = "";
                }
            }catch (IOException e){
                System.out.print("Wrong Input");
                System.out.print(" Choose option: ");
                s = "";
            }

        }
        return s.toLowerCase();
    }

}
}
