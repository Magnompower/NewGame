package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponType;

public class CommonWeapon extends Weapon {


    public CommonWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(5);
        setWeaponColor(ConsoleColors.WHITE_BRIGHT);
    }
}