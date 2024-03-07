package classes;

import java.util.Scanner;

public class Menu {

    private String[] menuPoint;
    private String menuHeader;

    public Menu(String menuHeader, String[] menuPoint){
        this.menuPoint=menuPoint;
        this.menuHeader=menuHeader;
    }

    public Menu() {
    }

    public void printMenu(){
        String printString = menuHeader +"\n";
        for (int i = 0; i < menuPoint.length; i++) printString+= menuPoint[i] + "\n"; {
            System.out.println("\n" + printString);
        }
    }
}