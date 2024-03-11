package Armor;

import classes.ConsoleColors;

public class UncommonArmor extends Armor {

    public UncommonArmor(String armorName) {
        super(armorName);
        setArmorDamageTakenPercentage(60);
        setArmorColor(ConsoleColors.GREEN_BRIGHT);
        setRequiredStrength(12);
    }
}
