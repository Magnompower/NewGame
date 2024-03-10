package classes;

import enemies.*;
import weapons.*;

public class Main {
    MenuMaker menuMaker = new MenuMaker();
    WeaponCreator weaponCreator = new WeaponCreator();
    EnemyCreator enemyCreator = new EnemyCreator();


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        enemyCreator.instantiateEnemies();
        weaponCreator.instantiateWeapons();
        menuMaker.mapFrame.createMapFrame();
        menuMaker.mapFrame.makeMapVisible();
        menuMaker.player.promptUpdatePlayerPosition();

//        menuMaker.ui.printWeaponsArraylistInOrder(weaponCreator.getWeapons());
//        menuMaker.ui.printEnemiesArraylistInOrder(enemyCreator.getEnemies());

        menuMaker.promptWelcomeMessage();
        menuMaker.promptSleepForOneAndAHalfSecond();
        menuMaker.executeMenu();
//  TODO LIBGDX     When defeating an enemy you know its stats next fight.
    }
}
