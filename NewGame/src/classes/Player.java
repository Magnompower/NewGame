package classes;

import armor.ArmorCreator;
import enemies.EnemyCreator;
import enums.ArmorCondition;
import enums.WeaponCondition;
import enums.WeaponType;

import armor.Armor;
import armor.PoorArmor;

import weapons.Weapon;
import weapons.WeaponCreator;
import weapons.PoorWeapon;

public class Player {
    private String playerName;
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel = 1; // can never go below 1.
    private int playerAgility = 6;
    private int playerIntelligence = 6;
    private int playerStamina = 6;
    private int playerStrength = 6;
    private int playerHealthPoints = playerLevel * 5 + playerStamina * 3 + 7;
    private int playerDamage;
    private int escapeChance;
    private int enemiesKilled = 0;
    private int playerAmountOfCoins = 0;
    private int playerExperiencePoints; // XP needed to lvl = base(100) * level * level (100 lvl 1, 10000 lvl 10)

    UI ui = new UI();
    Weapon playerWeapon = new PoorWeapon(WeaponType.DAGGER, "Poor dagger"); // START WEAPON
    private Armor playerArmor = new PoorArmor("Poor kilt"); // START ARMOR
    private WeaponCreator weaponCreator = new WeaponCreator();
    private EnemyCreator enemyCreator;
    private MapFrame mapFrame = MapFrame.getInstance();
    private ArmorCreator armorCreator;

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

    public void setPlayerArmorCondition(ArmorCondition condition) {
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

    public void checkPlayerLevel() {
        switch (playerExperiencePoints) {
            case 100 -> playerLevel = 2;
//            case 400 -> playerLevel = 3;
//            case 900 -> playerLevel =4;
        }
    }

    public void calculatePlayerHealth() {
        playerHealthPoints = playerLevel * 5 + playerStamina * 3 + 7; // TODO MAKE BOTH ACTUAL AND MAXIMUM
    }

    public int calculatedPlayerDamage(double playerDamage) {
        playerDamage = playerWeapon.getActualWeaponDamage() + playerLevel;
        if (playerWeapon.getWeaponType().equals("STR")) {
            playerDamage = playerDamage + (double) playerStrength / 2;
        }
        if (playerWeapon.getWeaponType().equals("AGI")) {
            playerDamage = playerDamage + (double) playerAgility / 2;
        }
        if (playerWeapon.getWeaponType().equals("INT")) {
            playerDamage = playerDamage + (double) playerIntelligence / 2;
        }
        setPlayerDamage((int) Math.round(playerDamage));
        return (int) playerDamage;
        // TODO FORKERT? NEED VOID? NEEDS UPDATE ALL THE TIME
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

    public void promptAvailableInfo() {
        ui.printAvailableInfo(toString(), calculatedPlayerDamage(playerDamage), getPlayerPositionX(), getPlayerPositionY(),
                playerWeapon.toString(), playerArmor.toString(), enemiesKilled);
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

    public String sharpenWeapon() {
        switch (playerWeapon.getWeaponCondition()) { // Cannot sharpen a broken weapon.
            case RUSTY -> playerWeapon.setWeaponCondition(WeaponCondition.NORMAL); // TODO SOUT WEAPON STATUS!
            case NORMAL -> playerWeapon.setWeaponCondition(WeaponCondition.POLISHED);
            case POLISHED -> playerWeapon.setWeaponCondition(WeaponCondition.SHARP);
        }
        return playerWeapon.getWeaponCondition().getWeaponConditionText();
    }

    public void repairArmor() { // TODO NAAMING: ARMOR MAINTANINCE?!
        switch (playerArmor.getArmorCondition()) { //TODO CAN YOU REPAIR BROKEN ARMOR?!?
            case BROKEN -> playerArmor.setArmorCondition(ArmorCondition.NORMAL);
            case DIRTY -> playerArmor.setArmorCondition(ArmorCondition.NORMAL); //TODO SOUT STATUS
            case NORMAL -> playerArmor.setArmorCondition(ArmorCondition.POLISHED);
            case POLISHED -> playerArmor.setArmorCondition(ArmorCondition.REINFORCED);
        }
    }

    public void promptUpdatePlayerPosition() {
        mapFrame.updatePlayerPosition(playerPositionX, playerPositionY);
    }

    public void promptPrintWeaponsArrayInOrder() {
        ui.printWeaponsArraylistInOrder(weaponCreator.getWeaponsCopyArraylistInOrder());
    }

    public void promptPrintEnemiesArrayInOrder() {
        ui.printEnemiesArraylistInOrder(enemyCreator.getEnemiesCopyArraylistInOrder());
    }
    public void promptPrintArmoryArrayInOrder(){
        ui.printArmorArrayListInOrder(armorCreator.getArmouryCopyArraylistInOrder());
    }

    @Override
    public String toString() {

        String playerLevelString = ConsoleColors.LIGHT_GOLD + playerLevel + ConsoleColors.YELLOW_BRIGHT;
        String playerHealthPointsString = ConsoleColors.SEA_GREEN + playerHealthPoints + ConsoleColors.YELLOW_BRIGHT;
        String playerAgilityString = ConsoleColors.LIGHT_GOLD + playerAgility + ConsoleColors.YELLOW_BRIGHT;
        String playerIntelligenceString = ConsoleColors.LIGHT_GOLD + playerIntelligence + ConsoleColors.YELLOW_BRIGHT;
        String playerStaminaString = ConsoleColors.LIGHT_GOLD + playerStamina + ConsoleColors.YELLOW_BRIGHT;
        String playerStrengthString = ConsoleColors.LIGHT_GOLD + playerStrength + ConsoleColors.YELLOW_BRIGHT;

        String playerDetails = String.format(ConsoleColors.YELLOW_BRIGHT +
                        "Level: %-3s HP: %-4s AGI: %-3s INT: %-3s STM: %-3s STR: %-3s",
                playerLevelString, playerHealthPointsString, playerAgilityString,
                playerIntelligenceString, playerStaminaString, playerStrengthString);

        return playerDetails;
    }
}
