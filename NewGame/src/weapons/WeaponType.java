package weapons;

public enum WeaponType {
    // One-handed == AGI. Two-handed == STR STAFF == INT/STR/AGI
    ONEHANDED_SWORD("AGI"),
    ONEHANDED_AXE("AGI"),
    ONEHANDED_MACE("AGI"),
    ONEHANDED_DAGGER("AGI"),
    TWOHANDED_SWORD("STR"),
    TWOHANDED_MACE("STR"),
    TWOHANDED_AXE("STR"),
    STAFF("INT, STR, AGI"),
    ;

    private final String modifier;

    WeaponType(String modifier) {
        this.modifier = modifier;
    }

    public String getModifier() {
        return modifier;
    }
}
