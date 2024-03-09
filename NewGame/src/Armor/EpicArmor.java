package Armor;

import classes.ConsoleColors;

public class EpicArmor extends Armor {
    public EpicArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.4);
        setArmorColor(ConsoleColors.PURPLE_BRIGHT);
    }
}
