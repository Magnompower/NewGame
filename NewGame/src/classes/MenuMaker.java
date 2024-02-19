package classes;

import java.util.Scanner;

public class MenuMaker {
    private int calculatedChanceToEscape;
    Scanner playerChoice = new Scanner(System.in);
    Player player = new Player();
    UI ui = new UI();
    MapFrame mapFrame = new MapFrame();// KÆMPE PROBLEM TODO

    Boolean gameRunning = true;


    Menu mainMenu = new Menu("MAIN MENU", startMenuPoints());
    Menu combatMenu = new Menu("COMBAT MENU", combatMenuPoints());
    Menu movementMenu = new Menu("MOVEMENT MENU", movementMenuPoints());

    private String[] movementMenuPoints() {
        return new String[]{"1. Move north.", "2. Move east.", "3. Move south.","4. Move west.","5. See player position",
                "9. Show available information.", "0. Quit."};
    }

    private String[] combatMenuPoints() {
        return new String[]{"1. Attack.", "2. Attempt to flee. (" + calculatedChanceToEscape + ")",
                "9. Show available information.", "0. Rage quit."};
    }

    private String[] startMenuPoints() {
        return new String[]{"1. Start game.", "9. Show tutorial","0. Quit game"};
    }


    private void mainMenu() {
        mainMenu.printMenu();
        switch (playerChoice.nextInt()){
            case 1 -> movementMenu();
            case 9 -> showTutorial();
            case 0 -> ui.quitGame();
        }
        // TODO
    }

    private void showTutorial() {
        //TODO
    }

    private void combatMenu() {
        combatMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.attack();
            case 2 -> player.flee();

            case 9 -> ui.getAvailableInfo();
            case 0 -> ui.quitGame();
        }
    }

    void movementMenu() {
        movementMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.moveNorth();
            case 2 -> player.moveEast();
            case 3 -> player.moveSouth();
            case 4 -> player.moveWest();
            case 5 -> player.printPlayerPosition();

            case 9 -> ui.getAvailableInfo();
            case 0 -> ui.quitGame();
        }
    }

    void quitGame() {
       gameRunning = ui.quitGame();
       //        else menu.movementMenu();
    }

    public void promtWelcomeMessage() {
        ui.welcomeMessage();
    }

    public void executeMenu() {
        ui.sleepForOneSecond();
        ui.sleepForOneSecond();
        do {
            mainMenu();
        } while (gameRunning=false);
    }

    //        mapFrame.makeMapVisible = true; // Virker ikke
//        mapFrame.setMapVisibillity(makeMapVisible); // opens map

}
