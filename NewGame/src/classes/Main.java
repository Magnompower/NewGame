package classes;

import armor.ArmorCreator;
import enemies.*;
import menus.MenuMaker;
import weapons.*;

public class Main { //TODO TOO MANY INSTANCES?

    private UI ui = new UI();
    private Player player = new Player();
    private MapFrame mapFrame = MapFrame.getInstance(); // Assuming MapFrame also needs UI and Player
    private MenuMaker menuMaker = new MenuMaker(ui,player,mapFrame);
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

//        menuMaker.player.playerWeapon.calculateActualWeaponDamage(); //TODO STUDPID HERE! BUT WHERE ELSE?
//        menuMaker.player.calculatedPlayerDamage(menuMaker.player.getPlayerDamage()); //TODO STUPID TO DO HERE?

//        menuMaker.ui.printWeaponsArraylistInOrder(weaponCreator.getWeapons());
//        menuMaker.ui.printEnemiesArraylistInOrder(enemyCreator.getEnemies());

        menuMaker.promptWelcomeMessage();
        menuMaker.promptSleepForOneAndAHalfSecond();
        menuMaker.executeMenus();
//  TODO LIBGDX     When defeating an enemy you know its stats next fight.
    }

}
