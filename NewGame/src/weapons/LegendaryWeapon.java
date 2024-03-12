package weapons;

import classes.ConsoleColors;
import enums.WeaponType;

public class LegendaryWeapon extends Weapon{

    public LegendaryWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(15);
        setWeaponColor(ConsoleColors.ORANGE);
    }
}
