package classes;

import enemies.*;
import weapons.*;

public class Main {
    WeaponCreator weaponCreator = new WeaponCreator();
    EnemyCreator enemyCreator = new EnemyCreator();
    MenuMaker menuMaker = new MenuMaker();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        enemyCreator.instantiateEnemies();
        weaponCreator.instantiateWeapons();
        menuMaker.player.openMap(); // TODO

        menuMaker.ui.printWeaponsArraylistInOrder();
        menuMaker.ui.printEnemiesArraylistInOrder();

//        weaponCreator.printWeaponsArraylistInOrder(); // TODO
//        enemyCreator.printEnemyArraylistInOrder();

        menuMaker.promptWelcomeMessage();
        menuMaker.executeMenu();

//  TODO LIBGDX     When defeating an enemy you know its stats next fight.
    }
}
