package enemies.inheritance;

import ui.ConsoleColors;

public class CommonEnemy extends Enemy{

    // 10 - 1 compared to self.
    public CommonEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(2);
        setEnemyHealthPoints(20);
        setEnemyColor(ConsoleColors.BLOOD_RED);
    }
}