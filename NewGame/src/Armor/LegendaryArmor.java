package Armor;

import classes.ConsoleColors;

public class LegendaryArmor extends Armor {
    public LegendaryArmor(String armorName) {
        super(armorName);
        setArmorDamageTakenPercentage(20);
        setArmorColor(ConsoleColors.ORANGE);
        setRequiredStrength(20);

    }
}