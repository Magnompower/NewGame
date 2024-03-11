package Armor;

import classes.ConsoleColors;

public class RareArmor extends Armor {
    public RareArmor(String armorName) {
        super(armorName);
        setArmorDamageTakenPercentage(50);
        setArmorColor(ConsoleColors.BLUE_BRIGHT);
        setRequiredStrength(14);
    }
}
