package weapons;

import ui.UI;
import ui.comparators.WeaponDamageComparator;
import weapons.inheritance.*;

import java.util.ArrayList;

public class WeaponCreator {
    UI ui = new UI();
    private final ArrayList<Weapon> weapons = new ArrayList<>();

    public void instantiateWeapons() {

        Weapon clubPoor = new PoorWeapon(WeaponType.ONEHANDED_MACE, "Poor club");
        Weapon clubCommon = new CommonWeapon(WeaponType.ONEHANDED_MACE, "Common club");
        Weapon clubUncommon = new UncommonWeapon(WeaponType.ONEHANDED_MACE, "Uncommon club");

        Weapon warHammerPoor = new PoorWeapon(WeaponType.TWOHANDED_MACE, "Poor war hammer");
        Weapon warHammerCommon = new CommonWeapon(WeaponType.TWOHANDED_MACE, "Common war hammer");
        Weapon warHammerUncommon = new UncommonWeapon(WeaponType.TWOHANDED_MACE, "Uncommon war hammer");


        Weapon shortSwordPoor = new PoorWeapon(WeaponType.ONEHANDED_SWORD, "Poor short sword");
        Weapon shortSwordCommon = new CommonWeapon(WeaponType.ONEHANDED_SWORD, "Common short sword");
        Weapon shortSwordUncommon = new UncommonWeapon(WeaponType.ONEHANDED_SWORD, "Uncommon short sword");


        Weapon longswordPoor = new PoorWeapon(WeaponType.TWOHANDED_SWORD, "Poor longsword");
        Weapon longswordCommon = new CommonWeapon(WeaponType.TWOHANDED_SWORD, "Common longsword");
        Weapon longswordUncommon = new UncommonWeapon(WeaponType.TWOHANDED_SWORD, "Uncommon longsword");


        Weapon staffOfMindorr = new RareWeapon(WeaponType.STAFF, "Staff of Mindorr");


        Weapon swordOfKeilier = new EpicWeapon(WeaponType.TWOHANDED_SWORD, "Sword of Keilier");


        Weapon axeOfOddie = new LegendaryWeapon(WeaponType.TWOHANDED_AXE, "Axe of Oddie");

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
        instantiateWeapons();
        for (Weapon specificWeapon : weaponsCopy) {
            if (specificWeapon.getWeaponName().equals(name)) {
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