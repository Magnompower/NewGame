package enemies.inheritance;

import ui.ConsoleColors;

public class UncommonEnemy extends Enemy {

    // 8 - 1 compared to self.
    public UncommonEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(5);
        setEnemyHealthPoints(40);
        setEnemyColor(ConsoleColors.RASPBERRY);
    }
}