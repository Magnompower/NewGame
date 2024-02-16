package comparators;

import classes.Enemy;

import java.util.Comparator;

public class EnemiesComparator implements Comparator<Enemy> {
    @Override
    public int compare(Enemy o1, Enemy o2) {
        int rarityComparison = o1.getEnemyRarity().compareTo(o2.getEnemyRarity());
        if (rarityComparison != 0) {
            return rarityComparison;
        }
        return o1.getEnemyName().compareToIgnoreCase(o2.getEnemyName());
    }
}
