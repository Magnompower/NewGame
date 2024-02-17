package classes;

import enums.EnemyRarity;
import enums.WeaponRarity;
import enums.WeaponType;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    MapFrame mapFrame = new MapFrame(); // Måske problem her:
    UI ui = new UI();
    Scanner playerChoice = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Boolean gameRunning = true;
    ArrayList<Weapon> weapons = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    Player player = new Player();
    MenuMaker menuMaker = new MenuMaker();


    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Weapon clubPoor = new Weapon(WeaponRarity.POOR, WeaponType.ONEHANDEDMACE, "Poor Club");
        Weapon clubCommon = new Weapon(WeaponRarity.COMMON, WeaponType.ONEHANDEDMACE, "Common Club");
        Weapon clubUncommon = new Weapon(WeaponRarity.UNCOMMON, WeaponType.ONEHANDEDMACE, "Uncommon Club");

        Weapon warHammerPoor = new Weapon(WeaponRarity.POOR, WeaponType.TWOHANDEDMACE, "Poor Warhammer");
        Weapon warHammerCommon = new Weapon(WeaponRarity.COMMON, WeaponType.TWOHANDEDMACE, "Common Warhammer");
        Weapon warHammerUncommon = new Weapon(WeaponRarity.UNCOMMON, WeaponType.TWOHANDEDMACE, "Uncommon Warhammer");


        Weapon shortswordPoor = new Weapon(WeaponRarity.POOR, WeaponType.ONEHANDEDSWORD, "Poor Shortsword");
        Weapon shortswordCommon = new Weapon(WeaponRarity.COMMON, WeaponType.ONEHANDEDSWORD, "Common Shortsword");
        Weapon shortswordUncommon = new Weapon(WeaponRarity.UNCOMMON, WeaponType.ONEHANDEDSWORD, "Uncommon Shortsword");


        Weapon longswordPoor = new Weapon(WeaponRarity.POOR, WeaponType.TWOHANDEDSWORD, "Poor Longsword");
        Weapon longswordCommon = new Weapon(WeaponRarity.COMMON, WeaponType.TWOHANDEDSWORD, "Common Longsword");
        Weapon longswordUncommon = new Weapon(WeaponRarity.UNCOMMON, WeaponType.TWOHANDEDSWORD, "Uncommon Longsword");


        Weapon staffOfMindorr = new Weapon(WeaponRarity.RARE, WeaponType.STAFF, "Staff of Mindorr");


        Weapon swordOfKeilier = new Weapon(WeaponRarity.EPIC, WeaponType.TWOHANDEDSWORD, "Sword of Keilier");


        Weapon axeOfOddie = new Weapon(WeaponRarity.LEGENDARY, WeaponType.TWOHANDEDAXE, "Axe of Oddie");


        Enemy human = new Enemy(EnemyRarity.COMMON, "Human");
        Enemy dog = new Enemy(EnemyRarity.COMMON, "Dog");
        Enemy honeyBadger = new Enemy(EnemyRarity.COMMON, "Honey badger");


        Enemy wolf = new Enemy(EnemyRarity.UNCOMMON, "Wolf");
        Enemy zombie = new Enemy(EnemyRarity.UNCOMMON, "Zombie");
        Enemy skeleton = new Enemy(EnemyRarity.UNCOMMON, "Skeleton");


        Enemy centaur = new Enemy(EnemyRarity.RARE, "Centaur");
        Enemy bear = new Enemy(EnemyRarity.RARE, "Bear");
        Enemy tiger = new Enemy(EnemyRarity.RARE, "Tiger");


        Enemy elephant = new Enemy(EnemyRarity.EPIC, "Elephant");
        Enemy giraf = new Enemy(EnemyRarity.EPIC, "War Giraf");
        Enemy buffalo = new Enemy(EnemyRarity.EPIC, "Buffalo");


        Enemy hussein = new Enemy(EnemyRarity.LEGENDARY, "Hussein");
        Enemy hasan = new Enemy(EnemyRarity.LEGENDARY, "Hasan");
        Enemy husasan = new Enemy(EnemyRarity.LEGENDARY, "HUSASAN");


        Enemy blob = new Enemy(EnemyRarity.BOSS, "BLOB");
        Enemy zlats = new Enemy(EnemyRarity.BOSS, "Hungry Zlats");
        Enemy mossTheMad = new Enemy(EnemyRarity.BOSS, "Moss the mad");


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


        ui.welcomeMessage();
        menuMaker.movementMenu();
//        mapFrame.makeMapVisible = true;
//        mapFrame.setMapVisibillity(makeMapVisible); // opens map TODO PROGRAM SHUTS DOWN WHEN MAP CLOSES
        while (gameRunning) {

//            printTimePlayed(); // Not working
//        When defeating an enemy you know its stats next fight.
        }
    }
}

//LIBGDX TODO
