package classes;

public class Player {
    private int playerPositionX = 15;
    private int playerPositionY = 15;
    private int playerLevel=1;
    private int playerStrength = 10;
    private int playerIntelligence = 10;
    private int playerAgility = 10;
    private int playerStamina = 10;
    private int playerHealtPoints = playerLevel * 5 +playerStamina*3;
    Weapon playerWeapon;
    private int playerDamage;



    public void validatePlayerHealth() {
        if (playerHealtPoints <= 0) {
//            gamerunning=false;
        }
    }

    public int calculatePlayerDamage(int playerDamage) {
        playerDamage = playerLevel + playerWeapon.getCalculatedWeaponDamage();
        if (playerWeapon.getWeaponType().equals("STR")) {
            playerDamage = playerDamage + playerStrength / 2;
        }
        if (playerWeapon.getWeaponType().equals("AGI")) {
            playerDamage = playerDamage + playerAgility / 2;
        }
        if (playerWeapon.getWeaponType().equals("INT")) {
            playerDamage = playerDamage + playerIntelligence / 2;
        }
        return playerDamage;
    }

    public void attack() {
        calculatePlayerDamage(playerDamage);
        System.out.println("You attack. You deal " + playerDamage + " points of damage.");

    }

    public void flee() {
    }
}
