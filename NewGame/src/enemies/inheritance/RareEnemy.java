package enemies.inheritance;

import ui.ConsoleColors;

public class RareEnemy extends Enemy{

    // 8 - 1 compared to self.
    public RareEnemy(String enemyName) {
        super(enemyName);
        setEnemyAttackDamage(10);
        setEnemyHealthPoints(80);
        setEnemyColor(ConsoleColors.RUBY_RED);
    }
}
