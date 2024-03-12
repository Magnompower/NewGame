package weapons;

import classes.ConsoleColors;
import enums.WeaponType;

public class CommonWeapon extends Weapon {


    public CommonWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(5);
        setWeaponColor(ConsoleColors.WHITE_BRIGHT);
    }
}