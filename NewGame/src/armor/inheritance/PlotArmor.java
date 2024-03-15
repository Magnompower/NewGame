package armor.inheritance;

import ui.ConsoleColors;

public class PlotArmor extends Armor {

    public PlotArmor(String armorName) {
        super(armorName);
        setBaseArmorDamageTakenPercentage(1);
        setArmorColor(ConsoleColors.MENU_COLOR_SANDY_BROWN);
        setRequiredStrength(0);
    }
}
