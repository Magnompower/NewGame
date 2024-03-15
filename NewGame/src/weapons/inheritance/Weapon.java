package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponCondition;
import weapons.WeaponType;

public abstract class Weapon {

    private String weaponName;
    private String weaponColor;
    private String weaponModifier;
    private WeaponType weaponType = WeaponType.ONEHANDED_DAGGER;
    private WeaponCondition weaponCondition = WeaponCondition.BROKEN;
    private int baseWeaponDamage;
    private int actualWeaponDamage;

    public Weapon(WeaponType weaponType, String weaponName) {
        this.setWeaponType(weaponType);
        this.setWeaponName(weaponName);
    }

    // ------------------ SETTERS ------------------

    public void setWeaponName(String weaponName) {
        if (!weaponName.isEmpty()) {
            this.weaponName = weaponName;
        }
    }

    public void setActualWeaponDamage(double actualWeaponDamage) {
        if (actualWeaponDamage <= 0) {
            actualWeaponDamage = 1;
        }
        this.actualWeaponDamage = (int) Math.round(actualWeaponDamage);
    }

    public void setBaseWeaponDamage(int baseWeaponDamage) {
        this.baseWeaponDamage = baseWeaponDamage;
    }

    public void setWeaponColor(String weaponColor) {
        this.weaponColor = weaponColor;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setWeaponCondition(WeaponCondition weaponCondition) {
        this.weaponCondition = weaponCondition;
    }

    // ------------------ GETTERS ------------------


    public int getActualWeaponDamage() {
        calculateActualWeaponDamage();
        return actualWeaponDamage;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public double getBaseWeaponDamage() {
        return baseWeaponDamage;
    }

    public String getWeaponColor() {
        return weaponColor;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public WeaponCondition getWeaponCondition() {
        return weaponCondition;
    }

    // ------------------ CALCULATE METHODS ------------------

    public void calculateActualWeaponDamage() { //TODO PROBLEM DEN IKKE RETURNERER FORDI DEN IKKE INSTACIERES?!?

        if (weaponType == WeaponType.ONEHANDED_MACE || weaponType == WeaponType.ONEHANDED_SWORD ||
                weaponType == WeaponType.ONEHANDED_AXE || weaponType == WeaponType.ONEHANDED_DAGGER) {
            baseWeaponDamage = (int) Math.round(baseWeaponDamage * 0.5);
        }
        switch (weaponCondition) {
            case BROKEN -> setActualWeaponDamage(baseWeaponDamage * 0.75);
            case RUSTY -> setActualWeaponDamage(baseWeaponDamage * 0.9);
            case NORMAL -> setActualWeaponDamage(baseWeaponDamage);
            case POLISHED -> setActualWeaponDamage(baseWeaponDamage * 1.1);
            case SHARP -> setActualWeaponDamage(baseWeaponDamage * 1.25);
        }

    }

    // ------------------ OTHER ------------------

    @Override
    public String toString() {

        String colorCodeWeapon = getWeaponColor();
        String colorCodeWeaponDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT;
        String uniqueColor = ConsoleColors.SALMON;

        String placeHolderOfPlayerDamage = "%placeHolder%";

       /* private static String centerString(String text, int width) {
            if (text.length() >= width) {
                return text.substring(0, width); //TODO MAYBE
            }
            int leftPadding = (width - text.length()) / 2;
            int rightPadding = width - leftPadding - text.length();
            return String.format("%" + leftPadding + "s%s%" + rightPadding + "s", "", text, "");
        }
        String centeredWeaponName = centerString(getWeaponName(),20);*/

        weaponModifier = uniqueColor + "(" + ConsoleColors.LIGHT_GOLD +
                weaponType.getModifier().toUpperCase() + uniqueColor + ")";

        String weaponDetails = String.format("%sWeapon: %s %s%-20.20s%s:%s %2s%s|%s%2s %s Damage%s",
                colorCodeNormalText, weaponModifier, colorCodeWeapon, weaponName, colorCodeNormalText,
                colorCodeWeaponDamage, getActualWeaponDamage(), uniqueColor, colorCodeWeaponDamage,
                placeHolderOfPlayerDamage, uniqueColor, ConsoleColors.RESET);

        if (!weaponCondition.equals(WeaponCondition.NORMAL)) {
            weaponDetails += String.format("%s    : %s%s%s", colorCodeNormalText, weaponCondition.getWeaponConditionColor(),
                    weaponCondition.getWeaponConditionText(), ConsoleColors.RESET);
        }
        return weaponDetails;
        // MAYBE COULD HAVE SAVED THIS BY MAKING UI CLASS SMART SINCE BASICALLY THE SAME IS HAPPENING IN ARMOR AND PLAYER
    }
}