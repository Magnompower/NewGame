package weapons;

import classes.ConsoleColors;
import enums.WeaponType;

public class RareWeapon extends Weapon{
    public RareWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setWeaponDamage(8);
        setWeaponColor(ConsoleColors.BLUE_BRIGHT);
    }
}