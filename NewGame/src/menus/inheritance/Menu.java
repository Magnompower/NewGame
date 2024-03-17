package menus.inheritance;

import ui.UI;

public abstract class Menu {

    UI ui = new UI();
    private final String[] menuPoints;
    private final String menuHeader;

    public Menu(UI ui, String menuHeader, String[] menuPoints) { // TODO Behøver man UI alle steder?
        this.menuHeader = menuHeader;
        this.menuPoints = menuPoints;
    }

    public void promptPrintMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuPoints.length; i++) printString += menuPoints[i] + "\n";
        {
            ui.printMenu(printString);
        }
    }

    public String returnUserInput() {
        return ui.getSpecificStringInput();
    }

    public String changeUserInput() {
        return ui.getSpecificStringInput();
    }
}