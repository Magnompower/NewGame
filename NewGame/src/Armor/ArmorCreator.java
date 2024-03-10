package Armor;

public class ArmorCreator {
    public void instantiateArmor() { //TODO

        Armor poorBreastplate = new PoorArmor("Poor breastplate");
        Armor commonBreastplate = new CommonArmor("Common breastplate");
        Armor uncommonBreastplate = new UncommonArmor("Uncommon breastplate");
        Armor rareBreastplate = new RareArmor("Rare breastplate");
        Armor breastplateOfKeilier = new EpicArmor("Breastplate of Keilier");
        Armor breastplateOfOddie = new LegendaryArmor("Breastplate of Oddie");
    }
}
