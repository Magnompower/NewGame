package Armor;

import java.util.ArrayList;

public class ArmorCreator {

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
        Armor hideOfOzra = new LegendaryArmor("Hide of Ozra"); // Ozra the legendary dragon

        armorPieces.add(poorBreastplate);
        armorPieces.add(commonBreastplate);
        armorPieces.add(uncommonBreastplate);

    }
}
