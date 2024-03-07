package enemies;

import classes.ConsoleColors;

public class BossEnemy extends Enemy{

    // 15 - 1 compared to self.
    public BossEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(30);
        setEnemyHealthPoints(450);
        setEnemyColor(ConsoleColors.BRIGHT_RED);
    }
}