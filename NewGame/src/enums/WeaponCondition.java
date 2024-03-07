package enums;

import classes.ConsoleColors;

public enum WeaponCondition {
    BROKEN(ConsoleColors.GREY,"Broken"),
    RUSTY(ConsoleColors.WHITE_BRIGHT,"Rusty"),
    NORMAL(ConsoleColors.YELLOW_BRIGHT,""),
    POLISHED(ConsoleColors.PURPLE_BRIGHT,"Polished"),
    SHARP(ConsoleColors.ORANGE,"Sharp");

    private final String weaponColor;
    private final String weaponConditionText; // TODO FINAL?

    WeaponCondition(String weaponColor, String weaponConditionText) {
        this.weaponColor = weaponColor;
        this.weaponConditionText = weaponConditionText;
    }

    public String getWeaponConditionColor() {
        return weaponColor;
    }

    public String getWeaponConditionText() {
        return weaponConditionText;
    }
}