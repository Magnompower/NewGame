package menus;

import armor.ArmorCondition;
import armor.ArmorCreator;
import armor.inheritance.Armor;
import classes.Player;
import enemies.EnemyCreator;
import enemies.inheritance.Enemy;
import map_logic.MapFrame;
import menus.inheritance.*;
import ui.UI;
import weapons.WeaponCondition;
import weapons.WeaponCreator;
import weapons.inheritance.Weapon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MenuCreator {
    private final UI ui = new UI(); // TODO make sure everything is instantiated only here.
    private final Player player = new Player();
    private Enemy enemy; // TODO SKER FLERE GANGE RUNDT OMKRING. JEG SKAL INSTANTIERERE FORFRA FOR AT FÅ SYSTEMET I GANG.
    private final MapFrame mapFrame = MapFrame.getInstance();
    private final WeaponCreator weaponCreator = new WeaponCreator();
    private final ArmorCreator armorCreator = new ArmorCreator();
    private final EnemyCreator enemyCreator = new EnemyCreator();
    private final CheatMenu cheatMenu = new CheatMenu(ui);
    private final MovementMenu movementMenu = new MovementMenu(ui);

    Deque<Menu> menuStack = new ArrayDeque<>();

    private boolean gameRunning = true;
    boolean combat;

    public void executeProgram() {
        promptMainMenu(); // TODO MAYBE NOT NEEDED
    }

    public void promptMainMenu() {
        MainMenu mainMenu = new MainMenu(ui);
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
    }

    // ------------------ PROMPTS ------------------

    private void promptCheatMenu() {
        mapFrame.makeMapVisible();
        executeMenuLogicInOrder(cheatMenu);
        //   determinePreviousMenuAndGoThere(); // TODO go out of cheat menu
    }

    private void promptMovementMenu() {
        executeMenuLogicInOrder(movementMenu);
    }
    // TODO ALSO INCLUDE PLACE WHERE ENEMY AND WEAPONS/ARMOR


    private void promptCombatMenu() {
        CombatMenu combatMenu = new CombatMenu(ui, player, enemyCreator.getEnemiesByName(enemy.getEnemyName()));
        while (combat && gameRunning) {
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
            enemyTurn();
            gameRunning = player.validatePlayerHealth();
            combat = player.evaluateCombat();
        }
    }

    private void executeMenuLogicInOrder(Menu menu) { //TODO NOW
        while (gameRunning) {
            printAndHandleMenu(menu);

            mapFrame.updateMapFromPlayerPosition(player.getPlayerPositionX(), player.getPlayerPositionY());

            combat = mapFrame.checkForEnemy();
            if (combat) {
                handleEnemyOnLocationIfCombat();
                promptCombatMenu();
            }

            // enemy loot logic

            handleWeaponOnLocation();
            handleArmorOnLocation();
        }

    }


    private void handleArmorOnLocation() { // TODO MOVE AS MANY METHODS AS POSSIBLE AWAY FROM MENUCREATOR
        Armor armorOnCurrentLocation = mapFrame.checkForArmor(); // TODO MOVE LOGIC TO SETTER
        if (armorCreator.getArmorPiecesCopyArraylistInOrder().contains(armorOnCurrentLocation) && armorOnCurrentLocation != null) {
            player.setPlayerArmor(armorOnCurrentLocation);
        }
    }

    private void handleWeaponOnLocation() { // TODO WORKS? ERROR HANDELING
        Weapon weaponOnCurrentLocation = mapFrame.checkForWeapon();
        if (weaponCreator.getWeaponsCopyArraylistInOrder().contains(weaponOnCurrentLocation) && weaponOnCurrentLocation != null) {
            player.setPlayerWeapon(weaponOnCurrentLocation);
        }
    }

    private void handleEnemyOnLocationIfCombat() {
            Enemy currentEnemy = mapFrame.decideEnemyBasedOnLevel(player.getPlayerLevel());
            if (enemyCreator.getEnemiesCopyArraylistInOrder().contains(currentEnemy)) {
                String currentEnemyColoredString = currentEnemy.getEnemyColor() + currentEnemy.getEnemyName();
                ui.printCombatInfo(currentEnemyColoredString);
            }

            setEnemy(currentEnemy);
    }

    private void printAndHandleMenu(Menu menu) {
        String returnValueFromCheatMenu;
        String returnValueFromMovementMenu;

        if (menu == cheatMenu) {
            menu.promptPrintMenu();
            returnValueFromCheatMenu = cheatMenu.returnUserInput();
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
                case "Go to movement menu" -> promptMovementMenu();
                //case "Go to start game" ->
//                    case null -> invalidInput(); // need java preview to use
//                        default -> promptInvalidInput(); //TODO RETURNER TIL HOVEDMENU VED FAILED INPUT???????
            }
        }
        if (menu == movementMenu) {
            movementMenu.promptPrintMenu();
            returnValueFromMovementMenu = movementMenu.returnUserInput();
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
//                default -> promptInvalidInput();
            }
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

    public void promptConfigureGameBeforeStart() { // Initializer and more.

        enemyCreator.instantiateEnemies(); // TODO DUR IKKE HER ÅBENBART BRUGES I KLASSEN SELV??
        weaponCreator.instantiateWeapons();
        armorCreator.instantiateArmor();

        player.setPlayerWeapon(weaponCreator.getWeaponByName("Poor dagger")); // Start weapon.
        player.setPlayerWeaponCondition(WeaponCondition.BROKEN); // Start weapon condition.

        player.setPlayerArmor(armorCreator.getArmorByName("Poor kilt")); // Start armor.
        player.setPlayerArmorCondition(ArmorCondition.BROKEN); // Start armor condition.

        mapFrame.placeEnemiesOnMapLocations();
        mapFrame.placeWeaponsOnMapLocations();
        mapFrame.placeArmorOnMapLocations();

        promptWelcomeMessage();
    }

    public void promptWelcomeMessage() {
        ui.welcomeMessage();
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

    public void startGame() {
        ui.printPlayerMessage1(player.getPlayerName());
        promptMovementMenu();
    }

    public void showTutorial() {
        // ui.show rules
        //TODO
        // STATECHANGE

        startGame();
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
        int attributeAmount = ui.getSpecificPositiveIntInput();
        ui.printChooseWhichAttributeToChange();
        int userInput = ui.getSpecificPositiveIntInput();
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