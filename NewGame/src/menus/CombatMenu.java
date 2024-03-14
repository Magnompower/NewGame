package menus;

import classes.MapFrame;
import classes.Player;
import classes.UI;

public class CombatMenu extends Menu {


    public CombatMenu(UI ui, Player player, MapFrame mapFrame) {
        super(ui, player, mapFrame, ui.printCombatMenuHeader(), ui.printCombatMenuPoints(player.getEscapeChance()));
    }

    @Override
    public void handleUserInput(int userInput) {
        switch (userInput) {
            case 1 -> player.attack();
            case 2 -> player.flee();

            case 9 -> player.promptAvailableInfo();
            default -> ui.invalidInput();
        }
    }
}

