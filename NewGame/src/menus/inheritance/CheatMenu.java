package menus.inheritance;

import ui.UI;

public class CheatMenu extends Menu {

    public CheatMenu(UI ui) {
        super(ui, ui.printCheatMenuHeader(), ui.printCheatMenuPoints());
    }

    @Override
    public String returnUserInput() {
        String userInput = changeUserInput().toUpperCase();
        return switch (userInput) {
            case "W" -> "Move north";
            case "A" -> "Move west";
            case "S" -> "Move south";
            case "D" -> "Move east";
            case "1" -> "Make map visible";
            case "2" -> "Make map invisible";
            case "3" -> "Grant weapon";
            case "4" -> "Grant armor";
            case "5" -> "Change attributes";
            case "6" -> "Sharpen weapon";
            case "7" -> "Repair armor";
            case "8" -> "Show all map locations";
            case "9" -> "Show Available information";
            case "0" -> "Want to quit?";
            case "33" -> "Go to previous menu";
            default -> null;
        };
    }
}