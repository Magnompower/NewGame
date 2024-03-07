package classes;

import comparators.EnemyDamageComparison;
import comparators.WeaponDamageComparator;
import enemies.Enemy;
import enemies.EnemyCreator;
import weapons.Weapon;
import weapons.WeaponCreator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    LocalTime timeWhenGameStart = LocalTime.now(); // TODO SKAL MÅSKE INSTACIERES FØR DEN "TÆLLER"?
    WeaponCreator weaponCreator;
    EnemyCreator enemyCreator;


    private void openMap() {
        System.out.println(worldMap);
    }

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
        System.out.println(ConsoleColors.CYAN_BRIGHT + "JUSTICE" + ConsoleColors.RESET);
    }


    boolean wantToQuitGame() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Are you sure you want to quit? (" + ConsoleColors.RED_BRIGHT +
                "Y" + ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.GREEN_BRIGHT + "N" +
                ConsoleColors.YELLOW_BRIGHT + ");" + ConsoleColors.RESET);

        String playerInput = scanner.nextLine().toUpperCase();

        if (playerInput.equalsIgnoreCase("Y")) {
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

    private void printWeaponsArrayInOrder() {
        weaponCreator.getWeapons().sort(new WeaponDamageComparator());
        for (Weapon weapon : weaponCreator.getWeapons()) {
            System.out.println(weapon);

        }
    }

    private void printEnemiesArrayInOrder(){
        enemyCreator.getEnemies().sort(new EnemyDamageComparison());
        for (Enemy enemy : enemyCreator.getEnemies()){
            System.out.println(enemy);
        }
    }

    public void invalidInput() {
        //TODO
    }


    public void playerMessage1() {
        System.out.print(ConsoleColors.YELLOW_BRIGHT + "You wake up feeling very disoriented. ");
        sleepForOneSecond();
        System.out.print("Something is pounding in the back of your head.");
        sleepForHalfASecond();
        System.out.print("You realize it simply is a massive BULE. ");
        sleepForHalfASecond();
        System.out.print("As you struggle to try and remember you hear a old and crisp voice:\n");
        sleepForOneSecond();
        System.out.print(ConsoleColors.CYAN_BRIGHT + "Oh dear. It's a miracle you're still alive. " +
                "What is your name?" + ConsoleColors.RESET);
        sleepForOneSecond();

        selectName();
    }

    public String selectName() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "1. My name is Micheal\n2. I am Hisha\n" +
                "3. Howdy partner. I am Bobb\n4. Hello mister my name is Kim.\n5. Me name Jeff");
        int playerInput = scanner.nextInt();
        switch (playerInput) {
            case 1 -> playerName = "Micheal";
            case 2 -> playerName = "Hisha";
            case 3 -> playerName = "Bobb";
            case 4 -> playerName = "Kim";
            case 5 -> playerName = "Jeff";
        }
        return playerName;
    }
    // ------------------ MENU'S ------------------

    public void cannotMoveFurtherWestMessage() {
        System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
    }

    public String[] combatMenuPoints() {
        return new String[]{"1. Attack.", "2. Attempt to flee. (" + calculatedChanceToEscape + ")",
                "9. Show available information.", "0. Rage quit."};
    }

    public String[] mainMenuPoints() {
        return new String[]{"1. Start game.", "9. Show tutorial", "0. Quit game"};
    }

    public String[] movementMenuPoints() {
        return new String[]{"1. Move north.", "2. Move east.", "3. Move south.", "4. Move west.", "5. See player position",
                "9. Show available information.", "0. Quit."};
    }
    // ------------------ SLEEP-TIMERS ------------------

    void sleepForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void sleepForHalfASecond() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
