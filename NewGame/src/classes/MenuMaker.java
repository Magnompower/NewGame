package classes;

import java.util.Scanner;

public class MenuMaker {
    private int calculatedChanceToEscape;
    Scanner playerChoice = new Scanner(System.in);
    Player player = new Player();
    UI ui = new UI();
    private boolean gameRunning = true;
    Weapon weapon;
//    MapFrame mapFrame = new MapFrame();// KÆMPE PROBLEM TODO


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
            case 0 -> {
                gameRunning = false;
                executeMenu();
            }
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
            case 1 -> ui.attack();
            case 2 -> player.flee();

            case 9 -> ui.getAvailableInfo();
            case 0 -> {
                if (ui.quitGame())
                    gameRunning = false;
                executeMenu();
            }
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
            case 5 -> ui.printPlayerPosition();

            case 9 -> ui.getAvailableInfo();
            case 0 -> {
                gameRunning = !ui.quitGame();
                if (!gameRunning) {
                    executeMenu();
                }
            }
            default -> ui.invalidInput();
        }
    }

    public void promtWelcomeMessage() {
        ui.welcomeMessage();
    }

    public void executeMenu() {
        sleepForOneAndAHalfSecond();
        while (gameRunning) {
            mainMenu.printMenu();

            int choice = playerChoice.nextInt(); // Capture user input
            switch (choice) {
                case 1:{ ui.playerMessage1();
                    movementMenu(); // Call the appropriate method based on user input
                    break;} // Ensure execution stops after this case
                case 9:
                    showTutorial();
                    break;
                case 0:
                    gameRunning = !ui.quitGame(); // Assuming quitGame() now returns boolean indicating if game should continue
                    break;
                default:
                    ui.invalidInput();
                    break;
            }

            if (!gameRunning) {
                ui.printTimePlayed(); // Optionally, only print if the game is still running
            }
        }
    }

    private void sleepForOneAndAHalfSecond() {
        ui.sleepForOneSecond();
        ui.sleepForHalfASecond();
    }

}