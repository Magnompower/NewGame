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
import java.util.Scanner;

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

    public void executeMainMenu() {
        //TODO ADD configurestartgame();
        weaponCreator.instantiateWeapons();
        armorCreator.instantiateArmor();
        enemyCreator.instantiateEnemies();

        promptWelcomeMessage();
        promptSleepForOneAndAHalfSecond();

        mainMenu.promptPrintMenu();
        String returnValueFromMainMenu = mainMenu.returnUserInput();
        switch (returnValueFromMainMenu) {
            case "Start game" -> startGame();
            case "Show tutorial" -> showTutorial();
            case "Want to quit?" -> wantToQuitGame();
            case "Go to cheat menu" -> promptCheatMenu();
//            case null -> invalidInput(); // need java preview to use
            default -> invalidInput();
        }
    }

    // ------------------ PROMPTS ------------------

    private void promptMovementMenu() {
        boolean combat = checkForCombat();
        while (!combat) {
            movementMenu.promptPrintMenu();
            String returnValueFromMovementMenu = movementMenu.returnUserInput();
            switch (returnValueFromMovementMenu) {
                case "Move north" -> player.moveNorth();
                case "Move west" -> player.moveWest();
                case "Move south" -> player.moveSouth();
                case "Move east" -> player.moveEast();
                case "Show player position" -> player.promptPrintPlayerPosition();
                case "Show available information" -> player.promptPrintAvailableInfo();
                case "Go to cheat menu" -> promptCheatMenu();
//                case null -> invalidInput(); // need java preview to use
                default -> invalidInput();
            }
        }
        if (combat) promptCombatMenu();
    }

    private void promptCombatMenu() {
        boolean combat = checkForCombat();
        while (combat)
            combatMenu.promptPrintMenu();
        String returnValueFromCombatMenu = combatMenu.returnUserInput();
        switch (returnValueFromCombatMenu) {
            case "Attack" -> player.attack();
            case "Attempt to flee" -> player.flee();
// TODO more
            case "Go to cheat menu" -> promptCheatMenu();
            case "Show available information" -> player.promptPrintAvailableInfo();
//            case null -> invalidInput(); // need java preview to use
            default -> invalidInput();
        }
        if (!combat) promptMovementMenu(); // TODO Transition and loot
    }

    private void promptCheatMenu() {
        boolean cheatsActivated = evaluateCheatsActivated();
        while (cheatsActivated) {
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
                    case "Repair armor" -> player.repairArmor();
                    case "Show Available information" -> player.promptPrintAvailableInfo();
                    case "Go to previous menu" -> determinePreviousMenuAndGoThere(); // TODO working title
//                    case null -> invalidInput(); // need java preview to use
                    default -> invalidInput();
                }
            }
//            validateCheatsActivated(); //TODO
            determinePreviousMenuAndGoThere(); // TODO go out of cheat menu
        }
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

    // ------------------ OTHER ------------------

    private void wantToQuitGame() {
        boolean quitGame = !ui.wantToQuitGame();
        if (quitGame) {
            ui.printTimePlayed();
            System.exit(0); // TODO change to boolean?
        } // TODO GOING BACK AFTER THIS?
    }

    private void invalidInput() {
//        prompt last menu
        ui.invalidInput();

    }

    public void startGame() {
        ui.playerMessage1(player.getPlayerName());
        player.promptMakeMapVisible();
    }

    public void showTutorial() {
        // ui.show rules
        //TODO

        startGame();
    }

    private boolean checkForCombat() {
//        if (mapFrame.determineCombat) {
        return true;
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
        Scanner scanner = new Scanner(System.in);
        String specificWeaponName = scanner.nextLine();
        player.setPlayerWeapon(weaponCreator.getWeaponByName(specificWeaponName));
        player.getPlayerWeapon().setWeaponCondition(WeaponCondition.NORMAL);
    }

    private void grantPlayerArmorByName() {
        ui.printArmorArrayListInOrder(armorCreator.getArmorPiecesCopyArraylistInOrder());
        ui.printInfoToSelectItemByName();
        Scanner scanner = new Scanner(System.in);
        String specificArmorName = scanner.nextLine();
        if (player.getPlayerStrength() < armorCreator.getArmorByName(specificArmorName).getRequiredStrength()) {
            player.setPlayerStrength(armorCreator.getArmorByName(specificArmorName).getRequiredStrength());
        }
        player.setPlayerArmor(armorCreator.getArmorByName(specificArmorName));
        player.setPlayerArmorCondition(ArmorCondition.NORMAL);
        ui.printConfirmationGettingItem();
    }

    private void chooseWhichAttributeToChange() {
        ui.printChooseTheAmountOfTheAttribute();
        Scanner scanner = new Scanner(System.in);
        int attributeAmount = scanner.nextInt();
        ui.printChooseWhichAttributeToChange();
        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> player.setPlayerLevel(attributeAmount);
            case 2 -> player.setPlayerHealthPoints(attributeAmount);
            case 3 -> player.setPlayerAgility(attributeAmount);
            case 4 -> player.setPlayerIntelligence(attributeAmount);
            case 5 -> player.setPlayerStamina(attributeAmount);
            case 6 -> player.setPlayerStrength(attributeAmount);
            default -> invalidInput();
        }
        ui.printConfirmationChangingAttribute(); // Posibility to change things in correct order.
    }

}