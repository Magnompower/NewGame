package Armor;

import enums.ArmorCondition;

public class Armor {
    private String armorName;
    private int armorDefence;
    private String armorColor;
    private double calculatedArmorDefence;
    private ArmorCondition armorCondition = ArmorCondition.DIRTY;

    public Armor(String armorName) {
        this.armorName = armorName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public String getArmorColor() {
        return armorColor;
    }

    public void setArmorColor(String armorColor) {
        this.armorColor = armorColor;
    }

    public double getCalculatedArmorDefence() {
        return calculatedArmorDefence;
    }

    public void setCalculatedArmorDefence(double calculatedArmorDefence) {
        this.calculatedArmorDefence = calculatedArmorDefence;
    }

    public ArmorCondition getArmorCondition() {
        return armorCondition;
    }
}
