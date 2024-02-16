package classes;

import java.util.Scanner;

public class MenuMaker {
    private int calculatedChanceToEscape;
    Scanner playerChoice = new Scanner(System.in);
    Player player;
    UI ui = new UI();
    MapFrame mapFrame = new MapFrame();// KÆMPE PROBLEM TODO

    Menu mainMenu = new Menu("MAIN MENU", startMenuPoints());
    Menu combatMenu = new Menu("COMBAT MENU", combatMenuPoints());
    Menu movementMenu = new Menu("MOVEMENT MENU", movementMenuPoints());

    private String[] movementMenuPoints() {
        return new String[]{"1. Move north.", "2. Move east.", "3. Move south." + "4. Move west." +
                "9. Show available information.", "0. Quit."};
    }

    private String[] combatMenuPoints() {
        return new String[]{"1. Attack.", "2. Attempt to flee. (" + calculatedChanceToEscape + ")",
                "9. Show available information.", "0. Rage quit."};
    }

    private String[] startMenuPoints() {
        return new String[]{"1. XX"};
    }


    private void mainMenu() {
        // TODO
    }

    private void combatMenu() {
        switch (playerChoice.nextInt()) {
            case 1 -> player.attack();
            case 2 -> player.flee();

            case 9 -> ui.getAvailableInfo();
            case 0 -> ui.quitGame();
        }
    }

    void movementMenu() {
        switch (playerChoice.nextInt()) {
            case 1 -> mapFrame.moveNorth();
            case 2 -> mapFrame.moveEast();
            case 3 -> mapFrame.moveSouth();
            case 4 -> mapFrame.moveWest();

            case 9 -> ui.getAvailableInfo();
            case 0 -> ui.quitGame();
        }
    }
}
