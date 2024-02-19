package classes;

import enums.WeaponRarity;
import enums.WeaponType;

public class Weapon {
    private WeaponRarity weaponRarity;
    private WeaponType weaponType;
    private String weaponName;
    private int calculatedWeaponDamage;
    private String weaponModifier;


    public Weapon(WeaponRarity weaponRarity, WeaponType weaponType, String weaponName) {
        this.setWeaponRarity(weaponRarity);
        this.setWeaponName(weaponName);
        this.setWeaponType(weaponType);
    }

    public void setWeaponName(String weaponName) {
        if (!weaponName.isEmpty()) {
            this.weaponName = weaponName;
        }
    }

    public void setWeaponRarity(WeaponRarity weaponRarity) {
        this.weaponRarity = weaponRarity;


    }

    public String getWeaponType() {
        weaponModifier = weaponType.getModifier();
        return weaponModifier;
    }

    public WeaponRarity getWeaponRarity() {
        return weaponRarity;
    }

    public String getWeaponName() {
        return weaponName;
    }

    @Override
    public String toString() {
        String colorCodeWeapon = RarityMapping.getWeaponColorForRarity(weaponRarity);
        String colorCodeDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeReset = ConsoleColors.RESET;
        calculatedWeaponDamage = (int) Math.round(RarityMapping.getDamageForWeaponRarity(weaponRarity));
        weaponModifier = "(" + ConsoleColors.LIGHT_GOLD + weaponType.getModifier().toUpperCase() +
                ConsoleColors.RESET + ")";

        return weaponModifier + " " + colorCodeWeapon + weaponName + colorCodeReset + ": " +
                colorCodeDamage + calculatedWeaponDamage + colorCodeReset;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getCalculatedWeaponDamage() {
        if (weaponType == WeaponType.ONEHANDEDMACE || weaponType == WeaponType.ONEHANDEDSWORD ||
                weaponType == WeaponType.ONEHANDEDAXE || weaponType == WeaponType.DAGGER) {
            calculatedWeaponDamage = (int) Math.floor(RarityMapping.getDamageForWeaponRarity(weaponRarity) * 0.5);
        }
        return calculatedWeaponDamage;
    }
}
