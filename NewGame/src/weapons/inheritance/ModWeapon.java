package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponType;

public class ModWeapon extends Weapon {

    public ModWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(60);
        setWeaponColor(ConsoleColors.MENU_COLOR_SANDY_BROWN);
    }
}
