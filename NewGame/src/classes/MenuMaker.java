package classes;

import java.util.Scanner;

public class MenuMaker {
    private UI ui = new UI();
    private Scanner scanner = new Scanner(System.in);
    Player player = new Player();
    private MapFrame mapFrame = MapFrame.getInstance();

    private boolean gameRunning = true;
    private int playerChoice;

    Menu mainMenu = new Menu(promptMainMenuHeader(), promptMainMenuPoints());
    Menu combatMenu = new Menu(promptCombatMenuHeader(), promptCombatMenuPoints());
    Menu movementMenu = new Menu(promptMovementMenuHeader(), promptMovementMenuPoints());

    // ------------------ MENU'S ------------------

    public void executeMainMenu() {
        mainMenu.printMenu();
        changePlayerChoice();
        while (gameRunning) {
            switch (playerChoice) { // TODO IF 0 AND N ÌNFINITE LOOP
                case 1 -> startGame();
                case 9 -> showTutorial(); //GOTO Start game after
                case 0 -> gameRunning = !ui.wantToQuitGame();

                case 33 -> movementMenu(); // TEST PURPOSE
                default -> ui.invalidInput();
            }
        }
    }

    private void mainMenu() {
        while (gameRunning) {
            mainMenu.printMenu();
            changePlayerChoice();
            switch (playerChoice) {
                case 1 -> startGame();
                case 9 -> showTutorial(); //GOTO Start game after
                case 0 -> gameRunning = !ui.wantToQuitGame();
                default -> ui.invalidInput();
            }

        }
    }

    private void movementMenu() {
        while (gameRunning) {
            movementMenu.printMenu();
            changePlayerChoice();
            switch (playerChoice) {
                case 2 -> player.moveSouth();
                case 4 -> player.moveWest();
                case 5 -> player.promptPrintPlayerPosition();
                case 8 -> player.moveNorth();
                case 6 -> player.moveEast();



                case 9 -> player.promptAvailableInfo();
                case 0 -> gameRunning = !ui.wantToQuitGame();
                default -> ui.invalidInput();
            }
//            checkForEncounter();TODO
        }

    }

    private void combatMenu() {
        while (gameRunning) {
            combatMenu.printMenu();
            changePlayerChoice();
            switch (playerChoice) {
                case 1 -> player.attack();
                case 2 -> player.flee();

                case 9 -> player.promptAvailableInfo();
                case 0 -> gameRunning = ui.wantToQuitGame();
                default -> ui.invalidInput();
            }
        }
    }

    // ------------------ PROMPTS ------------------

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

    // ------------------ OTHER ------------------

    private void startGame() {
        ui.playerMessage1(player.getPlayerName());
        player.promptMakeMapVisible();
        movementMenu();
    }

    public void changePlayerChoice() {
        playerChoice = scanner.nextInt();
    }

    private void showTutorial() {
        //TODO
    }
}