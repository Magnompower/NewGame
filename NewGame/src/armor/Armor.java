package armor;

import classes.ConsoleColors;
import enums.ArmorCondition;
import enums.WeaponCondition;

public abstract class Armor {
    private String armorName;
    private String armorColor; // TODO COLORSWITCH NOT WORKING SAME WITH WEAPON
    private int requiredStrength;
    private double damageReceived; // TODO RECEIVES INFO FROM ENEMY SOMEHOW MAYBE PUT IN PLAYER?
    private ArmorCondition armorCondition = ArmorCondition.DIRTY;
    private int baseArmorDamageTakenPercentage;
    private int actualArmorDamageTakenPercentage; //TODO INT HERE BUT DOUBLE OTHER PLACES!?

    public Armor(String armorName) {
        this.armorName = armorName;
    }

    // ------------------ SETTERS ------------------

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public void setActualArmorDamageTakenPercentage(double actualArmorDamageTakenPercentage) {
        if (actualArmorDamageTakenPercentage >= 100) {
            actualArmorDamageTakenPercentage = 99;
        }
        this.actualArmorDamageTakenPercentage = (int) Math.floor(actualArmorDamageTakenPercentage);
    }

    public void setArmorColor(String armorColor) {
        this.armorColor = armorColor;
    }

    public void setArmorCondition(ArmorCondition armorCondition) {
        if (armorCondition != null) this.armorCondition = armorCondition;
    }

    public void setRequiredStrength(int requiredStrength) {
        this.requiredStrength = requiredStrength;
    }

    public void setBaseArmorDamageTakenPercentage(int baseArmorDamageTakenPercentage) {
        this.baseArmorDamageTakenPercentage = baseArmorDamageTakenPercentage;
    }

    // ------------------ GETTERS ------------------

    public int getRequiredStrength() {
        return requiredStrength;
    }

    public double getActualArmorDamageTakenPercentage() {
        return actualArmorDamageTakenPercentage;
    }

    public String getArmorName() {
        return armorName;
    }


    public String getArmorColor() {
        return armorColor;
    }

    public ArmorCondition getArmorCondition() {
        return armorCondition;
    }

    public int getBaseArmorDamageTakenPercentage() {
        return baseArmorDamageTakenPercentage;
    }

    // ------------------ CALCULATE METHODS ------------------

    public void calculateActualArmorDamageTakenPercentage() { //TODO NEVER USED
        switch (armorCondition) { // TODO MAKE OTHER PLACES
            case BROKEN -> setActualArmorDamageTakenPercentage(baseArmorDamageTakenPercentage * 1.25);// 0,9 * 1,25 = >100
            case DIRTY -> setActualArmorDamageTakenPercentage(baseArmorDamageTakenPercentage * 1.1);
            case NORMAL -> setActualArmorDamageTakenPercentage(baseArmorDamageTakenPercentage);
            case POLISHED -> setActualArmorDamageTakenPercentage(baseArmorDamageTakenPercentage * 0.9);
            case REINFORCED -> setActualArmorDamageTakenPercentage(baseArmorDamageTakenPercentage * 0.75);
        }
    }

    public int calculateDamageReductionPercentage() {
        calculateActualArmorDamageTakenPercentage();
        int calculatedDamageReduction = 100 - actualArmorDamageTakenPercentage;
        return calculatedDamageReduction;
    }

    public int calculateDamageReceived() { //TODO PUT IN PLAYER?
        damageReceived = damageReceived * actualArmorDamageTakenPercentage;
        return (int) Math.floor(damageReceived);
    }


    private int calculateReinforcedArmorDamageTakenPercent() { //TODO MATH.FLOOR ALLE STEDER!!!.
        return (int) Math.floor(100 - baseArmorDamageTakenPercentage * 0.75); //TODO SAME TYPE OF MATH. WHEN SOUTING AND CALCULATING
    }


    // ------------------ OTHER ------------------

    @Override
    public String toString() {

        String colorCodeArmor = getArmorColor();
        String colorCodeNormalText = ConsoleColors.YELLOW_BRIGHT; //TODO CHANGE THE GENERAL YELLOW COLOR!
        String colorCodeArmorDefence = ConsoleColors.LIGHT_GOLD;
        String uniqueColor = ConsoleColors.SALMON;

        String requiredStrengthString = uniqueColor + "(" + ConsoleColors.LIGHT_GOLD + getRequiredStrength() + uniqueColor + ")";

        String armorDetails = String.format("%sArmor:  %s   %s%-20.20s%s:%s%2s%s%s|%s%2s%s%s Reduction%s",
                colorCodeNormalText, requiredStrengthString, colorCodeArmor, armorName, colorCodeNormalText,
                colorCodeArmorDefence, calculateDamageReductionPercentage(), "%", uniqueColor, colorCodeArmorDefence,
                calculateReinforcedArmorDamageTakenPercent(), "%", uniqueColor, ConsoleColors.RESET);
        if (!armorCondition.equals(WeaponCondition.NORMAL)) {
            armorDetails += String.format("%s : %s%s%s", colorCodeNormalText, armorCondition.getArmorConditionColor(),
                    armorCondition.getArmorConditionText(), ConsoleColors.RESET);
        }
        return armorDetails;
    }
}
