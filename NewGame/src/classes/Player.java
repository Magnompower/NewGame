package classes;

public class Player {
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel=1;
    private int playerStrength = 10;
    private int playerIntelligence = 10;
    private int playerAgility = 10;
    private int playerStamina = 10;
    private int playerHealtPoints = playerLevel * 5 +playerStamina*3;
    Weapon playerWeapon;
    private int playerDamage;



    public void validatePlayerHealth() {
        if (playerHealtPoints <= 0) {
//            gamerunning=false;
        }
    }

    public int calculatePlayerDamage(int playerDamage) {
        playerDamage = playerLevel + playerWeapon.getCalculatedWeaponDamage();
        if (playerWeapon.getWeaponType().equals("STR")) {
            playerDamage = playerDamage + playerStrength / 2;
        }
        if (playerWeapon.getWeaponType().equals("AGI")) {
            playerDamage = playerDamage + playerAgility / 2;
        }
        if (playerWeapon.getWeaponType().equals("INT")) {
            playerDamage = playerDamage + playerIntelligence / 2;
        }
        return playerDamage;
    }

    public void attack() {
        calculatePlayerDamage(playerDamage);
        System.out.println("You attack. You deal " + playerDamage + " points of damage.");

    }

    public void flee() {
    }

    public void moveNorth() {
        playerPositionY++;
        validatePlayerPosition();
    }

    public void moveSouth() {
        playerPositionY--;
        validatePlayerPosition();
    }

    public void moveEast() {
        playerPositionX++;
        validatePlayerPosition();
    }

    public void moveWest() {
        playerPositionX--;
        validatePlayerPosition();
    }

    public void printPlayerPosition() {
        System.out.println("Position: " + ConsoleColors.YELLOW_BRIGHT + "X" + ConsoleColors.RESET + ": " +
                ConsoleColors.YELLOW_BRIGHT + playerPositionX + ConsoleColors.CYAN_BRIGHT + " Y" +
                ConsoleColors.RESET + ": " + ConsoleColors.CYAN_BRIGHT + playerPositionY);
    }

    public void validatePlayerPosition() {
        if (playerPositionX < 0) {
            playerPositionX = 0;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
        } else if (playerPositionX > 40) {
            playerPositionX = 40;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further east!" + ConsoleColors.RESET);
        } else if (playerPositionY < 0) {
            playerPositionY = 0;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further south!" + ConsoleColors.RESET);
        } else if (playerPositionY > 40) {
            playerPositionY = 40;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further north!" + ConsoleColors.RESET);
        }
    }
}
