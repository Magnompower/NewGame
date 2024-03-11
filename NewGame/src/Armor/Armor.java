package Armor;

import classes.ConsoleColors;
import enums.ArmorCondition;
import enums.WeaponCondition;

public class Armor {
    private String armorName;
    private double armorDefencePercentage; //TODO MAYBE NAME TO DECIBVAL?? CONFUSED NAMING?
    private String armorColor; // TODO COLORSWITCH NOT WORKING SAME WITH WEAPON
    private double calculateArmorDefence;
    private ArmorCondition armorCondition = ArmorCondition.DIRTY;
    private double damageReceived; // TODO RECEIVES INFO FROM ENEMY SOMEHOW
    private int requiredStrength;

    public Armor(String armorName) {
        this.armorName = armorName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public double getArmorDefencePercentage() {
        return armorDefencePercentage;
    }

    public void setArmorDefenceInDecimal(double armorDefence) {
        this.armorDefencePercentage = armorDefence;
    }

    public String getArmorColor() {
        return armorColor;
    }

    public void setArmorCondition(ArmorCondition armorCondition) {
        this.armorCondition = armorCondition;
    }


    public void setArmorColor(String armorColor) {
        this.armorColor = armorColor;
    }

    public double calculateArmorDefencePercentage() { // TODO USE MATH.FLOOR ON ARMOR

        if (getArmorCondition() == ArmorCondition.BROKEN) {
            armorDefencePercentage = getArmorDefencePercentage() * 1.25; // 0,9 + 0,25 = 1,15 -- YOU TAKE MORE DAMAGE THAN WITHOUT ARMOR!!  TODO
            if (armorDefencePercentage > 1) armorDefencePercentage = 1;
        }
        if (getArmorCondition() == ArmorCondition.DIRTY) {
            armorDefencePercentage = getArmorDefencePercentage() * 1.10;
            if (armorDefencePercentage > 1) armorDefencePercentage = 1;
        }
        if (getArmorCondition() == ArmorCondition.POLISHED) {
            armorDefencePercentage = getArmorDefencePercentage() * 0.9; // Will only be 1 with legendary armor
        }
        if (getArmorCondition() == ArmorCondition.REINFORCED) {
            armorDefencePercentage = getArmorDefencePercentage() * 0.75; // Will still only be 1 with legendary armor
        }

        calculateArmorDefence = damageReceived * armorDefencePercentage;

        return (int) calculateArmorDefence;
    }

    public ArmorCondition getArmorCondition() {
        return armorCondition;
    }

    @Override
    public String toString() {

        String colorCodeArmor = getArmorColor();
        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT; //TODO CHANGE THE GENERAL YELLOW COLOR!
        String colorCodeArmorDefence = ConsoleColors.LIGHT_GOLD;

        int armorDefencePercentage = (int) Math.round(calculateArmorDefencePercentage() * 100+1); //TODO FIX LOGIC!
        String requiredStrengthString = ConsoleColors.SALMON + "(" + ConsoleColors.LIGHT_GOLD +
                String.valueOf(getRequiredStrength()) + ConsoleColors.SALMON + ")";

        String armorDetails = requiredStrengthString + " " + colorCodeArmor + armorName + colorCodeNormalText +
                " : " + colorCodeArmorDefence + armorDefencePercentage + "%" + colorCodeNormalText + " Reduction" +
                ConsoleColors.RESET; // TODO CHANGE calculatedReceivedDamage Maybe add another vartialble??
        if (!armorCondition.equals(WeaponCondition.NORMAL)) {
            armorDetails += colorCodeNormalText + " : " + armorCondition.getArmorConditionColor() +
                    armorCondition.getArmorConditionText() + ConsoleColors.RESET;
        }
        return armorDetails;
    }

    public int getRequiredStrength() {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength) {
        this.requiredStrength = requiredStrength;
    }
}
