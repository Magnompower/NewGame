package classes;

import weapons.Weapon;

import java.util.Scanner;

public class MenuMaker {
    Scanner playerChoice = new Scanner(System.in);
    Player player = new Player();
    UI ui = new UI();
    private boolean gameRunning = true;
    Weapon weapon;
//    MapFrame mapFrame = new MapFrame();// KÆMPE PROBLEM TODO

    Menu mainMenu = new Menu("MAIN MENU", promptMainMenuPoints());
    Menu combatMenu = new Menu("COMBAT MENU", promptCombatMenuPoints());
    Menu movementMenu = new Menu("MOVEMENT MENU", promptMovementMenuPoints());

    // ------------------ MENU'S ------------------

    public void executeMenu() {
        promptSleepForOneAndAHalfSecond();
        mainMenu.printMenu();
        while (gameRunning) {
            int choice = playerChoice.nextInt(); // Capture user input
            switch (choice) {
                case 1: {
                    ui.playerMessage1();
                    movementMenu();
                    break;
                }
                case 9:
                    showTutorial();
                    ui.playerMessage1();
                    movementMenu();
                    break;
                case 0:
                    gameRunning = !ui.wantToQuitGame();
                    break;
                default:
                    ui.invalidInput();
                    break;
            }
            if (!gameRunning) {
                ui.printTimePlayed();
            }
        }
    }

    private void mainMenu() {
        mainMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> movementMenu();
            case 9 -> showTutorial();
            case 0 -> {
                gameRunning = false;
                executeMenu();
            }
            default -> ui.invalidInput();
        }
        // TODO
    }

    private String[] promptMainMenuPoints() {
        return ui.mainMenuPoints();
    }

    void movementMenu() {
        movementMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.moveNorth();
            case 2 -> player.moveEast();
            case 3 -> player.moveSouth();
            case 4 -> player.moveWest();
            case 5 -> player.printPlayerPosition();

            case 9 -> player.getAvailableInfo();
            case 0 -> {
                gameRunning = !ui.wantToQuitGame();
                if (!gameRunning) {
                    executeMenu();
                }
            }
            default -> ui.invalidInput();
        }
    }

    private String[] promptMovementMenuPoints() {
        return ui.movementMenuPoints();
    }

    private void combatMenu() {
        combatMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.attack();
            case 2 -> player.flee();

            case 9 -> player.getAvailableInfo();
            case 0 -> {
                if (ui.wantToQuitGame())
                    gameRunning = false;
                executeMenu();
            }
            default -> ui.invalidInput();

        }
    }

    private String[] promptCombatMenuPoints() {
        return ui.combatMenuPoints();
    }

    // ------------------ OTHER ------------------


    private void showTutorial() {
        //TODO
    }

    public void promptWelcomeMessage() {
        ui.welcomeMessage();
    }

    private void promptSleepForOneAndAHalfSecond() {
        ui.sleepForOneSecond();
        ui.sleepForHalfASecond();
    }

}