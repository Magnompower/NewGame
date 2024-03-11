package Armor;

import classes.ConsoleColors;

public class UncommonArmor extends Armor {

    public UncommonArmor(String armorName) {
        super(armorName);
        setArmorDefenceInDecimal(0.6);
        setArmorColor(ConsoleColors.GREEN_BRIGHT);
        setRequiredStrength(12);
    }
}
