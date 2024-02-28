package classes;

import comparators.EnemiesComparator;
import comparators.WeaponComparator;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    LocalTime timeWhenGameStart = LocalTime.now(); // TODO SKAL MÅSKE INSTACIERES FØR DEN "TÆLLER"?
    MapFrame worldMap;
    Player player = new Player();
    Main main; //TODO PROBLEMER HVIS INSTANCIERES INFINITE LOOP?
    Weapon weapon;
    private String playerName;


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


    boolean quitGame() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Are you sure you want to quit? (" + ConsoleColors.RED_BRIGHT +
                "Y" + ConsoleColors.YELLOW_BRIGHT + "/" + ConsoleColors.GREEN_BRIGHT + "N" +
                ConsoleColors.YELLOW_BRIGHT + ");" + ConsoleColors.RESET);

        String playerInput = scanner.nextLine().toUpperCase();

        if (playerInput.equalsIgnoreCase("Y")) {
            return true;
        } else return false;
        // TODO
    }

    void getAvailableInfo() {
        String playerInfo = String.format("Level: %-3d HP: %-4d AGI: %-3d INT: %-3d STM: %-3d STR: %-3d",
                player.getPlayerLevel(), player.getPlayerHealtPoints(),
                player.getPlayerAgility(), player.getPlayerIntelligence(),
                player.getPlayerStamina(), player.getPlayerStrength());
        System.out.println(playerInfo);

        System.out.println("Position: " + player.getPlayerPositionX() + ":" + player.getPlayerPositionY());

        // Assuming getPlayerWeapon() returns a String. If it's an object, you might need to call a method on it,
        // like player.getPlayerWeapon().getWeaponName()
        System.out.println("Weapon: " + player.getPlayerWeapon().getWeaponName() + " Damage: " +
                player.getPlayerWeapon().getCalculatedWeaponDamage());

        System.out.println("Enemies killed: "); // TODO: Implement logic to count and display the number of enemies killed

    }


    public void printTimePlayed() { // DONE

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

    public void invalidInput() {
        //TODO
    }

    public String printPlayerPosition() {
        return ("Position: " + ConsoleColors.YELLOW_BRIGHT + "X" + ConsoleColors.RESET + ": " +
                ConsoleColors.YELLOW_BRIGHT + player.getPlayerPositionX() + ConsoleColors.CYAN_BRIGHT + " Y" +
                ConsoleColors.RESET + ": " + ConsoleColors.CYAN_BRIGHT + player.getPlayerPositionY());
        //TODO ONLY RETURNS DONT PRINT.
    }

    public void validatePlayerPosition() {
        if (player.getPlayerPositionX() < 0) {
            player.setPlayerPositionX(0);
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
        } else if (player.getPlayerPositionX() > 40) {
            player.setPlayerPositionX(40);
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further east!" + ConsoleColors.RESET);
        } else if (player.getPlayerPositionY() > 40) {
            player.setPlayerPositionY(40);
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further south!" + ConsoleColors.RESET);
        } else if (player.getPlayerPositionY() < 0) {
            player.setPlayerPositionY(0);
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further north!" + ConsoleColors.RESET);
        }
    }

    public void attack() {
        player.calculatePlayerDamage(player.getPlayerDamage());
        if (player.getPlayerDamage() == 1) {
            System.out.println("You attack. You deal " + player.getPlayerDamage() + " point of damage");
        } else
            System.out.println("You attack. You deal " + player.getPlayerDamage() + " points of damage.");
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    private void selectName() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "1. My name is Micheal\n2. I am Hisha\n" +
                "3. Howdy partner. I am Bobb\n4. Hello mister my name is Kim.");
        int playerInput = scanner.nextInt();
        switch (playerInput){
            case 1 -> playerName = "Micheal";
            case 2 -> playerName = "Hisha";
            case 3 -> playerName = "Bobb";
            case 4 -> playerName = "Kim";
        }

    }
}
