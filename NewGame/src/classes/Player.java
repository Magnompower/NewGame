package classes;

import enums.WeaponType;
import weapons.Weapon;

public class Player {
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel = 1;
    private int playerStrength = 10;
    private int playerIntelligence = 10;
    private int playerAgility = 10;
    private int playerStamina = 10;
    private int playerHealtPoints = playerLevel * 5 + playerStamina * 3;
    private double playerDamage;

    UI ui = new UI();
    private Weapon playerWeapon;


    public void validatePlayerHealth() {
        if (playerHealtPoints <= 0) {
//            gamerunning=false;
        }
    }

    public int calculatePlayerDamage(double playerDamage) {
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
        setPlayerDamage((int) Math.round(playerDamage));
        return playerDamage;
        // TODO FORKERT?
    }


    public void flee() {
    }

    public void moveNorth() {
        playerPositionY--;
        ui.validatePlayerPosition();
    }

    public void moveSouth() {
        playerPositionY++;
        ui.validatePlayerPosition();
    }

    public void moveEast() {
        playerPositionX++;
        ui.validatePlayerPosition();
    }

    public void moveWest() {
        playerPositionX--;
        ui.validatePlayerPosition();
    }

    public void setPlayerWeapon(Weapon playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public int getPlayerDamage() {
        return playerDamage;
    }

    public void setPlayerDamage(int playerDamage) {
        if (playerDamage > 0) {
            this.playerDamage = playerDamage;
        }
    }

    public int getPlayerHealtPoints() {
        return playerHealtPoints;
    }

    public int getPlayerAgility() {
        return playerAgility;
    }

    public int getPlayerIntelligence() {
        return playerIntelligence;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getPlayerStamina() {
        return playerStamina;
    }

    public int getPlayerStrength() {
        return playerStrength;
    }

    public void setPlayerAgility(int playerAgility) {
        this.playerAgility = playerAgility;
    }

    public void setPlayerHealthPoints(int playerHealthPoints) {
        this.playerHealtPoints = playerHealthPoints;
    }

    public void setPlayerIntelligence(int playerIntelligence) {
        this.playerIntelligence = playerIntelligence;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public void setPlayerStamina(int playerStamina) {
        this.playerStamina = playerStamina;
    }

    public void setPlayerStrength(int playerStrength) {
        this.playerStrength = playerStrength;
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
    public String printPlayerPosition() {
        return ("Position: " + ConsoleColors.YELLOW_BRIGHT + "X" + ConsoleColors.RESET + ": " +
                ConsoleColors.YELLOW_BRIGHT + player.getPlayerPositionX() + ConsoleColors.CYAN_BRIGHT + " Y" +
                ConsoleColors.RESET + ": " + ConsoleColors.CYAN_BRIGHT + player.getPlayerPositionY());
        //TODO ONLY RETURNS DONT PRINT.
    }
    public void validatePlayerPosition() {
        if (player.getPlayerPositionX() < 0) {
            player.setPlayerPositionX(0);
            ui.cannotMoveFurtherWestMessage();
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
}
