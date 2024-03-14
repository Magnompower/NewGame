package armor;

import classes.UI;
import comparators.ArmorDamageTakenPercentageComparator;

import java.util.ArrayList;

public class ArmorCreator {
    UI ui;
    private final ArrayList<Armor> armorPieces = new ArrayList<>();

    public void instantiateArmor() { //TODO

        Armor poorBreastplate = new PoorArmor("Poor breastplate");
        Armor commonBreastplate = new CommonArmor("Common breastplate");
        Armor uncommonBreastplate = new UncommonArmor("Uncommon breastplate");

        Armor poorLeatherArmor = new PoorArmor("Poor leather armor");
        Armor commonLeatherArmor = new CommonArmor("Common leather armor");
        Armor uncommonLeatherArmor = new UncommonArmor("Uncommon leather armor");

        Armor poorChainmail = new PoorArmor("Poor chainmail");
        Armor commonChainmail = new CommonArmor("Common chainmail");
        Armor uncommonChainmail = new UncommonArmor("Uncommon chainmail");

        Armor poorSplint = new PoorArmor("Poor Splint");
        Armor commonSplint = new CommonArmor("Common Splint");
        Armor uncommonSplint = new UncommonArmor("Uncommon Splint");

        Armor breastplateOfBeebus = new RareArmor("Breastplate of Beebus");
        Armor wickedChainmail = new RareArmor("Wicked chainmail");

        Armor breastplateOfKeilier = new EpicArmor("Breastplate of Keilier");
        Armor splintOfKeilier = new EpicArmor("Splint of Keilier");

        Armor breastplateOfOddie = new LegendaryArmor("Breastplate of Oddie");
        Armor hideOfOzra = new LegendaryArmor("Hide of Ozra"); // Ozra the legendary dragon TODO MAKE

        armorPieces.add(poorBreastplate);
        armorPieces.add(commonBreastplate);
        armorPieces.add(uncommonBreastplate);

        armorPieces.add(poorLeatherArmor);
        armorPieces.add(commonLeatherArmor);
        armorPieces.add(uncommonLeatherArmor);

        armorPieces.add(poorChainmail);
        armorPieces.add(commonChainmail);
        armorPieces.add(uncommonChainmail);

        armorPieces.add(poorSplint);
        armorPieces.add(commonSplint);
        armorPieces.add(uncommonSplint);

        armorPieces.add(breastplateOfBeebus);
        armorPieces.add(wickedChainmail);

        armorPieces.add(breastplateOfKeilier);
        armorPieces.add(splintOfKeilier);

        armorPieces.add(breastplateOfOddie);
        armorPieces.add(hideOfOzra);

    }

    ArrayList<Armor> armorPiecesCopy = armorPieces;

    public Armor getArmorByName(String name) {
        for (Armor specificArmorPiece : armorPiecesCopy) {
            if (specificArmorPiece.getArmorName().equals((name))) {
                return specificArmorPiece;
            }
        }
        ui.printErrorGettingArmorMessage();
        return null; // Somehow return the message is better?
    }


    public ArrayList<Armor> getArmouryCopyArraylistInOrder() {
        armorPiecesCopy.sort(new ArmorDamageTakenPercentageComparator());
        return armorPiecesCopy;
    }

}
