package weapons;

import enums.WeaponType;

import java.util.ArrayList;

public class WeaponCreator {
    private ArrayList<Weapon> weapons = new ArrayList<>();

    public void InstantiateWeapons() {
        Weapon clubPoor = new PoorWeapon(WeaponType.ONEHANDEDMACE, "Poor Club");
        Weapon clubCommon = new CommonWeapon(WeaponType.ONEHANDEDMACE, "Common Club");
        Weapon clubUncommon = new UncommonWeapon(WeaponType.ONEHANDEDMACE, "Uncommon Club");

        Weapon warHammerPoor = new PoorWeapon(WeaponType.TWOHANDEDMACE, "Poor Warhammer");
        Weapon warHammerCommon = new CommonWeapon(WeaponType.TWOHANDEDMACE, "Common Warhammer");
        Weapon warHammerUncommon = new UncommonWeapon(WeaponType.TWOHANDEDMACE, "Uncommon Warhammer");


        Weapon shortSwordPoor = new PoorWeapon(WeaponType.ONEHANDEDSWORD, "Poor Shortsword");
        Weapon shortSwordCommon = new CommonWeapon(WeaponType.ONEHANDEDSWORD, "Common Shortsword");
        Weapon shortSwordUncommon = new UncommonWeapon(WeaponType.ONEHANDEDSWORD, "Uncommon Shortsword");


        Weapon longswordPoor = new PoorWeapon(WeaponType.TWOHANDEDSWORD, "Poor Longsword");
        Weapon longswordCommon = new CommonWeapon(WeaponType.TWOHANDEDSWORD, "Common Longsword");
        Weapon longswordUncommon = new UncommonWeapon(WeaponType.TWOHANDEDSWORD, "Uncommon Longsword");


        Weapon staffOfMindorr = new RareWeapon(WeaponType.STAFF, "Staff of Mindorr");


        Weapon swordOfKeilier = new EpicWeapon(WeaponType.TWOHANDEDSWORD, "Sword of Keilier");


        Weapon axeOfOddie = new LegendaryWeapon(WeaponType.TWOHANDEDAXE, "Axe of Oddie");

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
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

}
