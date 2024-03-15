package comparators;

import armor.inheritance.Armor;

import java.util.Comparator;

public class ArmorDamageTakenPercentageComparator implements Comparator<Armor> {
    @Override
    public int compare(Armor o1, Armor o2) {
        int armorDamageTakenPercentageComparison = o2.getBaseArmorDamageTakenPercentage() - o1.getBaseArmorDamageTakenPercentage();
        if (armorDamageTakenPercentageComparison != 0) {
            return armorDamageTakenPercentageComparison;
        }
            return o1.getArmorName().compareToIgnoreCase(o2.getArmorName());
    }
}
