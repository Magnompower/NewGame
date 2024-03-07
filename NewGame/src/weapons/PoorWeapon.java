package weapons;

import classes.ConsoleColors;
import enums.WeaponType;

public class PoorWeapon extends Weapon{
    public PoorWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType,weaponName);
        setWeaponDamage(6);
        setWeaponColor(ConsoleColors.GREY);

    }
}