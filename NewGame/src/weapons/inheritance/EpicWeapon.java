package weapons.inheritance;

        import ui.ConsoleColors;
        import weapons.WeaponType;

public class EpicWeapon extends Weapon{
    public EpicWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(10);
        setWeaponColor(ConsoleColors.PURPLE_BRIGHT);
    }
}