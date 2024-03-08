package Armor;

import classes.ConsoleColors;

public class CommonArmor extends Armor {

    public CommonArmor(String armorName) {
        super(armorName);
        setArmorDefence(10);
        setArmorColor(ConsoleColors.WHITE_BRIGHT);
    }
}
