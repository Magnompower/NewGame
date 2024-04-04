package armor;

import armor.inheritance.*;
import ui.UI;
import ui.comparators.ArmorDamageTakenPercentageComparator;

import java.util.ArrayList;

public class ArmorCreator {
    UI ui = new UI();
    private final ArrayList<Armor> armorPiecesArrayList = new ArrayList<>();

    public void instantiateArmor() { //TODO

        Armor poorKilt = new PoorArmor("Poor kilt");

        Armor poorBreastplate = new PoorArmor("Poor breastplate");
        Armor commonBreastplate = new CommonArmor("Common breastplate");
        Armor uncommonBreastplate = new UncommonArmor("Uncommon breastplate");

        Armor poorLeatherArmor = new PoorArmor("Poor leather armor");
        Armor commonLeatherArmor = new CommonArmor("Common leather armor");
        Armor uncommonLeatherArmor = new UncommonArmor("Uncommon leather armor");

        Armor poorChainmail = new PoorArmor("Poor chainmail");
        Armor commonChainmail = new CommonArmor("Common chainmail");
        Armor uncommonChainmail = new UncommonArmor("Uncommon chainmail");

        Armor poorSplint = new PoorArmor("Poor splint");
        Armor commonSplint = new CommonArmor("Common splint");
        Armor uncommonSplint = new UncommonArmor("Uncommon splint");

        Armor breastplateOfBeebus = new RareArmor("Breastplate of Beebus");
        Armor wickedChainmail = new RareArmor("Wicked chainmail");

        Armor breastplateOfKeilier = new EpicArmor("Breastplate of Keilier");
        Armor splintOfKeilier = new EpicArmor("Splint of Keilier");

        Armor breastplateOfOddie = new LegendaryArmor("Breastplate of Oddie");
        Armor hideOfOzra = new LegendaryArmor("Hide of Ozra"); // Ozra the legendary dragon TODO MAKE

        Armor pyjamas = new PlotArmor("Pyjamas");

        armorPiecesArrayList.add(poorKilt);

        armorPiecesArrayList.add(poorBreastplate);
        armorPiecesArrayList.add(commonBreastplate);
        armorPiecesArrayList.add(uncommonBreastplate);

        armorPiecesArrayList.add(poorLeatherArmor);
        armorPiecesArrayList.add(commonLeatherArmor);
        armorPiecesArrayList.add(uncommonLeatherArmor);

        armorPiecesArrayList.add(poorChainmail);
        armorPiecesArrayList.add(commonChainmail);
        armorPiecesArrayList.add(uncommonChainmail);

        armorPiecesArrayList.add(poorSplint);
        armorPiecesArrayList.add(commonSplint);
        armorPiecesArrayList.add(uncommonSplint);

        armorPiecesArrayList.add(breastplateOfBeebus);
        armorPiecesArrayList.add(wickedChainmail);

        armorPiecesArrayList.add(breastplateOfKeilier);
        armorPiecesArrayList.add(splintOfKeilier);

        armorPiecesArrayList.add(breastplateOfOddie);
        armorPiecesArrayList.add(hideOfOzra);

        armorPiecesArrayList.add(pyjamas);
    }

    ArrayList<Armor> armorPiecesArrayListCopy = armorPiecesArrayList;

    public Armor getArmorByName(String armorPieceName) {
        instantiateArmor();
        for (Armor specificArmorPiece : armorPiecesArrayListCopy) {
            if (specificArmorPiece.getArmorName().equals((armorPieceName))) {
                return specificArmorPiece;
            }
        }
        ui.printErrorGettingitemMessage();
        return null; // Somehow return the message is better? TODO
    }

    public ArrayList<Armor> getArmorPiecesCopyArraylistInOrder() {
        armorPiecesArrayListCopy.sort(new ArmorDamageTakenPercentageComparator());
        return armorPiecesArrayListCopy;
    }

}
