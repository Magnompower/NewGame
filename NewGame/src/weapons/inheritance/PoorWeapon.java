package weapons.inheritance;

import ui.ConsoleColors;
import weapons.WeaponType;

public class PoorWeapon extends Weapon{
    public PoorWeapon(WeaponType weaponType, String weaponName) {
        super(weaponType,weaponName);
        setBaseWeaponDamage(6);
        setWeaponColor(ConsoleColors.GREY);
    }
}