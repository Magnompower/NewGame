package ui;

import armor.inheritance.Armor;
import enemies.inheritance.Enemy;
import weapons.inheritance.Weapon;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI { //TODO UDVIDET UI KLASSE?! Polymorfi?
    //    UIMapFrame uiMapFrame;// = new UIMapFrame(); // TODO PROBLEM WITH INSTANCIATION
    private final Scanner scanner = new Scanner(System.in);
    private final LocalTime timeWhenGameStart = LocalTime.now(); // TODO SKAL MÅSKE INSTACIERES FØR DEN "TÆLLER"?
    private boolean validInput;

    public void welcomeMessage() {
        System.out.print(ConsoleColors.PURPLE_BRIGHT + "MAGNOM ");
        sleepForOneSecond();
        System.out.print(ConsoleColors.YELLOW_BRIGHT + "P");
        sleepForHalfASecond();
        System.out.print("R");
        sleepForHalfASecond();
        System.out.print("E");
        sleepForHalfASecond();
        System.out.print("S");
        sleepForHalfASecond();
        System.out.print("E");
        sleepForHalfASecond();
        System.out.print("N");
        sleepForHalfASecond();
        System.out.print("T");
        sleepForHalfASecond();
        System.out.println("S");
        sleepForOneSecond();
        System.out.print(ConsoleColors.CYAN_BRIGHT + "KEYS");
        sleepForOneSecond();
        System.out.print(ConsoleColors.YELLOW_BRIGHT + " of ");
        sleepForOneSecond();
        System.out.println(ConsoleColors.CYAN_BRIGHT + "JUSTICE" + ConsoleColors.RESET);

        sleepForOneSecond();
        sleepForHalfASecond();
    }


    public boolean wantToQuitGame() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "\nType " + ConsoleColors.RED_BRIGHT
                + "YES" + ConsoleColors.YELLOW_BRIGHT + " if you want to quit. Everything else will " +
                ConsoleColors.GREEN_BRIGHT + "CONTINUE" + ConsoleColors.YELLOW_BRIGHT + " the game." + ConsoleColors.RESET);

        String playerInput = getSpecificStringInput();

        if (playerInput.equalsIgnoreCase("YES") || playerInput.equalsIgnoreCase("Y")) {
            printTimePlayed();
            return true;

        } else return false;
    }


    public void printTimePlayed() {
        Duration duration = Duration.between(timeWhenGameStart, LocalTime.now());

        long minutesPlayed = duration.toMinutes();
        long hoursPlayed = duration.toHours();
        String hoursAndMinutesPlayed;

        if (hoursPlayed > 0) {
            hoursAndMinutesPlayed = hoursPlayed + " hour" + (hoursPlayed == 1 ? "" : "s") + " and ";
        } else {
            hoursAndMinutesPlayed = "";
        }
        hoursAndMinutesPlayed += minutesPlayed + " minute" + (minutesPlayed == 1 ? "" : "s");

        System.out.print("\n\n" + ConsoleColors.YELLOW_BRIGHT + "You have wasted " + ConsoleColors.CYAN_BRIGHT +
                hoursAndMinutesPlayed + ConsoleColors.YELLOW_BRIGHT + " playing this stupid game." +
                ConsoleColors.CYAN_BRIGHT + " :)" + ConsoleColors.RESET);
    }

    public void printWeaponsArraylistInOrder(ArrayList<Weapon> weapons) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Here is a list of all the weapons in the game:\n" +
                ConsoleColors.RESET);
        for (Weapon weapon : weapons) {
            //TODO remove "| and placeholder" Maybe in weaponCreator
            System.out.println(weapon);
        }
    }

    public void printEnemiesArraylistInOrder(ArrayList<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
    }

    public void printArmorArrayListInOrder(ArrayList<Armor> armorPieces) {
        for (Armor armor : armorPieces) {
            System.out.println(armor);
        }
    }

    public void printInvalidInput() {
        System.out.println(ConsoleColors.RED_BRIGHT + "Invalid input. Try again." + ConsoleColors.RESET);
        //TODO
    }
    // TODO When defeating an enemy you know its stats next fight.


    public void printPlayerMessage1(String playerName) {
        System.out.print(ConsoleColors.YELLOW_BRIGHT + "You wake up feeling very disoriented. ");
        sleepForTwoSeconds();
        System.out.print("Something is pounding in the back of your head. ");
        sleepForOneSecond();
        System.out.print("You realize it simply is a massive bump. ");
        sleepForTwoSeconds();
        System.out.print("Before you can manage to think a single thought you hear a old and crisp voice:\n\n");
        sleepForOneSecond();
        System.out.print(ConsoleColors.CYAN_BRIGHT + "Oh dear. It's a miracle you're still alive. " +
                "What is your name young one?\n\n" + ConsoleColors.RESET);

        playerName = selectName();

        System.out.println(ConsoleColors.CYAN_BRIGHT + "You should be very thankful " + playerName + "! " +
                "I patched you up as well as i could. In time - you should be able to make a full recovery! " +
                "Why are you out here in the middle of nowhere by yourself? " + ConsoleColors.RESET);
        sleepForOneSecond();
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "You see an old man with white robes kneeling over you " +
                "before you take a movement to try and remember what happened. " +
                ConsoleColors.RESET);
        sleepForTwoSeconds();
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Hmmmm....." + ConsoleColors.RESET);
        sleepForTwoSeconds();
        System.out.println(ConsoleColors.GREEN_BRIGHT + "The last thing i remember is seeing a lot of people riding " +
                "towards me at high speeds." + ConsoleColors.RESET);
        sleepForOneSecond();
        System.out.println(ConsoleColors.GREEN_BRIGHT + "I think it was... BANDITS!" + ConsoleColors.RESET);
        sleepForOneSecond();
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You are not the first one to be attacked by bandits around " +
                "these parts. Anyway i found this map lying besides you. Here you go." + ConsoleColors.RESET);
        sleepForTwoSeconds();
//    TODO    uiMapFrame.promptMakeMapVisible();
//        mapFrame.makeMapVisible();
        sleepForOneSecond();
        System.out.println(ConsoleColors.CYAN_BRIGHT + "I would suggest that you go to Haewen City and get fixed up. " +
                "You dont exactly look fantastic. " + ConsoleColors.YELLOW_BRIGHT + "The old man smirks. " +
                ConsoleColors.CYAN_BRIGHT + "It is just 5 kilometers north from here as you can see on the map. " +
                "Safe journeys friend. " + ConsoleColors.YELLOW_BRIGHT + "\n\nYou stare after the man. He moves" +
                " surprisingly quickly. After you have gathered you remaining items and gotten on you feet you look" +
                " towards the old man again and can just barely see him far away in the distance. " + ConsoleColors.RESET);

    }

    public String selectName() { // TODO make strings array.
        String playerName = null;
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "1. My name is Micheal.\n2. I am Hisha.\n" +
                "3. Howdy partner. I am Bobb.\n4. Hello mister my name is Kim.\n5. Me name Jeff.\n6. I am Null.\n7. I dont remember." +
                ConsoleColors.RESET);
        int playerInput = getSpecificPositiveIntInputBetween1And10();
        switch (playerInput) {
            case 0 -> wantToQuitGameAndNotAName();
            case 1 -> playerName = "Micheal";
            case 2 -> playerName = "Hisha";
            case 3 -> playerName = "Bobb";
            case 4 -> playerName = "Kim";
            case 5 -> playerName = "Jeff";
            case 6 -> playerName = "Null";
            case 7 -> playerName = "Nameless";
            //TODO FIND 10 NAMES
            default -> printNotAName();
        }
        return playerName;
    }

    private void wantToQuitGameAndNotAName() {
        wantToQuitGame();
        printNotAName();
    }

    private int getSpecificPositiveIntInputBetween1And10() {
        int returnInt = -1;
        while (!validInput) {
            try {
                returnInt = scanner.nextInt();
            } catch (InputMismatchException e) { // TODO WHAT EXECPTION?
                printInvalidInput();
            }
            if (returnInt > -1 && returnInt < 11) //TODO MORE
                validInput = true;
        }
        validInput = false; // Prep validInput to next use.
        return returnInt;
    }

    private void printNotAName() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "I dont think that is a name. I will call you Null - " +
                "just like one of my good friends. Anyway! ");
        sleepForOneSecond();
    }

    // ------------------ MENU'S ------------------
    public String printMainMenuHeader() {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "MAIN MENU" + ConsoleColors.RESET;
    }

    public String printMovementMenuHeader() {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "MOVEMENT MENU" + ConsoleColors.RESET;
    }

    public String printCombatMenuHeader(String playerNameColored, String enemyNameColored) {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "COMBAT MENU" + ConsoleColors.RESET + "\n" + playerNameColored +
                " versus " + enemyNameColored + ConsoleColors.RESET;
    }

    public String[] printCombatMenuPoints(int calculatedChanceToEscape) { // TODO
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "1. Attack.", "2. Attempt to flee. (" +
                calculatedChanceToEscape + ")", "9. Show all available information.", "0. Rage quit." + ConsoleColors.RESET};
    }

    public String[] printMainMenuPoints() {
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "1. Start game.", "9. Show tutorial.",
                "0. Quit game." + ConsoleColors.RESET};
    }

    public String[] printMovementMenuPoints() {
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "W/8. Move north.", "A/4. Move west.",
                "S/2. Move south.", "D/6. Move east.", "5. See player position.",
                "9. Show all available information.", "0. Quit game." + ConsoleColors.RESET};
    }

    public String printCheatMenuHeader() {
        return ConsoleColors.CYAN_BRIGHT + "CHEAT MENU" + ConsoleColors.RESET;
    }

    public String[] printCheatMenuPoints() {
        return new String[]{ConsoleColors.CYAN_BRIGHT + "W/A/S/D. Move around.", "1. Make map visible.",
                "2. Make map invisible.", "3. Grant yourself a weapon.", "4. Grant yourself a piece of armor.",
                "5. Change attributes.", "6. Sharpen weapon.", "7. Repair armor.", "8. Show all map locations.",
                "9. Show all Available information.", "10. Teleport to location.",
                "\n0. Quit game.", "33. Go to movement menu."};
    }

    // ------------------ SLEEP-TIMERS ------------------

    public void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cannotMoveFurtherWestMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
    }

    public void sleepForHalfASecond() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private void sleepForTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAvailableInfo(String playerDetails, int playerDamage, int playerPositionX, int playerPositionY,
                                   String weaponDetails, String armorDetails, int enemiesKilled) {


        System.out.println(playerDetails);

        System.out.println((ConsoleColors.YELLOW_BRIGHT + "Position: " + ConsoleColors.SALMON + "X" +
                ConsoleColors.YELLOW_BRIGHT + "|" + ConsoleColors.SALMON + "Y  " + playerPositionX +
                ConsoleColors.YELLOW_BRIGHT + "|" + ConsoleColors.SALMON + playerPositionY +
                ConsoleColors.RESET)); //TODO CAN BE DONE SMARTER. ALREADY HAVE METHOD

        String playerDamageString = String.valueOf(playerDamage);
        weaponDetails = weaponDetails.replace("%placeHolder1%", playerDamageString);

//        String playerMaximumAmountOfDamageString = String.valueOf(playerDamage+ weaponDetails. TODO

        System.out.println(weaponDetails);

        System.out.println(armorDetails);

//        System.out.println(enemiesKilled); //TODO COLOR IN PLAYER

        // TODO THINK I FUCKED UP WITH COLORING. HAVING BOTH IN TOSTRING AND HERE.
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Enemies killed: " + ConsoleColors.SALMON + enemiesKilled
                + ConsoleColors.RESET); // TODO: Implement logic to count and display the number of enemies killed
        //TODO ARMOR
    }

    public void printPlayerPosition(int playerPositionX, int playerPositionY) {
        String playerPosition = (ConsoleColors.YELLOW_BRIGHT + "Position: " + ConsoleColors.SALMON + "X" +
                ConsoleColors.YELLOW_BRIGHT + "|" + ConsoleColors.SALMON + "Y  " + playerPositionX +
                ConsoleColors.YELLOW_BRIGHT + "|" + ConsoleColors.SALMON + playerPositionY +
                ConsoleColors.RESET);
        System.out.println(playerPosition);
    }

    public void cannotMoveFurtherEastMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further east!" + ConsoleColors.RESET);
    }

    public void cannotMoveFurtherSouthMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further south!" + ConsoleColors.RESET);
    }

    public void cannotMoveFurtherNorthMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further north!" + ConsoleColors.RESET);
    }

    public void displayDamageDealt(double playerDamage, int enemyActualhealth, int enemyMaxHealth) {
        if (playerDamage == 1) {
            System.out.print(ConsoleColors.YELLOW_BRIGHT + "You attack. You deal " + ConsoleColors.LIGHT_GOLD +
                    playerDamage + ConsoleColors.YELLOW_BRIGHT + " point of damage" + ConsoleColors.RESET);
        } else
            System.out.print(ConsoleColors.YELLOW_BRIGHT + "Your attack deals " + ConsoleColors.LIGHT_GOLD +
                    playerDamage + ConsoleColors.YELLOW_BRIGHT + " points of damage." + ConsoleColors.RESET);

        if (enemyActualhealth <= enemyMaxHealth / 2) { //TODO CORRECT MATH
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "Your enemy looks damaged!");
        }
    }

    public void gameOver() {
        System.out.println(ConsoleColors.RED_BRIGHT + "You died. Game over." + ConsoleColors.RESET);
        //print stats TODO
        printTimePlayed();
    }

    public void printNotEnoughtStrengthToEquipArmorMessage(int playerStrength, int requiredStrength,
                                                           String armorName, String armorColor) {
        System.out.println(ConsoleColors.RED_BRIGHT + "You only have " + ConsoleColors.LIGHT_GOLD + playerStrength +
                ConsoleColors.RED_BRIGHT + " strength and " + armorColor + armorName + ConsoleColors.GREEN_BRIGHT +
                " requires " + ConsoleColors.LIGHT_GOLD + requiredStrength + ConsoleColors.RED_BRIGHT +
                " strength to equip." + ConsoleColors.RESET);
    }

    public void printErrorGettingEnemyMessage() {
        System.out.println(ConsoleColors.RED_BRIGHT + "Enemy not found." + ConsoleColors.RESET);
    }

    public void printErrorGettingitemMessage() {
        System.out.println(ConsoleColors.RED_BRIGHT + "Item not found." + ConsoleColors.RESET);
    }

    public void printInfoToSelectItemByName() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Simply type the item you want. " +
                "Be sure to spell the item correctly." + ConsoleColors.RESET);
    }

    public void printConfirmationGettingItem() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Item added to player." + ConsoleColors.RESET);

    }

    public void printChooseTheAmountOfTheAttribute() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "First choose the of the attribute amount you want " +
                "(e.g 20 if you want level 20)." + ConsoleColors.RESET);
    }

    public void printChooseWhichAttributeToChange() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Now choose which attribute to alter:\n1. Level.\n" +
                "2. Health points.\n3. Agility.\n4. Intelligence.\n5. Stamina.\n6. Strength.");
    }

    public void printConfirmationChangingAttribute() {
        System.out.println(ConsoleColors.GREEN_BRIGHT + "Attribute changed!" + ConsoleColors.RESET);
    }

    public void printNewWeaponCondition(String weaponConditionText, String weaponConditionColor) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Your weapon has been sharpened and its condition is now: " +
                weaponConditionColor + weaponConditionText + ConsoleColors.YELLOW_BRIGHT + "." + ConsoleColors.RESET);
    }

    public void printNewArmorCondition(String armorConditionText, String armorConditionColor) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Your armor has been repaired and its condition is now: " +
                armorConditionColor + armorConditionText + ConsoleColors.YELLOW_BRIGHT + "." + ConsoleColors.RESET);
    }

    public void PrintCannotSharpenWeaponFurther(String weaponConditionText, String weaponConditionColor) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Your weapon is " + weaponConditionColor + weaponConditionText
                + ConsoleColors.CYAN_BRIGHT + " and cannot be sharpened any further.");
    }

    public void printCannotRepairArmorAnyFurther(String armorConditionText, String armorConditionColor) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Your armor is " + armorConditionColor + armorConditionText
                + ConsoleColors.CYAN_BRIGHT + " and cannot be repaired any further.");

    }

    public void printCannotSharpenBrokenWeapon(String weaponConditionText, String weaponConditionColor) {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You cannot sharpen a " + weaponConditionColor + weaponConditionText
                + " weapon!" + ConsoleColors.RESET);
    }

    public void printMenu(String printString) {
        System.out.println("\n" + printString);
    }

    public String getSpecificStringInput() {
        String returnString = "";
        while (!validInput) {
            try {
                returnString = scanner.nextLine().trim(); // TODO FIX
            } catch (NullPointerException e) { // TODO WHAT EXCEPTION?
                printInvalidInput();
            } catch (Exception e) {
                printInvalidInput();
            }
            if (!returnString.isEmpty() && returnString.length() < 40) // TODO MORE MAYBE?
                validInput = true;
        }
        validInput = false; // Prep validInput to next use.
        return returnString;
    }

    public int getSpecificPositiveIntInput() {
        int returnInt = -1;
        while (!validInput) {
            try {
                returnInt = scanner.nextInt();
            } catch (InputMismatchException e) { // TODO WHAT EXECPTION?
                printInvalidInput();
            }
            if (returnInt > -1 && returnInt < 34) //TODO MORE
                validInput = true;
        }
        validInput = false; // Prep validInput to next use.
        return returnInt;

    }

    public void printEnemyAttack(String enemyNameColored, int enemyDamageAmount) { // todo maybe get enemycolor?
        System.out.println(enemyNameColored + ConsoleColors.YELLOW_BRIGHT + " attacks you and deal " + ConsoleColors.LIGHT_GOLD +
                enemyDamageAmount + ConsoleColors.YELLOW_BRIGHT + " damage " + ConsoleColors.RESET);
    }


//    printInvalidInput();
//        return""; // TODO ?? WHAT TO RETURN WHEN NOTHING

    public Weapon wantToEquipWeapon(Weapon weapon) {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "You find " + weapon.getWeaponColor() + weapon.getWeaponName() +
                ConsoleColors.YELLOW_BRIGHT + ". Do you want to equip it?" + ConsoleColors.GREEN_BRIGHT + " Y" +
                ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.RED_BRIGHT + "N");

        String playerInput = getSpecificStringInput();

        if (playerInput.equalsIgnoreCase("YES") || playerInput.equalsIgnoreCase("Y")) { // TODO MOVE SOUT LOGIC AFTER IT IS ACUALLY DONE
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "You have now equipped " + weapon.getWeaponColor() +
                    weapon.getWeaponName() + ConsoleColors.YELLOW_BRIGHT + "." + ConsoleColors.RESET);
            return weapon;
        } else if (playerInput.equalsIgnoreCase("NO") || playerInput.equalsIgnoreCase("N")) {
            return null; // TODO Make inventory
        } else return null; // WHAT TO RETURN AS DEFAULT? TODO
    }

    public Armor wantToEquipArmor(Armor armor) {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "You find " + armor.getArmorColor() + armor.getArmorName() +
                ConsoleColors.YELLOW_BRIGHT + ". Do you want to equip it?" + ConsoleColors.GREEN_BRIGHT + " Y" +
                ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.RED_BRIGHT + "N");

        String playerInput = getSpecificStringInput();

        if (playerInput.equalsIgnoreCase("YES") || playerInput.equalsIgnoreCase("Y")) {
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "You have now equipped " + armor.getArmorColor() +
                    armor.getArmorName() + ConsoleColors.YELLOW_BRIGHT + "." + ConsoleColors.RESET);
            return armor;
            // TODO RETURN  WHAT IF "N"
        } else return null; // Todo Sammenlign med wantToEquipWeapon og sikr fejlhåndtering.

    }

    public void printCombatInfo(String enemyToSpawnColored) {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "You hear a roar! ");
        sleepForOneSecond();
        System.out.println("A " + enemyToSpawnColored + ConsoleColors.YELLOW_BRIGHT + " appears as you draw arms." + ConsoleColors.RESET);
    }

    public void printEnemyIsDead(String deadEnemyNameColored, int currentLoot) {
        System.out.println(deadEnemyNameColored + ConsoleColors.YELLOW_BRIGHT + " is dead. You search the dead body and find "
                + ConsoleColors.LIGHT_GOLD + currentLoot + ConsoleColors.YELLOW_BRIGHT + " coin." + ConsoleColors.RESET); //TODO ALTER LOOT
    }

    public void printEnemyTurn(String enemyName, int enemyAttackDamage, int playerHealthPoints) {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "The " + enemyName + ConsoleColors.YELLOW_BRIGHT +
                " attacks you and deal " + enemyAttackDamage + ConsoleColors.YELLOW_BRIGHT +
                " your remaining health is " + playerHealthPoints + ConsoleColors.RESET);
    }

}
