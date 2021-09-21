package com.autohandel.state;
import com.autohandel.Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class State {
    ublic Game currentGame;
    public String name;
    public List<String> menuItems = new ArrayList<>();
    public List<String> menuActions = new ArrayList<>();
    public void init(){}
    public void update(){}

    public State(Game currentGame){
        this.currentGame = currentGame;
        this.name = this.getClass().getSimpleName();
    }

    public void addMenuItem(String item, String action){
        this.menuItems.add(item);
        this.menuActions.add(action);
    }

    public static void printBar(){
        System.out.println("|-------------------------------------------------------------------------------|");
    }

    public void printMenu(){
        if (this.menuActions.size() == this.menuItems.size() && this.menuItems.size() > 0){
            for (int i=0;i<this.menuItems.size();i++){
                System.out.print("| "+ this.menuActions.get(i) + ". " + this.menuItems.get(i));
                for (int a=0;a<76-(this.menuItems.get(i).length()+this.menuActions.get(i).length());a++)
                    System.out.print(' ');
                System.out.print("|\n");
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
