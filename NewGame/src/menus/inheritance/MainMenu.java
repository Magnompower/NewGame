package menus.inheritance;

import ui.UI;

public class MainMenu extends Menu {
    private boolean validInput;

    public MainMenu(UI ui) {
        super(ui, ui.printMainMenuHeader(), ui.printMainMenuPoints());
    }

    @Override
    public String returnUserInput() { // TODO
        while (!validInput) {
            int userInputInt = changeUserIntInput();
            if (userInputInt != 1 || userInputInt != 9 || userInputInt != 0 || userInputInt != 33) {
                validInput = true;
                return switch (userInputInt) {
                    case 1 -> "Start game";
                    case 9 -> "Show tutorial";
                    case 0 -> "Want to quit?";
                    case 33 -> "Go to cheat menu";
                    default -> null; // TODO Default needed?
                };
            } else ui.printInvalidInput();
        }
        return null;
    }

}