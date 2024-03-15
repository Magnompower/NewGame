package menus.inheritance;

import ui.UI;

import java.util.Scanner;

public abstract class Menu {

    private final String[] menuPoints;
    private final String menuHeader;

    public Menu(UI ui, String menuHeader, String[] menuPoints) { // TODO Behøver man UI alle steder?
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

    public String returnUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String changeUserInput() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }
}