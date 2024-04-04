package classes;

import menus.MenuCreator;

public class Main {
    MenuCreator menuCreator = new MenuCreator();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        menuCreator.promptConfigureGameBeforeStart();
        menuCreator.executeProgram();

    }
}
