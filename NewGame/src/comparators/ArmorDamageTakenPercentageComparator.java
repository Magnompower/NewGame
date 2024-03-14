package comparators;

import armor.Armor;

import java.util.Comparator;

public class ArmorDamageTakenPercentageComparator implements Comparator<Armor> {
    @Override
    public int compare(Armor o1, Armor o2) {
        int armorDamageTakenPercentageComparison = o1.getBaseArmorDamageTakenPercentage() - o2.getBaseArmorDamageTakenPercentage();
        if (armorDamageTakenPercentageComparison != 0) {
            return armorDamageTakenPercentageComparison;
        }
            return o1.getArmorName().compareToIgnoreCase(o2.getArmorName());
    }
}
