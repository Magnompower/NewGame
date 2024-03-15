package enemies;

import ui.UI;
import comparators.EnemyHealthComparator;
import enemies.inheritance.*;

import java.util.ArrayList;

public class EnemyCreator {
    UI ui;
    private static final ArrayList<Enemy> enemies = new ArrayList<>();

    public void instantiateEnemies() {

        Enemy human = new CommonEnemy("Human");
        Enemy dog = new CommonEnemy("Dog");
        Enemy honeyBadger = new CommonEnemy("Honey badger");


        Enemy wolf = new UncommonEnemy("Wolf");
        Enemy zombie = new UncommonEnemy("Zombie");
        Enemy skeleton = new UncommonEnemy("Skeleton");


        Enemy centaur = new RareEnemy("Centaur");
        Enemy bear = new RareEnemy("Bear");
        Enemy tiger = new RareEnemy("Tiger");


        Enemy elephant = new EpicEnemy("Elephant");
        Enemy otto = new EpicEnemy("Otto Otto");
        Enemy anders = new EpicEnemy("Anders the duck");


        Enemy hussein = new LegendaryEnemy("Hussein");
        Enemy hasan = new LegendaryEnemy("Hasan");
        Enemy husasan = new LegendaryEnemy("HUSASAN");


        Enemy blob = new BossEnemy("BLOB");
        Enemy zlats = new BossEnemy("Hungry Zlats");
        Enemy mossTheMad = new BossEnemy("Moss the mad");


        enemies.add(human);
        enemies.add(dog);
        enemies.add(honeyBadger);

        enemies.add(wolf);
        enemies.add(zombie);
        enemies.add(skeleton);

        enemies.add(centaur);
        enemies.add(tiger);
        enemies.add(bear);

        enemies.add(elephant);
        enemies.add(anders);
        enemies.add(otto);

        enemies.add(hussein);
        enemies.add(hasan);
        enemies.add(husasan);

        enemies.add(blob);
        enemies.add(zlats);
        enemies.add(mossTheMad);
    }
    ArrayList<Enemy> enemiesCopy = enemies;

    public Enemy getEnemiesByName(String name) {
        for (Enemy specificEnemy : enemiesCopy) {
            if (specificEnemy.getEnemyName().equals(name)) {
                return specificEnemy;
            }
        }
        ui.printErrorGettingEnemyMessage();
        return null;
    }

    public ArrayList<Enemy> getEnemiesCopyArraylistInOrder() {
        enemiesCopy.sort(new EnemyHealthComparator());
        return enemiesCopy;
    }
}
