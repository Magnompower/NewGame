package enemies.inheritance;

import ui.ConsoleColors;

public class LegendaryEnemy extends Enemy {

    // 5 - 1 compared to self.
    public LegendaryEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(40);
        setEnemyHealthPoints(200);
        setEnemyColor(ConsoleColors.SALMON);
    }
}