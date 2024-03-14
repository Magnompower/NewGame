package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

public class CheatMenu extends Menu {

    public CheatMenu(UI ui, Player player, MapFrame mapFrame) {
        super(ui, player, mapFrame, ui.printCheatMenuHeader(), ui.printCheatMenuPoints());
    }

    @Override
    public void handleUserInput(int userInput) {
        switch (userInput) {
            case 1 -> mapFrame.makeMapVisible();
            case 2 -> mapFrame.makeMapInvisible();

            case 9 -> player.promptAvailableInfo();
//            case 33 -> movementMenu;
            default -> ui.invalidInput(); //TODO HANDLE INVALIDUSERINPUT IN MENUMAKER
        }
    }
}
