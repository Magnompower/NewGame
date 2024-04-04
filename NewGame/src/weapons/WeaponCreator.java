package weapons;

import ui.UI;
import ui.comparators.WeaponDamageComparator;
import weapons.inheritance.*;

import java.util.ArrayList;

public class WeaponCreator {
    UI ui = new UI();
    private final ArrayList<Weapon> weaponsArrayList = new ArrayList<>();

    public void instantiateWeapons() {

        Weapon poorDagger = new PoorWeapon(WeaponType.ONEHANDED_DAGGER, "Poor dagger");

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

        weaponsArrayList.add(poorDagger);

        weaponsArrayList.add(clubPoor);
        weaponsArrayList.add(clubCommon);
        weaponsArrayList.add(clubUncommon);

        weaponsArrayList.add(warHammerPoor);
        weaponsArrayList.add(warHammerCommon);
        weaponsArrayList.add(warHammerUncommon);

        weaponsArrayList.add(shortSwordPoor);
        weaponsArrayList.add(shortSwordCommon);
        weaponsArrayList.add(shortSwordUncommon);

        weaponsArrayList.add(longswordPoor);
        weaponsArrayList.add(longswordCommon);
        weaponsArrayList.add(longswordUncommon);

        weaponsArrayList.add(staffOfMindorr);

        weaponsArrayList.add(swordOfKeilier);

        weaponsArrayList.add(axeOfOddie);

        weaponsArrayList.add(lilleLom);
    }

    ArrayList<Weapon> weaponsArrayListCopy = weaponsArrayList;

    public Weapon getWeaponByName(String weaponName) {
        instantiateWeapons();
        for (Weapon specificWeapon : weaponsArrayListCopy) {
            if (specificWeapon.getWeaponName().equals(weaponName)) {
                return specificWeapon;
            }
        }
        ui.printErrorGettingitemMessage();
        return null;
    }

    public ArrayList<Weapon> getWeaponsCopyArraylistInOrder() {
        weaponsArrayListCopy.sort(new WeaponDamageComparator());
        return weaponsArrayListCopy;
    }

}