package Armor;

import classes.ConsoleColors;

public class CommonArmor extends Armor {

    public CommonArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.8);
        setArmorColor(ConsoleColors.WHITE_BRIGHT);
    }
}
