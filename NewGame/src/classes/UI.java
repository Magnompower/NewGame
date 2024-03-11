package classes;

import comparators.EnemyHealthComparator;
import comparators.WeaponDamageComparator;
import enemies.Enemy;
import weapons.Weapon;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    LocalTime timeWhenGameStart = LocalTime.now(); // TODO SKAL MÅSKE INSTACIERES FØR DEN "TÆLLER"?

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
    }


    public boolean wantToQuitGame() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Are you sure you want to quit? (" + ConsoleColors.RED_BRIGHT
                + "Y" + ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.GREEN_BRIGHT + "N" +
                ConsoleColors.YELLOW_BRIGHT + ");" + ConsoleColors.RESET);

        String playerInput = scanner.nextLine().toUpperCase();

        if (playerInput.equalsIgnoreCase("Y")) {
            printTimePlayed();
            return true;
        } else return false;
        // TODO
    }


    public void printTimePlayed() {

        Duration duration = Duration.between(timeWhenGameStart, LocalTime.now());

        long minutesPlayed = duration.toMinutes();
        long hoursPlayed = duration.toHours();
        String hoursAndMinutesPlayed;

        if (hoursPlayed > 0) {
            hoursAndMinutesPlayed = hoursPlayed + " hour" + (hoursPlayed == 1 ? "" : "s") + " and ";
        } else {
            hoursAndMinutesPlayed = ""; // No hours, so leave this part empty
        }
        hoursAndMinutesPlayed += minutesPlayed + " minute" + (minutesPlayed == 1 ? "" : "s");

        System.out.print("\n\n" + ConsoleColors.YELLOW_BRIGHT + "You have wasted " + ConsoleColors.CYAN_BRIGHT +
                hoursAndMinutesPlayed + ConsoleColors.YELLOW_BRIGHT + " playing this stupid game." +
                ConsoleColors.CYAN_BRIGHT + " :)" + ConsoleColors.RESET);
    }

    public void printWeaponsArraylistInOrder(ArrayList<Weapon> weapons) {
        weapons.sort(new WeaponDamageComparator());
        for (Weapon weapon : weapons) {
            System.out.println(weapon);
        }
    }

    public void printEnemiesArraylistInOrder(ArrayList<Enemy> enemies) {
        enemies.sort(new EnemyHealthComparator());
        for (Enemy enemy : enemies) {
            System.out.println(enemy);
        }
    }

    public void invalidInput() {
        //TODO
    }


    public void playerMessage1(String playerName) {
        System.out.print(ConsoleColors.YELLOW_BRIGHT + "You wake up feeling very disoriented. ");
        sleepForTwoSeconds();
        System.out.print("Something is pounding in the back of your head. ");
        sleepForOneSecond();
        System.out.print("You realize it simply is a massive BULE. ");
        sleepForTwoSeconds();
        System.out.print("As you struggle to try and remember you hear a old and crisp voice:\n\n");
        sleepForOneSecond();
        System.out.print(ConsoleColors.CYAN_BRIGHT + "Oh dear. It's a miracle you're still alive. " +
                "What is your name?\n\n" + ConsoleColors.RESET);

        playerName = selectName();

        System.out.println(ConsoleColors.CYAN_BRIGHT + "\nYou should be very thankful " + playerName + "! ");
        sleepForOneSecond();

    }

    public String selectName() { // TODO
        String playerName = null;
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "1. My name is Micheal\n2. I am Hisha\n" +
                "3. Howdy partner. I am Bobb\n4. Hello mister my name is Kim.\n5. Me name Jeff\n6. I am Null" +
                ConsoleColors.RESET);
        int playerInput = scanner.nextInt();
        switch (playerInput) {
            case 1 -> playerName = "Micheal";
            case 2 -> playerName = "Hisha";
            case 3 -> playerName = "Bobb";
            case 4 -> playerName = "Kim";
            case 5 -> playerName = "Jeff";
            case 6 -> playerName = "Null";
        }
        return playerName;
    }

    // ------------------ MENU'S ------------------
    public String printMainMenuHeader() {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "MAIN MENU" + ConsoleColors.RESET;
    }

    public String printMovementMenuHeader() {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "MOVEMENT MENU" + ConsoleColors.RESET;
    }

    public String printCombatMenuHeader() {
        return ConsoleColors.MENU_COLOR_SANDY_BROWN + "COMBAT MENU" + ConsoleColors.RESET;
    }

    public String[] combatMenuPoints(int calculatedChanceToEscape) { // TODO
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "1. Attack.", "2. Attempt to flee. (" +
                calculatedChanceToEscape + ")", "9. Show all available information.", "0. Rage quit." + ConsoleColors.RESET};
    }

    public String[] mainMenuPoints() {
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "1. Start game.", "9. Show tutorial.",
                "0. Quit game." + ConsoleColors.RESET};
    }

    public String[] movementMenuPoints() {
        return new String[]{ConsoleColors.MENU_COLOR_SANDY_BROWN + "1. Move north.", "2. Move east.", "3. Move south.",
                "4. Move west.\n", "5. See player position.", "9. Show all available information.", "0. Quit." + ConsoleColors.RESET};
    }
    // ------------------ SLEEP-TIMERS ------------------

    void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void cannotMoveFurtherWestMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
    }

    void sleepForHalfASecond() {
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

    public void printAvailableInfo(int playerLevel, int playerHealthPoints, int playerAgility,
                                   int playerIntelligence, int playerStamina, int playerStrength, int playerPositionX,
                                   int playerPositionY, int enemiesKilled, String weaponDetails, String armorDetails) {

        String playerLevelString = ConsoleColors.LIGHT_GOLD + playerLevel + ConsoleColors.YELLOW_BRIGHT;
        String playerHealthPointsString = ConsoleColors.SEA_GREEN + playerHealthPoints + ConsoleColors.YELLOW_BRIGHT;
        String playerAgilityString = ConsoleColors.LIGHT_GOLD + playerAgility + ConsoleColors.YELLOW_BRIGHT;
        String playerIntelligenceString = ConsoleColors.LIGHT_GOLD + playerIntelligence + ConsoleColors.YELLOW_BRIGHT;
        String playerStaminaString = ConsoleColors.LIGHT_GOLD + playerStamina + ConsoleColors.YELLOW_BRIGHT;
        String playerStrengthString = ConsoleColors.LIGHT_GOLD + playerStrength + ConsoleColors.YELLOW_BRIGHT;

        String playerInfo = String.format(
                ConsoleColors.YELLOW_BRIGHT + "Level: %-3s HP: %-4s AGI: %-3s INT: %-3s STM: %-3s STR: %-3s",
                playerLevelString, playerHealthPointsString, playerAgilityString, playerIntelligenceString,
                playerStaminaString, playerStrengthString);
        System.out.println(playerInfo);

//        weaponDetails.split("damage");

        //TODO KAN VARIABLERNE ALLEREDE VÆRE FARVEDE NÅR DE KOMMER?? ELLER FJERNER DET POINTEN MED UI KLASSEN?
        // TODO THINK I FUCKED UP WITH COLORING. HAVING BOTH IN TOSTRING AND HERE.

        System.out.println("Position: " + ConsoleColors.SALMON + playerPositionX + ConsoleColors.YELLOW_BRIGHT +
                ":" + ConsoleColors.SALMON + playerPositionY);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Weapon: " + weaponDetails);//"/"+ playerDamage+ ); // TODO HOW TO GET PLAYERDAMAGE IN HERE??
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Armor: " + armorDetails);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Enemies killed: " + ConsoleColors.SALMON + enemiesKilled
                + ConsoleColors.RESET); // TODO: Implement logic to count and display the number of enemies killed


        //TODO ARMOR
    }

    public void printPlayerPosition(int playerPositionX, int playerPositionY) {
        System.out.println((ConsoleColors.YELLOW_BRIGHT + "Position: " + ConsoleColors.SALMON + "X" +
                ConsoleColors.YELLOW_BRIGHT + " : " + ConsoleColors.SALMON + "Y " + playerPositionX +
                ConsoleColors.YELLOW_BRIGHT + " : " + ConsoleColors.SALMON + playerPositionY +
                ConsoleColors.RESET));
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

    public void displayDamageDealt(double playerDamage) {
        if (playerDamage == 1) {
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "You attack. You deal " + ConsoleColors.LIGHT_GOLD +
                    playerDamage + ConsoleColors.YELLOW_BRIGHT + " point of damage" + ConsoleColors.RESET);
        } else
            System.out.println(ConsoleColors.YELLOW_BRIGHT + "Your attack deals " + ConsoleColors.LIGHT_GOLD +
                    playerDamage + ConsoleColors.YELLOW_BRIGHT + " points of damage." + ConsoleColors.RESET);
    }

    public void gameOver() {
        System.out.println(ConsoleColors.RED_BRIGHT + "You died. Game over." + ConsoleColors.RESET);
    }

    public void printUnfitArmorMessage() {
        System.out.println(ConsoleColors.RED_BRIGHT + "You do not have the required STR to equip this!" +
                ConsoleColors.RESET);
    }
}
