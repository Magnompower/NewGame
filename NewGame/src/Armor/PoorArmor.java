package Armor;

import classes.ConsoleColors;

public class PoorArmor extends Armor {

    public PoorArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.9);
        setArmorColor(ConsoleColors.GREY);
    }
}
