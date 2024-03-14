package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

import java.util.Scanner;

public class MovementMenu extends Menu {

    public MovementMenu(UI ui, Player player, MapFrame mapFrame) {
        super(ui, player, mapFrame, ui.printMovementMenuHeader(), ui.printMovementMenuPoints());
    }//

    @Override
    public void handleUserInput(int userInput) {
        switch (userInput) {
            case 2 -> player.moveSouth();
            case 4 -> player.moveWest();
            case 5 -> player.promptPrintPlayerPosition();
            case 8 -> player.moveNorth();
            case 6 -> player.moveEast();


            case 9 -> player.promptAvailableInfo();
            default -> ui.invalidInput();
        }
//            checkForEncounter();TODO
    }
}