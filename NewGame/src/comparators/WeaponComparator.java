package comparators;

import classes.Weapon;

import java.util.Comparator;

public class WeaponComparator implements Comparator<Weapon> {

    @Override
    public int compare(Weapon o1, Weapon o2) {
        if (o1.getWeaponRarity().compareTo(o2.getWeaponRarity()) == 0) {
            if (o1.getCalculatedWeaponDamage()-o2.getCalculatedWeaponDamage() != 0) {
                return o1.getWeaponName().compareTo(o2.getWeaponName());
            }
            return o1.getCalculatedWeaponDamage()-o2.getCalculatedWeaponDamage();
        }
        return o1.getWeaponRarity().compareTo(o2.getWeaponRarity());
    }
}
