package enemies;

import classes.ConsoleColors;

public class EpicEnemy extends Enemy {

    // 6 - 1 compared to self.
    public EpicEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(20);
        setEnemyHealthPoints(120);
        setEnemyColor(ConsoleColors.VENETIAN_RED);
    }
}