package classes;

import enums.WeaponRarity;
import enums.WeaponType;

public class Player {
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel = 1;
    private int playerStrength = 10;
    private int playerIntelligence = 10;
    private int playerAgility = 10;
    private int playerStamina = 10;
    private int playerHealtPoints = playerLevel * 5 + playerStamina * 3;
    Weapon playerWeapon = new Weapon(WeaponRarity.UNCOMMON, WeaponType.TWOHANDEDSWORD,"Uncommon longsword");
    private int playerDamage;
//    UI ui = new UI();


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
        setPlayerDamage(playerDamage);
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

    public Weapon getPlayerWeapon() {
        return playerWeapon;
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
}
