package menus.inheritance;

import ui.UI;

public class MainMenu extends Menu /*implements GameState*/ {

    public MainMenu(UI ui) {
        super(ui, ui.printMainMenuHeader(), ui.printMainMenuPoints());
    }

    @Override
    public String returnUserInput() {
        String userInput = changeUserInput();
        return switch (userInput) {
            case "1" -> "Start game";
            case "9" -> "Show tutorial";
            case "0" -> "Want to quit?";
            case "33" -> "Go to cheat menu";
            default -> null;
        };
    }
/*
    @Override
    public void enter() {
        ui.menu

    }

    @Override
    public void exit() {
        GameEvent.QUIT_GAME;
    }

    @Override
    public void handleEvent(GameEvent event) {
        switch (event) {
            case START_GAME -> GameStateMachine.changeState(new MovementState());
        }
    }*/
}