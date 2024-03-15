package armor.inheritance;

import ui.ConsoleColors;

public class PoorArmor extends Armor {

    public PoorArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(90);
        setArmorColor(ConsoleColors.GREY);
        setRequiredStrength(0);
    }
}
