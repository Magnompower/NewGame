package classes;

import java.util.Scanner;

public class MenuMaker {
    private int calculatedChanceToEscape;
    Scanner playerChoice = new Scanner(System.in);
    Player player = new Player();
    UI ui = new UI();
    MapFrame mapFrame = new MapFrame();// KÆMPE PROBLEM TODO


    Menu mainMenu = new Menu("MAIN MENU", startMenuPoints());
    Menu combatMenu = new Menu("COMBAT MENU", combatMenuPoints());
    Menu movementMenu = new Menu("MOVEMENT MENU", movementMenuPoints());

    private String[] movementMenuPoints() {
        return new String[]{"1. Move north.", "2. Move east.", "3. Move south.", "4. Move west.", "5. See player position",
                "9. Show available information.", "0. Quit."};
    }

    private String[] combatMenuPoints() {
        return new String[]{"1. Attack.", "2. Attempt to flee. (" + calculatedChanceToEscape + ")",
                "9. Show available information.", "0. Rage quit."};
    }

    private String[] startMenuPoints() {
        return new String[]{"1. Start game.", "9. Show tutorial", "0. Quit game"};
    }


    private void mainMenu() {
        mainMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> movementMenu();
            case 9 -> showTutorial();
            case 0 -> ui.quitGame();
            default -> ui.invalidInput();
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
            default -> ui.invalidInput();

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
            default -> ui.invalidInput();

        }
    }

    public void promtWelcomeMessage() {
        ui.welcomeMessage();
    }

    public void executeMenu() {
        ui.sleepForOneSecond();
        ui.sleepForOneSecond();
        mainMenu.printMenu();
        int playerChoiceSaved;
        do {
            playerChoiceSaved = playerChoice.nextInt(); // Read the input once
            switch (playerChoiceSaved) {
                case 1:
                    movementMenu(); // Call the appropriate method based on user input
                    break;
                case 9:
                    showTutorial();
                    break;
                case 0:
                    ui.quitGame();
                    break;
                default:
                    ui.invalidInput();
                    break;
            }
        } while (playerChoiceSaved != 0); // Continue until the player chooses to quit

        //        mapFrame.makeMapVisible = true; // Virker ikke
//        mapFrame.setMapVisibillity(makeMapVisible); // opens map

    }
}
