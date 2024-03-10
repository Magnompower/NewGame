package classes;

import enemies.*;
import weapons.*;

public class Main {
    private MenuMaker menuMaker = new MenuMaker();
    private WeaponCreator weaponCreator = new WeaponCreator();
    private EnemyCreator enemyCreator = new EnemyCreator();


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        enemyCreator.instantiateEnemies();
        weaponCreator.instantiateWeapons();

//        menuMaker.ui.printWeaponsArraylistInOrder(weaponCreator.getWeapons());
//        menuMaker.ui.printEnemiesArraylistInOrder(enemyCreator.getEnemies());

        menuMaker.promptWelcomeMessage();
        menuMaker.promptSleepForOneAndAHalfSecond();
        menuMaker.executeMainMenu();
//  TODO LIBGDX     When defeating an enemy you know its stats next fight.
    }
}
