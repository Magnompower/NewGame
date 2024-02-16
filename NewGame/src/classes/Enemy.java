package classes;

import enums.EnemyRarity;

public class Enemy {
    private String enemyName;
    private EnemyRarity enemyRarity;

    public Enemy(EnemyRarity enemyRarity, String enemyName) {
        this.setEnemyName(enemyName);
        this.setEnemyRarity(enemyRarity);
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public EnemyRarity getEnemyRarity() {
        return enemyRarity;
    }

    public void setEnemyRarity(EnemyRarity enemyRarity) {
        this.enemyRarity = enemyRarity;
    }

    @Override
    public String toString() {
        String colorCodeEnemy = RarityMapping.getEnemyColorForRarity(enemyRarity);
        String colorCodeDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeHealth = ConsoleColors.SEA_GREEN;
        String colorCodeReset = ConsoleColors.RESET;
        int calculatedEnemyDamage = (int) Math.round(RarityMapping.getEnemyAttackDamage(enemyRarity));
        int calculatedEnemyHealthPoints = (int) Math.round(RarityMapping.getEnemyHealthPoints(enemyRarity));
        return colorCodeEnemy + enemyName + colorCodeReset + ": " + colorCodeHealth +
                calculatedEnemyHealthPoints + colorCodeReset + ": " + colorCodeDamage + calculatedEnemyDamage +
                colorCodeReset;
    }
}
