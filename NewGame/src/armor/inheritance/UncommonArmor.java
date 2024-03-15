package armor.inheritance;

import ui.ConsoleColors;

public class UncommonArmor extends Armor {

    public UncommonArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(60);
        setArmorColor(ConsoleColors.GREEN_BRIGHT);
        setRequiredStrength(12);
    }
}
