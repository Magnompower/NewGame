package Armor;

import classes.ConsoleColors;

public class EpicArmor extends Armor {
    public EpicArmor(String armorName) {
        super(armorName);
        setArmorDamageTakenPercentage(40);
        setArmorColor(ConsoleColors.PURPLE_BRIGHT);
        setRequiredStrength(18);

    }
}
