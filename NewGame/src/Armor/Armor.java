package Armor;

import classes.ConsoleColors;
import enums.ArmorCondition;
import enums.WeaponCondition;

public class Armor {
    private String armorName;
    private double armorDamageTakenPercentage; //TODO MAYBE NAME TO DECIBVAL?? CONFUSED NAMING?
    private String armorColor; // TODO COLORSWITCH NOT WORKING SAME WITH WEAPON
    private double calculatedArmorDamageTakenPercentage = calculateArmorDamageTakenPercent();
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

    public String getArmorColor() {
        return armorColor;
    }

    public void setArmorCondition(ArmorCondition armorCondition) {
        this.armorCondition = armorCondition;
    }


    public void setArmorColor(String armorColor) {
        this.armorColor = armorColor;
    }

    public int calculateArmorDamageTakenPercent() { // TODO USE MATH.FLOOR ON ARMOR
armorCondition = getArmorCondition();
        if (armorCondition == ArmorCondition.BROKEN) {
            armorDamageTakenPercentage = armorDamageTakenPercentage * 1.25; // 0,9 + 0,25 = 1,15 -- YOU TAKE MORE DAMAGE THAN WITHOUT ARMOR!!  TODO
        }
        if (armorCondition == ArmorCondition.DIRTY) {
            armorDamageTakenPercentage = armorDamageTakenPercentage * 1.1; // 0.9 + 0.09=0.99
        }
        if (armorCondition == ArmorCondition.POLISHED) {
            armorDamageTakenPercentage = armorDamageTakenPercentage * 0.9; // Will only be 1 with legendary armor
        }
        if (armorCondition == ArmorCondition.REINFORCED) {
            armorDamageTakenPercentage = armorDamageTakenPercentage * 0.75; // Will still only be 1 with legendary armor
        }
        if (armorDamageTakenPercentage >= 1) armorDamageTakenPercentage = 0.99;

        calculatedArmorDamageTakenPercentage = armorDamageTakenPercentage;

        return (int) calculatedArmorDamageTakenPercentage; // MATH FLOOR? TODO
    }

    public int calculateDamageReceived() { //TODO
        damageReceived = damageReceived * calculateArmorDamageTakenPercent();
        return (int) damageReceived;
    }

    public ArmorCondition getArmorCondition() {
        return armorCondition;
    }

    @Override
    public String toString() {

        String colorCodeArmor = getArmorColor();
        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT; //TODO CHANGE THE GENERAL YELLOW COLOR!
        String colorCodeArmorDefence = ConsoleColors.LIGHT_GOLD;
        String uniqueColor = ConsoleColors.SALMON;

        int armorDefencePercentage = calculateArmorDamageTakenPercent(); //TODO FIX LOGIC! NEED HELP!
        String requiredStrengthString = uniqueColor + "(" + ConsoleColors.LIGHT_GOLD + getRequiredStrength() + uniqueColor + ")";

        String armorDetails = requiredStrengthString + " " + colorCodeArmor + armorName + colorCodeNormalText +
                " : " + colorCodeArmorDefence + armorDefencePercentage + "%" + uniqueColor + " Reduction" +
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

    public double getArmorDamageTakenPercentage() {
        return armorDamageTakenPercentage;
    }

    public void setArmorDamageTakenPercentage(double armorDamageTakenPercentage) {
        this.armorDamageTakenPercentage = armorDamageTakenPercentage;
    }
}
