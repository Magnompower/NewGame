package menus;

import armor.ArmorCreator;
import armor.ArmorCondition;
import weapons.WeaponCondition;
import map_logic.MapFrame;
import classes.Player;
import ui.UI;
import enemies.EnemyCreator;
import menus.inheritance.*;
import weapons.WeaponCreator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;

public class MenuCreator {

    private UI ui = new UI(); // TODO make sure everything is instantiated only here.
    private Player player = new Player();
    private MapFrame mapFrame = MapFrame.getInstance();
    WeaponCreator weaponCreator = new WeaponCreator();
    ArmorCreator armorCreator = new ArmorCreator();
    EnemyCreator enemyCreator = new EnemyCreator();

    Deque<Menu> menuStack = new ArrayDeque<>();
    private final MainMenu mainMenu = new MainMenu(ui);
    private final MovementMenu movementMenu = new MovementMenu(ui);
    private final CheatMenu cheatMenu = new CheatMenu(ui);
    private final CombatMenu combatMenu = new CombatMenu(ui, player);

    private boolean gameRunning = true;
    private boolean mainMenuNeeded = true;

    public void executeMainMenu() {
        promptConfigureStartGame();
        while (gameRunning && mainMenuNeeded) {
            try {
                mainMenu.promptPrintMenu();
                String returnValueFromMainMenu = mainMenu.returnUserInput();
                switch (returnValueFromMainMenu) {
                    case "Start game" -> startGame();
                    // LOAD GAME
                    case "Show tutorial" -> showTutorial();
                    case "Want to quit?" -> wantToQuitGame();
                    case "Go to cheat menu" -> promptCheatMenu();
//            case null -> invalidInput(); // need java preview to use
                    default -> promptInvalidInput();
                }
            } catch (NullPointerException nullPointerException) {
                promptInvalidInput();
            }
        }
    }

    // ------------------ PROMPTS ------------------

    private void promptMovementMenu() {
        mainMenuNeeded = false;
        boolean combat = checkForCombat();
        while (!combat && gameRunning) { //todo Dur ikke ordenligt...
            try {
                movementMenu.promptPrintMenu();
                String returnValueFromMovementMenu = movementMenu.returnUserInput();
                switch (returnValueFromMovementMenu) {
                    case "Move north" -> player.moveNorth();
                    case "Move west" -> player.moveWest();
                    case "Move south" -> player.moveSouth();
                    case "Move east" -> player.moveEast();
                    case "Show player position" -> player.promptPrintPlayerPosition();
                    case "Show available information" -> player.promptPrintAvailableInfo();
                    case "Want to quit?" -> wantToQuitGame(); //TODO GOING TO MAIN MENU IF INVALID INPUT
                    case "Go to cheat menu" -> promptCheatMenu();
//                case null -> invalidInput(); // need java preview to use
                    default -> promptInvalidInput();
                }
            } catch (InputMismatchException e) {
                promptInvalidInput();
            }
            if (mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY()).equalsIgnoreCase("Combat")) {
                combat = true;}
//            else if (mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY()). // TODO NEED TO GET WEAPON AND GRANT TO PLAYER
//                    equalsIgnoreCase(weaponCreator.getWeaponsCopyArraylistInOrder())){
//                player.setPlayerWeapon(mapFrame.updatePlayerPosition(player.getPlayerPositionX(),player.getPlayerPositionY()));
        }

        if (combat) promptCombatMenu();
    }


    private void promptCombatMenu() {
        boolean combat = checkForCombat();
        while (combat && gameRunning) {
            try {
                combatMenu.promptPrintMenu();
                String returnValueFromCombatMenu = combatMenu.returnUserInput();
                switch (returnValueFromCombatMenu) {
                    case "Attack" -> player.attack();
                    case "Attempt to flee" -> player.flee();
// TODO more
                    case "Want to quit?" -> wantToQuitGame();
                    case "Show available information" -> player.promptPrintAvailableInfo();
                    case "Go to cheat menu" -> promptCheatMenu();
//            case null -> invalidInput(); // need java preview to use
                    default -> promptInvalidInput();
                }
            } catch (InputMismatchException e) {
                promptInvalidInput();
            }
            // aiTurn
            // combat = enemyTurn();
            // loot logic
            gameRunning = player.validatePlayerHealth();
            if (!combat) promptMovementMenu(); // TODO Transition and loot
        }
    }

    private void promptCheatMenu() {
        boolean cheatsActivated = evaluateCheatsActivated();
        while (cheatsActivated && gameRunning) {
            try {
                cheatMenu.promptPrintMenu();
                String returnValueFromCheatMenu = cheatMenu.returnUserInput();
                {
                    switch (returnValueFromCheatMenu) {
                        case "Move north" -> player.moveNorth();
                        case "Move west" -> player.moveWest();
                        case "Move south" -> player.moveSouth();
                        case "Move east" -> player.moveEast();
                        case "Make map visible" -> mapFrame.makeMapVisible();
                        case "Make map invisible" -> mapFrame.makeMapInvisible();
                        case "Grant weapon" -> grantPlayerWeaponByName();
                        case "Grant armor" -> grantPlayerArmorByName();
                        case "Change attributes" -> chooseWhichAttributeToChange();
                        case "Sharpen weapon" -> player.sharpenWeapon();
                        case "Repair armor" -> player.repairAndCleanArmor();
                        case "Show all map locations" ->
                                mapFrame.showAllMapLocationsCHEAT(player.getPlayerPositionX(), player.getPlayerPositionY());
                        case "Show Available information" -> player.promptPrintAvailableInfo();
                        case "Want to quit?" -> wantToQuitGame();
                        case "Go to previous menu" -> determinePreviousMenuAndGoThere(); // TODO working title
//                    case null -> invalidInput(); // need java preview to use
                        default -> promptInvalidInput(); //TODO RETURNER TIL HOVEDMENU VED FAILED INPUT???????
                    }
                }
            } catch (InputMismatchException e) {
                promptInvalidInput();
            }
            mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY());
//            validateCheatsActivated(); //TODO
            determinePreviousMenuAndGoThere(); // TODO go out of cheat menu
        }
    }

    private void promptConfigureStartGame() {
//        enemyCreator.instantiateEnemies(); TODO DUR IKKE HER ÅBENBART BRUGES I KLASSEN SELV
//        weaponCreator.instantiateWeapons();
//        armorCreator.instantiateArmor();

//        mapFrame.placeEnemiesOnMapLocations();
//        mapFrame.placeWeaponsOnMapLocations();
//        mapFrame.placeArmorOnMapLocations();

        promptWelcomeMessage();
        promptSleepForOneAndAHalfSecond();
    }

    private boolean evaluateCheatsActivated() {
//        if (in cheats menu){
        return true;
//        }else return false;
    }

    public void promptWelcomeMessage() {
        ui.welcomeMessage();
    }

    public void promptSleepForOneAndAHalfSecond() {
        ui.sleepForOneSecond();
        ui.sleepForHalfASecond();
    }

    private void promptInvalidInput() {
        ui.printInvalidInput();
//        prompt last menu TODO
    }

    // ------------------ OTHER ------------------

    private void wantToQuitGame() {
        gameRunning = !ui.wantToQuitGame();
        if (!gameRunning) {
            System.exit(0);
        } // TODO GOING BACK AFTER THIS?
    }

    private void goToMainMenu() {
        System.out.println();
    }

    public void startGame() {
        ui.printPlayerMessage1(player.getPlayerName());
        promptMovementMenu();
    }

    public void showTutorial() {
        // ui.show rules
        //TODO

        startGame();
    }

    private boolean checkForCombat() { //todo
//        if (mapFrame.determineCombat) {
        return false;
//        } else return false;
    }

    public void switchMenu(Menu newMenu) {
        menuStack.push(newMenu);
        newMenu.promptPrintMenu(); //TODO Dont print here?
    }

    private boolean determinePreviousMenuAndGoThere() { // return String TODO
        if (!menuStack.isEmpty()) {
            Menu previousMenu = menuStack.pop();
            previousMenu.promptPrintMenu();
            return true;
        }
        return false;
    }

    private void grantPlayerWeaponByName() {
        ui.printWeaponsArraylistInOrder(weaponCreator.getWeaponsCopyArraylistInOrder());
        ui.printInfoToSelectItemByName();
        String specificWeaponName = ui.getSpecificStringInput();
        player.setPlayerWeapon(weaponCreator.getWeaponByName(specificWeaponName));
        player.getPlayerWeapon().setWeaponCondition(WeaponCondition.NORMAL);
        ui.printConfirmationGettingItem();

    }

    private void grantPlayerArmorByName() {
        ui.printArmorArrayListInOrder(armorCreator.getArmorPiecesCopyArraylistInOrder());
        ui.printInfoToSelectItemByName();
        String specificArmorName = ui.getSpecificStringInput();
        if (player.getPlayerStrength() < armorCreator.getArmorByName(specificArmorName).getRequiredStrength()) {
            player.setPlayerStrength(armorCreator.getArmorByName(specificArmorName).getRequiredStrength());
        }
        player.setPlayerArmor(armorCreator.getArmorByName(specificArmorName));
        player.setPlayerArmorCondition(ArmorCondition.NORMAL);
        ui.printConfirmationGettingItem();
    }

    private void chooseWhichAttributeToChange() {
        ui.printChooseTheAmountOfTheAttribute();
        int attributeAmount = ui.getSpecificIntInput();
        ui.printChooseWhichAttributeToChange();
        int userInput = ui.getSpecificIntInput();
        switch (userInput) {
            case 1 -> player.setPlayerLevel(attributeAmount);
            case 2 -> player.setPlayerHealthPoints(attributeAmount);
            case 3 -> player.setPlayerAgility(attributeAmount);
            case 4 -> player.setPlayerIntelligence(attributeAmount);
            case 5 -> player.setPlayerStamina(attributeAmount);
            case 6 -> player.setPlayerStrength(attributeAmount);
            default -> promptInvalidInput();
        }
        ui.printConfirmationChangingAttribute(); // Posibility to change things in correct order.
    }

}