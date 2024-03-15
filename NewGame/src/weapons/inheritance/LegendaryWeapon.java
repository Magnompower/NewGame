package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponType;

public class LegendaryWeapon extends Weapon{

    public LegendaryWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType, weaponName);
        setBaseWeaponDamage(15);
        setWeaponColor(ConsoleColors.ORANGE);
    }
}
