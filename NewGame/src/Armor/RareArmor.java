package Armor;

import classes.ConsoleColors;

public class RareArmor extends Armor {
    public RareArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.5);
        setArmorColor(ConsoleColors.BLUE_BRIGHT);
        setRequiredStrength(14);
    }
}
