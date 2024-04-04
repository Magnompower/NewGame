package enemies.inheritance;

import ui.ConsoleColors;
import ui.UI;

import java.util.stream.Stream;

public abstract class Enemy {
    UI ui = new UI();
    private String enemyName;
    private double enemyAttackDamage;
    private int enemyHealthPoints;
    private int enemyMaxHealthPoints = 20;
    private int baseExperiencePointsGranted = 100;
    private String enemyColor;
    private int actualExperiencePointsGrated = (int) Math.floor(baseExperiencePointsGranted * getEnemyAttackDamage());

    // ------------------ SETTERS ------------------

    public Enemy(String enemyName) {
        this.setEnemyName(enemyName);
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public void setEnemyAttackDamage(double enemyAttackDamage) {
        this.enemyAttackDamage = enemyAttackDamage;
    }

    public void setEnemyHealthPoints(int enemyHealthPoints) {
        int currentLoot = 1; // TODO CALCULATE LOOT
        if (enemyHealthPoints > 0) {
            this.enemyHealthPoints = enemyHealthPoints;
        } else ui.printEnemyIsDead(getEnemyName(), currentLoot); //TODO MAKE SURE ITS COLORED
    }

    public void setEnemyColor(String enemyColor) {
        this.enemyColor = enemyColor;
    }

    public void setBaseExperiencePointsGranted(int baseExperiencePointsGranted) {
        this.baseExperiencePointsGranted = baseExperiencePointsGranted;
    }

    // ------------------ GETTERS ------------------

    public String getEnemyName() {
        return enemyColor + enemyName;
    }

    public double getEnemyAttackDamage() {
        return enemyAttackDamage;
    }

    public int getEnemyHealthPoints() {
        return enemyHealthPoints;
    }

    public String getEnemyColor() {
        return enemyColor;
    }

    public int getEnemyMaxHealthPoints() {
        return enemyMaxHealthPoints;
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