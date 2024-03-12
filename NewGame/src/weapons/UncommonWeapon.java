package weapons;

import classes.ConsoleColors;
import enums.WeaponType;

public class UncommonWeapon extends Weapon{

    public UncommonWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(6);
        setWeaponColor(ConsoleColors.GREEN_BRIGHT);
    }
}