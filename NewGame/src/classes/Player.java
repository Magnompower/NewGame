package classes;

import armor.ArmorCondition;
import armor.ArmorCreator;
import armor.inheritance.Armor;
import enemies.EnemyCreator;
import enemies.inheritance.Enemy;
import ui.ConsoleColors;
import ui.UI;
import weapons.WeaponCondition;
import weapons.WeaponCreator;
import weapons.WeaponType;
import weapons.inheritance.Weapon;

import java.util.EnumSet;
import java.util.Set;


public class Player {

    UI ui = new UI(); // TODO MAKING new everywhere is bad?
    Weapon playerWeapon;
    private Armor playerArmor;
    private WeaponCreator weaponCreator;
    private EnemyCreator enemyCreator;
    private ArmorCreator armorCreator;
    private Enemy enemy; // TODO INSTANCIERERING
    private String playerName;
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel = 1; // Start value.
    private int playerAgility = 6; // Start value.
    private int playerIntelligence = 6; // Start value.
    private int playerStamina = 6; // Start value.
    private int playerStrength = 6; // Start value.
    private int playerHealthPoints = playerLevel * 5 + playerStamina * 3 + 7;
    private int playerDamage;
    private int escapeChancePercentage;
    private int enemiesKilled = 0; // Start value.
    private int playerAmountOfCoins = 0; // Start value.
    private int playerExperiencePoints; // XP needed to lvl = base(100) * level * level (100 lvl 1, 10000 lvl 10)


    // ------------------ SETTERS ------------------


    public void setPlayerArmor(Armor playerArmor) {
        if (playerStrength >= playerArmor.getRequiredStrength()) {
            this.playerArmor = playerArmor;
        } else ui.printNotEnoughtStrengthToEquipArmorMessage(playerStrength, playerArmor.getRequiredStrength(),
                playerArmor.getArmorName(), playerArmor.getArmorColor());
    }

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

    public void setPlayerWeaponCondition(WeaponCondition condition) {
        playerWeapon.setWeaponCondition(condition);
    }

    public void setEscapeChancePercentage(int escapeChancePercentage) {
        this.escapeChancePercentage = escapeChancePercentage;
    }

    public void setPlayerArmorCondition(ArmorCondition condition) {
        playerArmor.setArmorCondition(condition);
    }

    // ------------------ GETTERS ------------------

    public Weapon getPlayerWeapon() {
        return playerWeapon;
    }

    public Armor getPlayerArmor() {
        return playerArmor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getEscapeChancePercentage() {
        calculateEscapeChancePercentage();
        return escapeChancePercentage;
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

    public int getPlayerDamage() {
        return playerDamage;
    }


    // ------------------ OTHER ------------------


    // ------------------ PLAYER RELATED ------------------

    public boolean validatePlayerHealth() {
        if (playerHealthPoints <= 0) {
            ui.gameOver();
            return false; // Set gameRunning
        } else return true; // Set gameRunning

    }

    public Boolean evaluateCombat() {
        if (enemy.getEnemyHealthPoints() <= 0) {
            return false;
        } else return true;
    }

    public void checkPlayerLevel() {
        switch (playerExperiencePoints) {
            case 100 -> playerLevel = 2;
//            case 400 -> playerLevel = 3;
//            case 900 -> playerLevel =4;
        }
    }

    public void calculatePlayerHealth() {
        playerHealthPoints = playerHealthPoints - calculatePlayerDamageTaken();
        validatePlayerHealth();
    }

    public int calculatePlayerDamageTakenPercentage() {// TODO USE AND SEND TO UI
        Set<WeaponType> oneHandedWeaponTypes = EnumSet.of(WeaponType.ONEHANDED_AXE, WeaponType.ONEHANDED_DAGGER,
                WeaponType.ONEHANDED_MACE, WeaponType.ONEHANDED_SWORD);

        int calculatedDamageTakenPercentage;
        calculatedDamageTakenPercentage = playerArmor.calculateDamageReductionPercentage() - playerAgility / 2;
        if (oneHandedWeaponTypes.contains(playerWeapon.getWeaponType())) {

            calculatedDamageTakenPercentage = calculatedDamageTakenPercentage - 10; // Take 10% less dmg with shield.
        }

        return calculatedDamageTakenPercentage;
    }

    public int calculatePlayerDamageTaken() {
        int calculatedEnemyDamage;
        calculatedEnemyDamage = (int) Math.floor(enemy.getEnemyAttackDamage() * calculatePlayerDamageTakenPercentage());
        return calculatedEnemyDamage;
    }

    public void promptPrintEnemyAttack() {
        String enemyNameColored = enemy.getEnemyColor() + enemy.getEnemyName();
        ui.printEnemyAttack(enemyNameColored, calculatePlayerDamageTaken());
    } // TODO FLYT TIL ENEMEY?!

    public void calculateEscapeChancePercentage() { // TODO Logic
        escapeChancePercentage = playerLevel * 10 - (int) Math.floor(enemy.getEnemyAttackDamage()) * 8;
        if (escapeChancePercentage > 100) {
            setEscapeChancePercentage(100);
        }
        // if bossenemy escapechance + 20 TODO
        if (escapeChancePercentage < 40) {
            setEscapeChancePercentage(40);
        } else setEscapeChancePercentage(escapeChancePercentage);
    }

    public int calculatePlayerDamage() { //TODO METODEN KAN RAFINERERS
        int calcualtedPlayerDamage;
        calcualtedPlayerDamage = playerWeapon.getWeaponDamage() + playerLevel * 2;
        if (playerWeapon.getWeaponType().getModifier().equals("STR")) {
            calcualtedPlayerDamage = calcualtedPlayerDamage + playerStrength / 2;
        }
        if (playerWeapon.getWeaponType().getModifier().equals("AGI")) {
            calcualtedPlayerDamage = calcualtedPlayerDamage + playerAgility / 2;
        }
        if (playerWeapon.getWeaponType().getModifier().equals("INT")) {
            calcualtedPlayerDamage = calcualtedPlayerDamage + playerIntelligence / 2;
        }
        setPlayerDamage(calcualtedPlayerDamage);
        return calcualtedPlayerDamage;
        // TODO FORKERT? NEED VOID? NEEDS UPDATE ALL THE TIME
    }

    public void flee() {
        // TODO GOTO LAST SQUARE WITH CALULATED RISK
    }

    public void moveNorth() {
        playerPositionY--;
        validatePlayerPosition();
//        promptUpdatePlayerPosition();
    }

    public void moveSouth() {
        playerPositionY++;
        validatePlayerPosition();
//        promptUpdatePlayerPosition();
    }

    public void moveEast() {
        playerPositionX++;
        validatePlayerPosition();
//        promptUpdatePlayerPosition();
    }

    public void moveWest() {
        playerPositionX--;
        validatePlayerPosition();
//        promptUpdatePlayerPosition();
    }

    public void setPlayerDamage(int playerDamage) {
        if (playerDamage > 0) {
            this.playerDamage = playerDamage;
        }
    }

    public void promptPrintAvailableInfo() {
        ui.printAvailableInfo(toString(), calculatePlayerDamage(), getPlayerPositionX(), getPlayerPositionY(),
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
        calculatePlayerDamage();
        enemy.setEnemyHealthPoints(enemy.getEnemyHealthPoints() - playerDamage);
        ui.displayDamageDealt(getPlayerDamage(), enemy.getEnemyHealthPoints(), enemy.getEnemyMaxHealthPoints()); //TODO
//      TODO  enemyHealth = enemyHealth - playerDamage;
    }

    public void sharpenWeapon() {
        switch (playerWeapon.getWeaponCondition()) { // Cannot sharpen a broken weapon.
            case BROKEN -> promptPrintCannotSharpenBrokenWeapon();
            case RUSTY -> playerWeapon.setWeaponCondition(WeaponCondition.NORMAL); // TODO SOUT WEAPON STATUS!
            case NORMAL -> playerWeapon.setWeaponCondition(WeaponCondition.POLISHED);
            case POLISHED -> playerWeapon.setWeaponCondition(WeaponCondition.SHARP);
            case SHARP -> promptPrintCannotSharpenAnyFurther();
        }
        ui.printNewWeaponCondition(playerWeapon.getWeaponCondition().getWeaponConditionText(),
                playerWeapon.getWeaponCondition().getWeaponConditionColor());
    }

    public void repairAndCleanArmor() { // TODO NAAMING: ARMOR MAINTANINCE?!
        switch (playerArmor.getArmorCondition()) { //TODO CAN YOU REPAIR BROKEN ARMOR?!?
//            case BROKEN -> promptPrintCannotRepairBrokenArmor();
            case DIRTY -> playerArmor.setArmorCondition(ArmorCondition.NORMAL); //TODO SOUT STATUS
            case NORMAL -> playerArmor.setArmorCondition(ArmorCondition.POLISHED);
            case POLISHED -> playerArmor.setArmorCondition(ArmorCondition.REINFORCED);
            case REINFORCED -> promptPrintCannotRepairArmorAnyFurther();
        }
        ui.printNewArmorCondition(playerArmor.getArmorCondition().getArmorConditionText(),
                playerArmor.getArmorCondition().getArmorConditionColor());

    }

    private void promptPrintCannotSharpenBrokenWeapon() {
        ui.printCannotSharpenBrokenWeapon(playerWeapon.getWeaponCondition().getWeaponConditionText(),
                playerWeapon.getWeaponCondition().getWeaponConditionColor());
    }

    private void promptPrintCannotRepairArmorAnyFurther() {
        ui.printCannotRepairArmorAnyFurther(playerArmor.getArmorCondition().getArmorConditionText(),
                playerArmor.getArmorCondition().getArmorConditionColor());
    }

//    public void promptUpdatePlayerPosition() {        uiMapFrame.promptUpdatePlayerPosition(playerPositionX, playerPositionY);    }

    public void promptPrintWeaponsArrayInOrder() {
        ui.printWeaponsArraylistInOrder(weaponCreator.getWeaponsCopyArraylistInOrder());
    }

    public void promptPrintEnemiesArrayInOrder() {
        ui.printEnemiesArraylistInOrder(enemyCreator.getEnemiesCopyArraylistInOrder());
    }

    public void promptPrintArmoryArrayInOrder() {
        ui.printArmorArrayListInOrder(armorCreator.getArmorPiecesCopyArraylistInOrder());
    }


    private void promptPrintCannotSharpenAnyFurther() {
        ui.PrintCannotSharpenWeaponFurther(playerWeapon.getWeaponCondition().getWeaponConditionText(),
                playerWeapon.getWeaponCondition().getWeaponConditionColor());
    }

    @Override
    public String toString() {

        String playerLevelString = ConsoleColors.LIGHT_GOLD + playerLevel + ConsoleColors.YELLOW_BRIGHT;
        String playerHealthPointsString = ConsoleColors.SEA_GREEN + playerHealthPoints + ConsoleColors.YELLOW_BRIGHT;
        String playerAgilityString = ConsoleColors.LIGHT_GOLD + playerAgility + ConsoleColors.YELLOW_BRIGHT;
        String playerIntelligenceString = ConsoleColors.LIGHT_GOLD + playerIntelligence + ConsoleColors.YELLOW_BRIGHT;
        String playerStaminaString = ConsoleColors.LIGHT_GOLD + playerStamina + ConsoleColors.YELLOW_BRIGHT;
        String playerStrengthString = ConsoleColors.LIGHT_GOLD + playerStrength + ConsoleColors.YELLOW_BRIGHT;

        return String.format(ConsoleColors.YELLOW_BRIGHT +
                        "Level: %-3s HP: %-4s AGI: %-3s INT: %-3s STM: %-3s STR: %-3s",
                playerLevelString, playerHealthPointsString, playerAgilityString,
                playerIntelligenceString, playerStaminaString, playerStrengthString);
    }
}
