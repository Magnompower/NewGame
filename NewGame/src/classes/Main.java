package classes;

import menus.MenuCreator;
import menus.StateMachine;

public class Main {
    StateMachine stateMachine = new StateMachine(); // TODO ??
    MenuCreator menuCreator = new MenuCreator(stateMachine);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        menuCreator.executeMainMenu();

    }
}
