package enemies.inheritance;

import ui.ConsoleColors;

public abstract class Enemy {
    private String enemyName;
    private double enemyAttackDamage;
    private double enemyHealthPoints;
    private int baseExperiencePointsGranted = 100;
    private String enemyColor;
    private int actualExperiencePointsGrated = (int) Math.floor(baseExperiencePointsGranted*getEnemyAttackDamage());

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

    public void setBaseExperiencePointsGranted(int baseExperiencePointsGranted) {
        this.baseExperiencePointsGranted = baseExperiencePointsGranted;
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

    // ------------------ OTHER ------------------

   /* public void calculateEnemyExperiencePointsGranted() {
        switch ((int) getEnemyHealthPoints()) {
            case 20 -> actualExperiencePointsGrated = (int) Math.floor(baseExperiencePointsGranted*getEnemyAttackDamage());
            case 40 -> actualExperiencePointsGrated = (int) Math.floor(baseExperiencePointsGranted*getEnemyAttackDamage());
        }
    }*///TODO STUPID WAY TO DO IT?

    @Override
    public String toString() {

        String colorCodeEnemy = getEnemyColor();
        String colorCodeEnemyDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeHealth = ConsoleColors.SEA_GREEN;

        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT;
        String colorCodeReset = ConsoleColors.RESET;

        int calculatedEnemyDamage = (int) Math.floor(getEnemyAttackDamage());
        int calculatedEnemyHealthPoints = (int) Math.floor(getEnemyHealthPoints());

        return colorCodeEnemy + enemyName + colorCodeNormalText + ": " + colorCodeHealth + calculatedEnemyHealthPoints
                + colorCodeNormalText + " : " + colorCodeEnemyDamage + calculatedEnemyDamage + colorCodeReset;
    }
}