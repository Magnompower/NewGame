package menus.inheritance;

import classes.Player;
import ui.UI;

public class CombatMenu extends Menu {

    public CombatMenu(UI ui, Player player) {
        super(ui, ui.printCombatMenuHeader(), ui.printCombatMenuPoints(player.getEscapeChance()));
    }

    @Override
    public String returnUserInput() {
        String userInput = changeUserInput();
        return switch (userInput) {
            case "1" -> "Attack";
            case "2" -> "Attempt to flee";
            case "9" -> "Show available information";
            case "0" -> "Want to quit?";
            case "33" -> "Go to cheat menu";
            default -> null;
        };
    }
}