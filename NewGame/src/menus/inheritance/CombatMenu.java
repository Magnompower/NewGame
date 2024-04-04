package menus.inheritance;

import classes.Player;
import enemies.inheritance.Enemy;
import ui.UI;

public class CombatMenu extends Menu {

    public CombatMenu(UI ui, Player player, Enemy enemy) {
        super(ui, ui.printCombatMenuHeader(player.getPlayerName(), enemy.getEnemyName()), ui.printCombatMenuPoints(player.getEscapeChancePercentage()));
    }

    @Override
    public String returnUserInput() {
        int userInput = changeUserIntInput();
        return switch (userInput) {
            case 1 -> "Attack";
            case 2 -> "Attempt to flee";
            case 9 -> "Show available information";
            case 0 -> "Want to quit?";
            case 33 -> "Go to cheat menu";
            default -> null;
        };
    }
}