package Armor;

import classes.ConsoleColors;

public class CommonArmor extends Armor {

    public CommonArmor(String armorName) {
        super(armorName);
        setArmorDamageTakenPercentage(80);
        setArmorColor(ConsoleColors.WHITE_BRIGHT);
        setRequiredStrength(10);
    }
}
