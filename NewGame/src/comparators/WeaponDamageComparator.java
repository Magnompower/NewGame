package comparators;

import weapons.Weapon;

import java.util.Comparator;

public class WeaponDamageComparator implements Comparator<Weapon> {

    @Override
    public int compare(Weapon o1, Weapon o2) {
        int weaponDamageComparison = (int) (o1.getBaseWeaponDamage() - o2.getBaseWeaponDamage());
        if (weaponDamageComparison != 0) {
           return weaponDamageComparison;
        }
        return o1.getWeaponName().compareToIgnoreCase(o2.getWeaponName());
    }
    // TODO MAYBE FUN TO COMPARE TO COLOR?
}
