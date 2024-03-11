package classes;

import enemies.EnemyCreator;
import enums.ArmorCondition;
import enums.WeaponType;

import Armor.Armor;
import Armor.PoorArmor;
import Armor.LegendaryArmor;

import weapons.Weapon;
import weapons.WeaponCreator;
import weapons.PoorWeapon;

public class Player {
    private String playerName;
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel = 1; // can never go below 1.
    private int playerAgility = 10;
    private int playerIntelligence = 10;
    private int playerStamina = 10;
    private int playerStrength = 10;
    private int playerHealthPoints = playerLevel * 5 + playerStamina * 3;
    private double playerDamage;
    private int escapeChance;
    private int enemiesKilled = 0;
    private double playerCurrency = 0;

    UI ui = new UI();
    Weapon playerWeapon = new PoorWeapon(WeaponType.DAGGER, "Poor dagger"); // START WEAPON
    private Armor playerArmor = new PoorArmor("Poor kilt"); // START ARMOR
    private WeaponCreator weaponCreator = new WeaponCreator();
    private EnemyCreator enemyCreator;
    private MapFrame mapFrame = MapFrame.getInstance();

    // ------------------ SETTERS ------------------

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerAgility(int playerAgility) {
        this.playerAgility = playerAgility;
    }

    public void setPlayerHealthPoints(int playerHealthPoints) {
        this.playerHealthPoints = playerHealthPoints;
    }

    public void setPlayerIntelligence(int playerIntelligence) {
        this.playerIntelligence = playerIntelligence;
    }

    public void setPlayerLevel(int playerLevel) {
        if (playerLevel > 0)
            this.playerLevel = playerLevel;
    }

    public void setPlayerStamina(int playerStamina) {
        this.playerStamina = playerStamina;
    }

    public void setPlayerStrength(int playerStrength) {
        this.playerStrength = playerStrength;
    }

    public void setPlayerWeapon(Weapon playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public void setEscapeChance(int escapeChance) {
        this.escapeChance = escapeChance;
    }

    public void setPlayerArmorCondition(ArmorCondition condition){
        playerArmor.setArmorCondition(condition);
    }

    // ------------------ GETTERS ------------------


    public String getPlayerName() {
        return playerName;
    }

    public int getEscapeChance() {
        return escapeChance;
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
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

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public double getPlayerDamage() {
        return playerDamage;
    }


    // ------------------ OTHER ------------------
    public void promptMakeMapVisible() {
        mapFrame.makeMapVisible();
    }

    public void promptMakeMapInvisible() {
        mapFrame.makeMapInvisible();
    }

    // ------------------ PLAYER RELATED ------------------

    public void equipNewArmor() {
        if (playerStrength >= playerArmor.getRequiredStrength()) {
            this.playerArmor = playerArmor;
        } else ui.printUnfitArmorMessage();
    }

    public void validatePlayerHealth() {
        if (playerHealthPoints <= 0) {
            ui.gameOver();
            //TODO LOGIC
//            gameRunning=false;
        }
    }


    public int calculatedPlayerDamage(double playerDamage) {
        playerDamage = playerWeapon.getCalculatedWeaponDamage() + playerLevel;
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
        return (int) Math.round(playerDamage);
        // TODO FORKERT? NEEDS UPDATE ALL THE TIME
    }

    public void flee() {
        // TODO GOTO LAST SQUARE WITH CALULATED RISK
    }

    public void moveNorth() {
        playerPositionY--;
        validatePlayerPosition();
        promptUpdatePlayerPosition();
    }

    public void moveSouth() {
        playerPositionY++;
        validatePlayerPosition();
        promptUpdatePlayerPosition();
    }

    public void moveEast() {
        playerPositionX++;
        validatePlayerPosition();
        promptUpdatePlayerPosition();
    }

    public void moveWest() {
        playerPositionX--;
        validatePlayerPosition();
        promptUpdatePlayerPosition();
    }

    public void setPlayerDamage(int playerDamage) {
        if (playerDamage > 0) {
            this.playerDamage = playerDamage;
        }
    }

    void promptAvailableInfo() {
        ui.printAvailableInfo(playerLevel, playerHealthPoints, playerAgility, playerIntelligence,
                playerStamina, playerStrength, playerPositionX, playerPositionY, enemiesKilled,
                playerWeapon.toString(), playerArmor.toString(), calculatedPlayerDamage(playerDamage));
    }

    public void promptPrintPlayerPosition() {
        ui.printPlayerPosition(playerPositionX, playerPositionY);
    }

    private void promptSelectName() {
        setPlayerName(ui.selectName());
    }

    public void validatePlayerPosition() {
        if (getPlayerPositionX() < 0) {
            setPlayerPositionX(0);
            ui.cannotMoveFurtherWestMessage();
        } else if (getPlayerPositionX() > 40) {
            setPlayerPositionX(40);
            ui.cannotMoveFurtherEastMessage();
        } else if (getPlayerPositionY() > 40) {
            setPlayerPositionY(40);
            ui.cannotMoveFurtherSouthMessage();
        } else if (getPlayerPositionY() < 0) {
            setPlayerPositionY(0);
            ui.cannotMoveFurtherNorthMessage();
        }
    }

    public void attack() {
        calculatedPlayerDamage(getPlayerDamage());
        ui.displayDamageDealt(playerDamage);
//      TODO  enemyHealth = enemyHealth - playerDamage;
    }

    public void promptUpdatePlayerPosition() {
        mapFrame.updatePlayerPosition(playerPositionX, playerPositionY);
    }

    public void promptPrintWeaponsArrayInOrder() {
        ui.printWeaponsArraylistInOrder(weaponCreator.getWeapons());
    }

    public void promptPrintEnemiesArrayInOrder() {
        ui.printEnemiesArraylistInOrder(enemyCreator.getEnemies());
    }

}
