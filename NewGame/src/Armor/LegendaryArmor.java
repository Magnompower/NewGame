package Armor;

import classes.ConsoleColors;

public class LegendaryArmor extends Armor {
    public LegendaryArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(20);
        setArmorColor(ConsoleColors.ORANGE);
        setRequiredStrength(20);

    }
}