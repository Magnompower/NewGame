package menus.inheritance;

import ui.UI;

public class MovementMenu extends Menu {

    public MovementMenu(UI ui) {
        super(ui, ui.printMovementMenuHeader(), ui.printMovementMenuPoints());
    }

    @Override
    public String returnUserInput() {
        String userInput = changeUserInput().toUpperCase();
        return switch (userInput) {
            case "W", "8" -> "Move north";
            case "A", "4" -> "Move west";
            case "S", "2" -> "Move south";
            case "D", "6" -> "Move east";
            case "5" -> "Show player position";
            case "9" -> "Show available information";
            case "33" -> "Go to cheat menu";
            default -> null;
        };
    }
}