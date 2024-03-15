package armor.inheritance;

import ui.ConsoleColors;

public class CommonArmor extends Armor {

    public CommonArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(80);
        setArmorColor(ConsoleColors.WHITE_BRIGHT);
        setRequiredStrength(10);
    }
}
