package armor.inheritance;

import ui.ConsoleColors;

public class EpicArmor extends Armor {
    public EpicArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(40);
        setArmorColor(ConsoleColors.PURPLE_BRIGHT);
        setRequiredStrength(18);

    }
}
