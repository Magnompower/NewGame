package classes;

import comparators.EnemiesComparator;
import comparators.WeaponComparator;

import java.time.LocalTime;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    LocalTime timeWhenGameStart = LocalTime.now();
    MapFrame worldMap;
    Player player = new Player();
    Main main; //TODO PROBLEMER HVIS INSTANCIERES INFINITE LOOP?


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
        sleepForOneSecond();
        System.out.println(ConsoleColors.CYAN_BRIGHT + "JUSTICE" + ConsoleColors.RESET);
    }


    boolean quitGame() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Are you sure you want to quit? (" + ConsoleColors.RED_BRIGHT +
                "Y" + ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.GREEN_BRIGHT + "N" +
                ConsoleColors.YELLOW_BRIGHT + ");" + ConsoleColors.RESET);
        scanner.nextLine().toUpperCase();
        if (scanner.equals("Y")) {
            return false;
        } else return true;
//        else menu.movementMenu();
    }

    void getAvailableInfo() {
        System.out.println(player.playerWeapon.getWeaponName());

    }

    private void printTimePlayed() {

        int timePlayed = LocalTime.now().compareTo(timeWhenGameStart);
        if (timePlayed == 1) {
            timePlayed = 2;
        }
        System.out.println("\n\n" + ConsoleColors.YELLOW_BRIGHT + "You have wasted " + ConsoleColors.CYAN_BRIGHT +
                timePlayed + ConsoleColors.YELLOW_BRIGHT + " minutes playing this stupid game." +
                ConsoleColors.CYAN_BRIGHT + " :)" + ConsoleColors.RESET);
    }

    private void printWeaponsArrayInOrder() {
        main.weapons.sort(new WeaponComparator());
        for (Weapon weapon : main.weapons) {
            System.out.println(weapon);

        }
    }

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

    private void printEnemiesArrayInOrder() {
        main.enemies.sort(new EnemiesComparator());
        for (Enemy enemy : main.enemies) {
            System.out.println(enemy);
        }
    }
}
