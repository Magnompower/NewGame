package enemies;

import ui.UI;
import ui.comparators.EnemyHealthComparator;
import enemies.inheritance.*;

import java.util.ArrayList;

public class EnemyCreator {
    UI ui = new UI();
    private static final ArrayList<Enemy> enemiesArrayList = new ArrayList<>();

    public void instantiateEnemies() {

        Enemy human = new CommonEnemy("Bandit");
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


        enemiesArrayList.add(human);
        enemiesArrayList.add(dog);
        enemiesArrayList.add(honeyBadger);

        enemiesArrayList.add(wolf);
        enemiesArrayList.add(zombie);
        enemiesArrayList.add(skeleton);

        enemiesArrayList.add(centaur);
        enemiesArrayList.add(tiger);
        enemiesArrayList.add(bear);

        enemiesArrayList.add(elephant);
        enemiesArrayList.add(anders);
        enemiesArrayList.add(otto);

        enemiesArrayList.add(hussein);
        enemiesArrayList.add(hasan);
        enemiesArrayList.add(husasan);

        enemiesArrayList.add(blob);
        enemiesArrayList.add(zlats);
        enemiesArrayList.add(mossTheMad);
    }
    ArrayList<Enemy> enemiesArrayListCopy = enemiesArrayList;

    public Enemy getEnemiesByName(String enemyName) {
        instantiateEnemies();
        for (Enemy specificEnemy : enemiesArrayListCopy) {
            if (specificEnemy.getEnemyName().equalsIgnoreCase(enemyName)) {
                return specificEnemy;
            }
        }
        ui.printErrorGettingEnemyMessage();
        return null;
    }

    public ArrayList<Enemy> getEnemiesCopyArraylistInOrder() {
        enemiesArrayListCopy.sort(new EnemyHealthComparator());
        return enemiesArrayListCopy;
    }
}
