package enums;

import classes.ConsoleColors;

public enum ArmorCondition {
    BROKEN(ConsoleColors.GREY, "Broken"),
    DIRTY(ConsoleColors.WHITE_BRIGHT, "Dirty"),
    NORMAL(ConsoleColors.YELLOW_BRIGHT, ""),
    POLISHED(ConsoleColors.PURPLE_BRIGHT, "Polished"),
    SHINING(ConsoleColors.ORANGE, "Shining");

    private final String armorColor;
    private final String armorConditionText; // TODO FINAL?

    ArmorCondition(String armorColor, String armorConditionText) {
        this.armorColor = armorColor;
        this.armorConditionText = armorConditionText;
    }

    public String getArmorColor() {
        return armorColor;
    }

    public String getArmorConditionText() {
        return armorConditionText;
    }

}