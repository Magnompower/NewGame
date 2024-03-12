package weapons;

        import classes.ConsoleColors;
        import enums.WeaponType;

public class EpicWeapon extends Weapon{
    public EpicWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(10);
        setWeaponColor(ConsoleColors.PURPLE_BRIGHT);
    }
}