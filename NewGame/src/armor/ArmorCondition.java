package armor;

import ui.ConsoleColors;

public enum ArmorCondition {
    BROKEN(ConsoleColors.GREY,"Broken"),
    DIRTY(ConsoleColors.WHITE_BRIGHT,"Dirty"),
    NORMAL(ConsoleColors.YELLOW_BRIGHT,"Normal"), // TODO REMOVE HERE AND WEPCON?
    POLISHED(ConsoleColors.PURPLE_BRIGHT,"Polished"),
    REINFORCED(ConsoleColors.ORANGE,"Reinforced");

    private final String armorConditionColor;
    private final String armorConditionText; // TODO FINAL?

    ArmorCondition(String armorConditionColor, String armorConditionText) {
        this.armorConditionColor = armorConditionColor;
        this.armorConditionText = armorConditionText;
    }

    public String getArmorConditionColor() {
        return armorConditionColor;
    }

    public String getArmorConditionText() {
        return armorConditionText;
    }

}