package classes;

import enemies.*;
import enums.WeaponType;
import weapons.*;

import java.util.ArrayList;

public class Main {
    ArrayList<Weapon> weapons = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    MenuMaker menuMaker = new MenuMaker();


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Weapon clubPoor = new PoorWeapon(WeaponType.ONEHANDEDMACE,"Poor Club");
        Weapon clubCommon = new CommonWeapon(WeaponType.ONEHANDEDMACE,"Common Club");
        Weapon clubUncommon = new UncommonWeapon(WeaponType.ONEHANDEDMACE, "Uncommon Club");

        Weapon warHammerPoor = new PoorWeapon(WeaponType.TWOHANDEDMACE, "Poor Warhammer");
        Weapon warHammerCommon = new CommonWeapon(WeaponType.TWOHANDEDMACE, "Common Warhammer");
        Weapon warHammerUncommon = new UncommonWeapon(WeaponType.TWOHANDEDMACE, "Uncommon Warhammer");


        Weapon shortswordPoor = new PoorWeapon(WeaponType.ONEHANDEDSWORD, "Poor Shortsword");
        Weapon shortswordCommon = new CommonWeapon(WeaponType.ONEHANDEDSWORD, "Common Shortsword");
        Weapon shortswordUncommon = new UncommonWeapon(WeaponType.ONEHANDEDSWORD, "Uncommon Shortsword");


        Weapon longswordPoor = new PoorWeapon(WeaponType.TWOHANDEDSWORD, "Poor Longsword");
        Weapon longswordCommon = new CommonWeapon(WeaponType.TWOHANDEDSWORD, "Common Longsword");
        Weapon longswordUncommon = new UncommonWeapon(WeaponType.TWOHANDEDSWORD, "Uncommon Longsword");


        Weapon staffOfMindorr = new RareWeapon(WeaponType.STAFF, "Staff of Mindorr");


        Weapon swordOfKeilier = new EpicWeapon(WeaponType.TWOHANDEDSWORD, "Sword of Keilier");


        Weapon axeOfOddie = new LegendaryWeapon(WeaponType.TWOHANDEDAXE, "Axe of Oddie");


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


        weapons.add(clubPoor);
        weapons.add(clubCommon);
        weapons.add(clubUncommon);

        weapons.add(warHammerPoor);
        weapons.add(warHammerCommon);
        weapons.add(warHammerUncommon);

        weapons.add(shortswordPoor);
        weapons.add(shortswordCommon);
        weapons.add(shortswordUncommon);

        weapons.add(longswordPoor);
        weapons.add(longswordCommon);
        weapons.add(longswordUncommon);

        weapons.add(staffOfMindorr);


        weapons.add(swordOfKeilier);


        weapons.add(axeOfOddie);


        menuMaker.promptWelcomeMessage();
        menuMaker.executeMenu();

//            printTimePlayed(); // Not working
//        When defeating an enemy you know its stats next fight.
    }
}

//LIBGDX TODO