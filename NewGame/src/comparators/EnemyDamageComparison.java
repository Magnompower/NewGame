package comparators;

import enemies.Enemy;

import java.util.Comparator;

public class EnemyDamageComparison implements Comparator<Enemy> {
    @Override
    public int compare(Enemy o1, Enemy o2) {
        int enemyDamageComparison = (int) (o1.getEnemyAttackDamage() - o2.getEnemyAttackDamage());
        if (enemyDamageComparison != 0) {
            return enemyDamageComparison;
        }
        return o1.getEnemyName().compareToIgnoreCase(o2.getEnemyName());
    }
}
