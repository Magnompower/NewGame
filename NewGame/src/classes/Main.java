package classes;

import Armor.ArmorCreator;
import enemies.*;
import weapons.*;

public class Main {
    private MenuMaker menuMaker = new MenuMaker();
    private WeaponCreator weaponCreator = new WeaponCreator();
    private EnemyCreator enemyCreator = new EnemyCreator();
    private ArmorCreator armorCreator = new ArmorCreator();


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        enemyCreator.instantiateEnemies();
        weaponCreator.instantiateWeapons();
        armorCreator.instantiateArmor();

        menuMaker.player.playerWeapon.calculateActualWeaponDamage(); //TODO STUDPID HERE! BUT WHERE ELSE?
//        menuMaker.player.calculatedPlayerDamage(menuMaker.player.getPlayerDamage()); //TODO STUPID TO DO HERE?

//        menuMaker.ui.printWeaponsArraylistInOrder(weaponCreator.getWeapons());
//        menuMaker.ui.printEnemiesArraylistInOrder(enemyCreator.getEnemies());

        menuMaker.promptWelcomeMessage();
        menuMaker.promptSleepForOneAndAHalfSecond();
        menuMaker.executeMainMenu();
//  TODO LIBGDX     When defeating an enemy you know its stats next fight.
    }

}
