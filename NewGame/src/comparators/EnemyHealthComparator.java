package comparators;

import enemies.Enemy;

import java.util.Comparator;

public class EnemyHealthComparator implements Comparator<Enemy> {
    @Override
    public int compare(Enemy o1, Enemy o2) {
        int enemyDamageComparison = (int) (o1.getEnemyHealthPoints() - o2.getEnemyHealthPoints());
        if (enemyDamageComparison != 0) {
            return enemyDamageComparison;
        }
        return o1.getEnemyName().compareToIgnoreCase(o2.getEnemyName());
    }
}
