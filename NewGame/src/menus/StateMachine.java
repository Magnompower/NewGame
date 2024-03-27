package menus;

import menus.inheritance.CheatMenu;
import menus.inheritance.CombatMenu;
import menus.inheritance.MainMenu;
import menus.inheritance.MovementMenu;
import ui.UI;

public class StateMachine {
    private GameState currentState;
    UI ui = new UI();

    public StateMachine() {
        this.currentState = GameState.MAIN_MENU;
    }

    public void changeState(GameState newState) {
        this.currentState = newState;
        switch (newState) {
            case MAIN_MENU:
                ui.printMainMenuHeader();
                ui.printMainMenuPoints();
                break;
            case MOVEMENT:
                ui.printMovementMenuHeader();
                ui.printMovementMenuPoints();
                break;
            case ENTER_COMBAT:
//                ui.printCombatMenuHeader();
//                ui.printCombatMenuPoints();
                break;
            case QUIT_GAME:
                ui.wantToQuitGame();
                break;
        }
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
