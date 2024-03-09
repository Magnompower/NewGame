package Armor;

import classes.ConsoleColors;

public class LegendaryArmor extends Armor {
    public LegendaryArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.2);
        setArmorColor(ConsoleColors.ORANGE);
    }
}