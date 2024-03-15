package weapons;

import ui.UI;
import comparators.WeaponDamageComparator;
import weapons.inheritance.*;

import java.util.ArrayList;

public class WeaponCreator {
    UI ui = new UI();
    private final ArrayList<Weapon> weapons = new ArrayList<>();

    public void instantiateWeapons() {

        Weapon clubPoor = new PoorWeapon(WeaponType.ONEHANDEDMACE, "Poor club");
        Weapon clubCommon = new CommonWeapon(WeaponType.ONEHANDEDMACE, "Common club");
        Weapon clubUncommon = new UncommonWeapon(WeaponType.ONEHANDEDMACE, "Uncommon club");

        Weapon warHammerPoor = new PoorWeapon(WeaponType.TWOHANDEDMACE, "Poor war hammer");
        Weapon warHammerCommon = new CommonWeapon(WeaponType.TWOHANDEDMACE, "Common war hammer");
        Weapon warHammerUncommon = new UncommonWeapon(WeaponType.TWOHANDEDMACE, "Uncommon war hammer");


        Weapon shortSwordPoor = new PoorWeapon(WeaponType.ONEHANDEDSWORD, "Poor short sword");
        Weapon shortSwordCommon = new CommonWeapon(WeaponType.ONEHANDEDSWORD, "Common short sword");
        Weapon shortSwordUncommon = new UncommonWeapon(WeaponType.ONEHANDEDSWORD, "Uncommon short sword");


        Weapon longswordPoor = new PoorWeapon(WeaponType.TWOHANDEDSWORD, "Poor longsword");
        Weapon longswordCommon = new CommonWeapon(WeaponType.TWOHANDEDSWORD, "Common longsword");
        Weapon longswordUncommon = new UncommonWeapon(WeaponType.TWOHANDEDSWORD, "Uncommon longsword");


        Weapon staffOfMindorr = new RareWeapon(WeaponType.STAFF, "Staff of Mindorr");


        Weapon swordOfKeilier = new EpicWeapon(WeaponType.TWOHANDEDSWORD, "Sword of Keilier");


        Weapon axeOfOddie = new LegendaryWeapon(WeaponType.TWOHANDEDAXE, "Axe of Oddie");

        Weapon lilleLom = new ModWeapon(WeaponType.STAFF, "Lille Lom");

//        weapons.addAll(Weapon); TODO

        weapons.add(clubPoor);
        weapons.add(clubCommon);
        weapons.add(clubUncommon);

        weapons.add(warHammerPoor);
        weapons.add(warHammerCommon);
        weapons.add(warHammerUncommon);

        weapons.add(shortSwordPoor);
        weapons.add(shortSwordCommon);
        weapons.add(shortSwordUncommon);

        weapons.add(longswordPoor);
        weapons.add(longswordCommon);
        weapons.add(longswordUncommon);

        weapons.add(staffOfMindorr);

        weapons.add(swordOfKeilier);

        weapons.add(axeOfOddie);

        weapons.add(lilleLom);
    }

    ArrayList<Weapon> weaponsCopy = weapons;

    public Weapon getWeaponByName(String name) {
        for (Weapon specificWeapon : weaponsCopy) {
            if (specificWeapon.getWeaponName().equals(name)) {
                ui.printConfirmationGettingItem();
                return specificWeapon;
            }
        }
        ui.printErrorGettingitemMessage();
        return null;
    }

    public ArrayList<Weapon> getWeaponsCopyArraylistInOrder() {
        weaponsCopy.sort(new WeaponDamageComparator());
        return weaponsCopy;
    }

}