package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponType;

public class RareWeapon extends Weapon{
    public RareWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(8);
        setWeaponColor(ConsoleColors.BLUE_BRIGHT);
    }
}