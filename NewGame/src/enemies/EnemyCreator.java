package enemies;

import java.util.ArrayList;

public class EnemyCreator {
    private ArrayList<Enemy> enemies = new ArrayList<>();

    public void InstantiateEnemies() {

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
        Enemy giraf = new EpicEnemy("War Giraf");
        Enemy buffalo = new EpicEnemy("Buffalo");


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
        enemies.add(giraf);
        enemies.add(buffalo);

        enemies.add(hussein);
        enemies.add(hasan);
        enemies.add(husasan);

        enemies.add(blob);
        enemies.add(zlats);
        enemies.add(mossTheMad);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

}
