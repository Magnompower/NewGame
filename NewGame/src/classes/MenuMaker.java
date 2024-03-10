package classes;

import java.util.Scanner;

public class MenuMaker {
    UI ui = new UI();
    Scanner playerChoice = new Scanner(System.in);
    Player player = new Player();
    MapFrame mapFrame = new MapFrame();

    private boolean gameRunning = true;

    Menu mainMenu = new Menu(promptMainMenuHeader(), promptMainMenuPoints());
    Menu combatMenu = new Menu(promptCombatMenuHeader(), promptCombatMenuPoints());
    Menu movementMenu = new Menu(promptMovementMenuHeader(), promptMovementMenuPoints());

    // ------------------ MENU'S ------------------

    public void executeMenu() {
        mainMenu.printMenu();
        int choice = playerChoice.nextInt(); // Capture user input
        ui.playerMessage1(player.getPlayerName());

        while (gameRunning) {
            switch (choice) {
                case 1: {
                    movementMenu();
                    break;
                }
                case 9:
                    showTutorial();
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

    void movementMenu() {
        movementMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.moveNorth();
            case 2 -> player.moveEast();
            case 3 -> player.moveSouth();
            case 4 -> player.moveWest();
            case 5 -> player.promptPrintPlayerPosition();

            case 9 -> player.promptAvailableInfo();
            case 0 -> {
                gameRunning = !ui.wantToQuitGame();
                if (!gameRunning) {
                    executeMenu();
                }
            }
            default -> ui.invalidInput();
        }
    }

    private void combatMenu() {
        combatMenu.printMenu();
        switch (playerChoice.nextInt()) {
            case 1 -> player.attack();
            case 2 -> player.flee();
            case 9 -> player.promptAvailableInfo();
            case 0 -> {
                if (ui.wantToQuitGame())
                    gameRunning = false;
                executeMenu();
            }
            default -> ui.invalidInput();

        }
    }

    // ------------------ OTHER ------------------

//    private void promptMakeMapVisible() {        mapFrame.makeMapVisible(ui.makeMapVisible());        mapFrame.setVisible(true);    }

//    private void promptMakeMapInvisible() {        mapFrame.makeMapVisible(ui.makeMapInvisible());    }

    private void showTutorial() {
        //TODO
    }

    public void promptWelcomeMessage() {
        ui.welcomeMessage();
    }

    public void promptSleepForOneAndAHalfSecond() {
        ui.sleepForOneSecond();
        ui.sleepForHalfASecond();
    }

    public String promptMainMenuHeader() {
        return ui.printMainMenuHeader();
    }

    private String[] promptMainMenuPoints() {
        return ui.mainMenuPoints();
    }

    public String promptMovementMenuHeader() {
        return ui.printMovementMenuHeader();
    }

    private String[] promptMovementMenuPoints() {
        return ui.movementMenuPoints();
    }

    public String promptCombatMenuHeader() {
        return ui.printCombatMenuHeader();
    }

    private String[] promptCombatMenuPoints() {
        return ui.combatMenuPoints(player.getEscapeChance());
    }

}