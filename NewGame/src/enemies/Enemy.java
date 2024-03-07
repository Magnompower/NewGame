package enemies;

import classes.ConsoleColors;

public abstract class Enemy {
    private String enemyName;
    private double enemyAttackDamage;
    private double enemyHealthPoints;
    private String enemyColor;

    public Enemy(String enemyName) {
        this.setEnemyName(enemyName);
    }

    // ------------------ SETTERS ------------------

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyAttackDamage(double enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public void setEnemyHealthPoints(double enemyHealthPoints) {
        this.enemyHealthPoints = enemyHealthPoints;
    }

    public void setEnemyColor(String enemyColor) {
        this.enemyColor = enemyColor;
    }

    // ------------------ GETTERS ------------------

    public String getEnemyName() {
        return enemyName;
    }

    public double getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public double getEnemyHealthPoints() {
        return enemyHealthPoints;
    }

    public String getEnemyColor() {
        return enemyColor;
    }

    @Override
    public String toString() {

        String colorCodeEnemy = getEnemyColor();
        String colorCodeDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeHealth = ConsoleColors.SEA_GREEN;

        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT;
        String colorCodeReset = ConsoleColors.RESET;

        int calculatedEnemyDamage = (int) Math.round(getEnemyAttackDamage());
        int calculatedEnemyHealthPoints = (int) Math.round(getEnemyHealthPoints());

        return colorCodeEnemy + enemyName + colorCodeNormalText + ": " + colorCodeHealth + calculatedEnemyHealthPoints
                + colorCodeNormalText + " : " + colorCodeDamage + calculatedEnemyDamage + colorCodeReset;
    }
}