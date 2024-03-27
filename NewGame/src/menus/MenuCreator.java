package menus;

import armor.ArmorCreator;
import armor.ArmorCondition;
import enemies.inheritance.Enemy;
import enemies.inheritance.UncommonEnemy;
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
    private Enemy enemy = new UncommonEnemy("Cow"); // TODO SKER FLERE GANGE RUNDT OMKRING. JEG SKAL INSTANTIERERE FORFRA FOR AT FÅ SYSTEMET I GANG.
    private MapFrame mapFrame = MapFrame.getInstance();
    WeaponCreator weaponCreator = new WeaponCreator();
    ArmorCreator armorCreator = new ArmorCreator();
    EnemyCreator enemyCreator = new EnemyCreator();

    Deque<Menu> menuStack = new ArrayDeque<>();
    private final MainMenu mainMenu = new MainMenu(ui);
    private final MovementMenu movementMenu = new MovementMenu(ui);
    private final CheatMenu cheatMenu = new CheatMenu(ui);
    private final CombatMenu combatMenu = new CombatMenu(ui, player, enemy);

    private boolean gameRunning = true;
    private boolean mainMenuNeeded = true;
    boolean combat;

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
                String playerPositionReturnValue = mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY(), player.getPlayerLevel());
                switch (playerPositionReturnValue) {//TODO VIL GØRE SMARTERE!
                    case "Combat, " -> promptCombatMenuWithCombatActive();
                    case "Common longsword, " ->
                            player.setPlayerWeapon(weaponCreator.getWeaponByName("Common longsword"));
                    case "Common splint, " -> player.setPlayerArmor(armorCreator.getArmorByName("Common splint"));

                    case "Sword of Keilier, " ->
                            player.setPlayerWeapon(weaponCreator.getWeaponByName("Sword of Keilier"));
                    case "Splint of Keilier, " ->
                            player.setPlayerArmor(armorCreator.getArmorByName("Splint of Keilier"));

                    case "Sword of Keilier, Splint of Keilier" -> equipSetOfKeilierFromCorpse();
                    case "Common longsword, Common splint" -> equipCommonSetFromHaewenCity();

//                    case "Keep old item" -> System.out.println("lol"); // TEST TODO REMOVE
                }
            } catch (InputMismatchException e) {
                promptInvalidInput();
            }
            // todo Move to seperate method?


            if (mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY(), player.getPlayerLevel()).equalsIgnoreCase("Combat, ")) {
                combat = true;
            } // TODO ALSO INCLUDE PLACE WHERE ENEMY AND WEAPONS/ARMOR
//            else if (mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY()). // TODO NEED TO GET WEAPON AND GRANT TO PLAYER
//                    equalsIgnoreCase(weaponCreator.getWeaponsCopyArraylistInOrder())){
//                player.setPlayerWeapon(mapFrame.updatePlayerPosition(player.getPlayerPositionX(),player.getPlayerPositionY()));
        }

        if (combat) promptCombatMenu();
    }

    private void promptCombatMenuWithCombatActive() {
        combat = true;
        promptCombatMenu();
    }

    private void promptCombatMenu() {
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
            enemyTurn();
            // combat = enemyTurn();
            // loot logic
            gameRunning = player.validatePlayerHealth();
            if (!combat) promptMovementMenu(); // TODO Transition and loot
        }
    }

    private void promptCheatMenu() {
        mapFrame.makeMapVisible();
        boolean cheatsActivated = evaluateCheatsActivated();
        while (cheatsActivated && gameRunning) {
//            try { // TODO HANDLE INPUTS (EXCEPTIONS) IN UI CLASSES.
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
                            mapFrame.showAllMapLocationsCHEAT(player.getPlayerPositionX(), player.getPlayerPositionY(), player.getPlayerLevel());
                    case "Show Available information" -> player.promptPrintAvailableInfo();
                    case "Want to quit?" -> wantToQuitGame();
                    case "Go to previous menu" -> determinePreviousMenuAndGoThere(); // TODO working title
//                    case null -> invalidInput(); // need java preview to use
//                        default -> promptInvalidInput(); //TODO RETURNER TIL HOVEDMENU VED FAILED INPUT???????
                }
                String playerPositionReturnValue = mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY(), player.getPlayerLevel());
                switch (playerPositionReturnValue) {//TODO VIL GØRE SMARTERE!
                    case "Combat, " -> promptCombatMenuWithCombatActive();
                    case "Common longsword, " ->
                            player.setPlayerWeapon(weaponCreator.getWeaponByName("Common longsword"));
                    case "Common splint, " -> player.setPlayerArmor(armorCreator.getArmorByName("Common splint"));

                    case "Sword of Keilier, " ->
                            player.setPlayerWeapon(weaponCreator.getWeaponByName("Sword of Keilier"));


                    case "Sword of Keilier, Splint of Keilier" -> equipSetOfKeilierFromCorpse();

//                        case "Nothing" -> System.out.println(); // TEST TODO REMOVE
                }
            }
//            } catch (InputMismatchException e) {
//                promptInvalidInput();
//            }
//            mapFrame.updatePlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY()); TODO NOT NEEDED?
//            validateCheatsActivated(); //TODO
            //   determinePreviousMenuAndGoThere(); // TODO go out of cheat menu
        }
    }

    private void equipSetOfKeilierFromCorpse() {
        player.setPlayerWeapon(weaponCreator.getWeaponByName("Sword of Keilier"));
        player.setPlayerWeaponCondition(WeaponCondition.RUSTY);
        player.setPlayerArmor(armorCreator.getArmorByName("Splint of Keilier"));
        player.setPlayerArmorCondition(ArmorCondition.DIRTY);
    }

    private void equipCommonSetFromHaewenCity() {
        player.setPlayerWeapon(weaponCreator.getWeaponByName("Common longsword"));
        player.setPlayerWeaponCondition(WeaponCondition.NORMAL);
        player.setPlayerArmor(armorCreator.getArmorByName("Common splint"));
        player.setPlayerArmorCondition(ArmorCondition.NORMAL);
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

    private boolean evaluateCheatsActivated() { // TODO
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

    private void enemyTurn() {
        player.setPlayerHealthPoints(player.getPlayerHealthPoints() - (int) Math.floor(enemy.getEnemyAttackDamage()));
        ui.printEnemyTurn(enemy.getEnemyName(), (int) enemy.getEnemyAttackDamage(), player.getPlayerHealthPoints());
    }

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

//    private boolean checkForCombat() { //todo
//        if (mapFrame.determineCombat) {
//        return false;
//        } else return false;
//    }

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

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}