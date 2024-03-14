package enums;

public enum WeaponType {
    // One-handed == AGI. Two-handed == STR STAFF == INT/STR/AGI
    ONEHANDEDSWORD("AGI"),
    ONEHANDEDAXE("AGI"),
    ONEHANDEDMACE("AGI"),
    TWOHANDEDSWORD("STR"),
    TWOHANDEDMACE("STR"),
    TWOHANDEDAXE("STR"),
    STAFF("INT, STR, AGI"),
    DAGGER("AGI"),
    ;

    private final String modifier;

    WeaponType(String modifier){
        this.modifier=modifier;
    }

    public String getModifier() {
        return modifier;
    }
}
