package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

public class MainMenu extends Menu {

    MenuActions menuActions;

    public MainMenu(UI ui, Player player, MapFrame mapFrame) {
        super(ui, player, mapFrame, ui.printMainMenuHeader(), ui.printMainMenuPoints());
    }

    @Override
    public void handleUserInput(int userInput) {
        switch (userInput) {
//            case 1 -> menuActions.startGame();
            case 9 -> menuActions.showTutorial(); //GOTO Start game after
            default -> ui.invalidInput();
        }

    }
}