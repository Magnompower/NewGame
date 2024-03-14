package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

public abstract class Menu {

    protected UI ui;
    protected Player player;
    protected MapFrame mapFrame;
    private String[] menuPoints;
    private String menuHeader;

    public Menu(UI ui, Player player, MapFrame mapFrame,String menuHeader, String[] menuPoints) {
        this.ui = ui;
        this.player = player;
        this.mapFrame = mapFrame;
        this.menuHeader = menuHeader;
        this.menuPoints = menuPoints;
    }

    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuPoints.length; i++) printString += menuPoints[i] + "\n";
        {
            System.out.println("\n" + printString);
        }
    }

    public abstract void handleUserInput(int UserChoice);
}