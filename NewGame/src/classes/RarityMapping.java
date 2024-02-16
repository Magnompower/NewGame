package classes;

import enums.EnemyRarity;
import enums.WeaponRarity;
import enums.WeaponType;

import java.util.HashMap;
import java.util.Map;

public class RarityMapping {
    private final static double baseEnemyHealthPoints = 20;
    private static final double baseDamage = 5;
    private static final Map<WeaponRarity, String> weaponColorMap = new HashMap<>();
    private static final Map<EnemyRarity, String> enemyColorMap = new HashMap<>();
    private static final Map<WeaponRarity, Double> weaponDamageMap = new HashMap<>();
    private static final Map<EnemyRarity, Double> enemyHealthPointsMap = new HashMap<>();
    private static final Map<EnemyRarity, Double> enemyAttackDamageMap = new HashMap<>();

    static {
        enemyAttackDamageMap.put(EnemyRarity.COMMON, baseDamage * 0.4); // 10 - 1 compared to self.
        enemyAttackDamageMap.put(EnemyRarity.UNCOMMON, baseDamage); // 8 - 1
        enemyAttackDamageMap.put(EnemyRarity.RARE, baseDamage * 2); // 8 - 1
        enemyAttackDamageMap.put(EnemyRarity.EPIC, baseDamage * 4); // 6 - 1
        enemyAttackDamageMap.put(EnemyRarity.LEGENDARY, baseDamage * 8); // 5 - 1
        enemyAttackDamageMap.put(EnemyRarity.BOSS, baseDamage * 6); // 15 - 1
    }

    static {
        enemyColorMap.put(EnemyRarity.COMMON, ConsoleColors.BLOOD_RED);
        enemyColorMap.put(EnemyRarity.UNCOMMON, ConsoleColors.RASPBERRY);
        enemyColorMap.put(EnemyRarity.RARE, ConsoleColors.RUBY_RED);
        enemyColorMap.put(EnemyRarity.EPIC, ConsoleColors.VENETIAN_RED);
        enemyColorMap.put(EnemyRarity.LEGENDARY, ConsoleColors.SALMON);
        enemyColorMap.put(EnemyRarity.BOSS, ConsoleColors.BRIGHT_RED);
    }

    static {
        enemyHealthPointsMap.put(EnemyRarity.COMMON, baseEnemyHealthPoints);
        enemyHealthPointsMap.put(EnemyRarity.UNCOMMON, baseEnemyHealthPoints * 2);
        enemyHealthPointsMap.put(EnemyRarity.RARE, baseEnemyHealthPoints * 4);
        enemyHealthPointsMap.put(EnemyRarity.EPIC, baseEnemyHealthPoints * 6);
        enemyHealthPointsMap.put(EnemyRarity.LEGENDARY, baseEnemyHealthPoints * 10);
        enemyHealthPointsMap.put(EnemyRarity.BOSS, baseEnemyHealthPoints * 22.5);
    }

    static {
        WeaponType weaponType = null;
        if (weaponType == WeaponType.ONEHANDEDMACE || weaponType == WeaponType.ONEHANDEDSWORD ||
                weaponType == WeaponType.ONEHANDEDAXE || weaponType == WeaponType.DAGGER) {
            weaponDamageMap.put(WeaponRarity.POOR, baseDamage * 0.3);
            weaponDamageMap.put(WeaponRarity.COMMON, baseDamage * 0.5);
            weaponDamageMap.put(WeaponRarity.UNCOMMON, baseDamage * 0.6);
            weaponDamageMap.put(WeaponRarity.RARE, baseDamage * 0.8);
            weaponDamageMap.put(WeaponRarity.EPIC, baseDamage);
            weaponDamageMap.put(WeaponRarity.LEGENDARY, baseDamage * 1.5);
        } else
        weaponDamageMap.put(WeaponRarity.POOR, baseDamage * 0.6);
        weaponDamageMap.put(WeaponRarity.COMMON, baseDamage);
        weaponDamageMap.put(WeaponRarity.UNCOMMON, baseDamage * 1.2);
        weaponDamageMap.put(WeaponRarity.RARE, baseDamage * 1.6);
        weaponDamageMap.put(WeaponRarity.EPIC, baseDamage * 2);
        weaponDamageMap.put(WeaponRarity.LEGENDARY, baseDamage * 3);
    }

    static {
        weaponColorMap.put(WeaponRarity.POOR, ConsoleColors.GREY);
        weaponColorMap.put(WeaponRarity.COMMON, ConsoleColors.WHITE_BRIGHT);
        weaponColorMap.put(WeaponRarity.UNCOMMON, ConsoleColors.GREEN_BRIGHT);
        weaponColorMap.put(WeaponRarity.RARE, ConsoleColors.BLUE_BRIGHT);
        weaponColorMap.put(WeaponRarity.EPIC, ConsoleColors.PURPLE_BRIGHT);
        weaponColorMap.put(WeaponRarity.LEGENDARY, ConsoleColors.ORANGE);
    }

    public static String getWeaponColorForRarity(WeaponRarity weaponRarity) {
        return weaponColorMap.getOrDefault(weaponRarity, ConsoleColors.WHITE);
    }

    public static String getEnemyColorForRarity(EnemyRarity enemyRarity) {
        return enemyColorMap.getOrDefault(enemyRarity, ConsoleColors.RED_BRIGHT);
    }

    public static double getDamageForWeaponRarity(WeaponRarity weaponRarity) {
        return weaponDamageMap.getOrDefault(weaponRarity, baseDamage);
    }

    public static double getEnemyHealthPoints(EnemyRarity enemyRarity) {
        return enemyHealthPointsMap.getOrDefault(enemyRarity, baseEnemyHealthPoints);
    }

    public static Double getEnemyAttackDamage(EnemyRarity enemyRarity) {
        return enemyAttackDamageMap.getOrDefault(enemyRarity, baseDamage * 0.4);
    }
}
