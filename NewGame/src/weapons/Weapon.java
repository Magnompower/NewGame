package weapons;

import classes.ConsoleColors;
import enums.WeaponCondition;
import enums.WeaponType;

public abstract class Weapon {

    private String weaponName;
    private double weaponDamage;
    private String weaponColor;
    private WeaponType weaponType;
    private double calculatedWeaponDamage;
    private String weaponModifier;
    private WeaponCondition weaponCondition = WeaponCondition.BROKEN;

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

    public void setWeaponDamage(double weaponDamage) {
        if (weaponDamage <= 0) {
            weaponDamage = 1;
        } else if (weaponDamage > 0) {
            this.weaponDamage = weaponDamage;
        }
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

    public String getWeaponName() {
        return weaponName;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public String getWeaponColor() {
        return weaponColor;
    }

    public String getWeaponType() {
        weaponModifier = weaponType.getModifier();
        return weaponModifier;
    }

    public double getCalculatedWeaponDamage() { //TODO LOGIC IN GETTERS? NOT A REAL GETTER...
        if (weaponType == WeaponType.ONEHANDEDMACE || weaponType == WeaponType.ONEHANDEDSWORD ||
                weaponType == WeaponType.ONEHANDEDAXE || weaponType == WeaponType.DAGGER) {
            calculatedWeaponDamage = Math.floor(getWeaponDamage() * 0.5);
        } else if (weaponCondition == WeaponCondition.BROKEN) {
            calculatedWeaponDamage = calculatedWeaponDamage * 0.25;
        } else if (weaponCondition == WeaponCondition.RUSTY) {
            calculatedWeaponDamage = calculatedWeaponDamage * 0.10;
        } else if (weaponCondition == WeaponCondition.POLISHED) {
            calculatedWeaponDamage = calculatedWeaponDamage * 1.10;
        } else if (weaponCondition == WeaponCondition.SHARP) {
            calculatedWeaponDamage = calculatedWeaponDamage * 1.25;
        }
        return calculatedWeaponDamage;
    }

    public WeaponCondition getWeaponCondition() {
        return weaponCondition;
    }

    // ------------------ OTHER ------------------

    @Override
    public String toString() { //TODO GODT AT SKRIVE LOGIK I TOSTRING?

        String colorCodeWeapon = getWeaponColor();
        String colorCodeWeaponDamage = ConsoleColors.LIGHT_GOLD;
        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT;

        String calculatedWeaponDamageString = String.valueOf(Math.round(getWeaponDamage()));
        weaponModifier = ConsoleColors.SALMON + "(" + ConsoleColors.LIGHT_GOLD +
                weaponType.getModifier().toUpperCase() + ConsoleColors.SALMON + ")";

        String weaponDetails = weaponModifier + " " + colorCodeWeapon + weaponName + colorCodeNormalText +
                " : " + colorCodeWeaponDamage + calculatedWeaponDamageString + ConsoleColors.RESET; // TODO CHANGE PLACEMENT OF "DAMAGE" ??!!
        if (!weaponCondition.equals(WeaponCondition.NORMAL)) {
            weaponDetails += colorCodeNormalText + " : " + weaponCondition.getWeaponConditionColor() +
                    weaponCondition.getWeaponConditionText() + ConsoleColors.RESET;
        }
        return weaponDetails;
    }
}