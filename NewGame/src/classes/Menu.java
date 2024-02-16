package classes;

import java.util.Scanner;

public class Menu {
    Player player = new Player();
    UI ui = new UI();
    Scanner playerChoice = new Scanner(System.in);
    String[] menuString;

    private void startMenu() {
    }

    private void combatMenu() {
        switch (playerChoice.nextInt()) {
            case 1 -> player.attack();
            case 2 -> player.flee();

            case 0 -> ui.quitGame();
        }
    }

    private void movementMenu() {
        switch (playerChoice.nextInt()) {
            case 1 -> player.moveNorth();
            case 2 -> player.moveEast();
            case 3 -> player.moveSouth();
            case 4 -> player.moveWest();

            case 9 -> ui.getInfo();
            case 0 -> ui.quitGame();
        }
    }
}
