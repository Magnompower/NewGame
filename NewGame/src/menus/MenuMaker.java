package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

import java.util.Scanner;

public class MenuMaker implements MenuActions {

    MenuActions menuActions;

    private final Scanner scanner = new Scanner(System.in);
    private boolean gameRunning = true;
    private int playerChoice;
    private Menu currentMenu;
    private UI ui = new UI();
    private Player player = new Player();
    private MapFrame mapFrame = MapFrame.getInstance();

    public MenuMaker(UI ui, Player player, MapFrame mapFrame) {
        this.ui = ui;
        this.player = player;
        this.mapFrame = mapFrame;
        this.currentMenu = new MainMenu(ui, player, mapFrame);
    }

// ------------------ MENU ------------------

    public void executeMenus() {
        while (gameRunning) {
            currentMenu.printMenu();
            currentMenu.handleUserInput(changePlayerChoice());
            if (playerChoice==1){
                startGame();
            }
            if (playerChoice == 0) {
                gameRunning = !ui.wantToQuitGame();
            }
            if (playerChoice == 33) {
                currentMenu = new CheatMenu(ui, player, mapFrame);
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


    // ------------------ OTHER ------------------

    public void startGame() {
//        ui.playerMessage1(player.getPlayerName()); // TESTING
        player.promptMakeMapVisible();
        currentMenu = new MovementMenu(ui, player, mapFrame);
    }

    public void showTutorial() {
        // ui.show rules
        //TODO
    }

    public int changePlayerChoice() {
        playerChoice = scanner.nextInt();
        return playerChoice; //TODO IMPLEMENT FAIL LOGIC
    }
}