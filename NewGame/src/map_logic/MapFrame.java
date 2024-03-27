package map_logic;

import armor.inheritance.Armor;
import armor.ArmorCreator;
import enemies.inheritance.Enemy;
import enemies.EnemyCreator;
import ui.UI;
import weapons.inheritance.Weapon;
import weapons.WeaponCreator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;

public final class MapFrame extends JFrame {
    private final EnemyCreator enemyCreator = new EnemyCreator();
    private final WeaponCreator weaponCreator = new WeaponCreator();// TODO needed here? = new WeaponCreator(); need instatiation?
    private final ArmorCreator armorCreator = new ArmorCreator();
    static MapFrame instance; // Singleton instance
    UI ui = new UI();
    private final int mapSize = 31;
    Random random = new Random();
    private final Set<Point> visitedLocations = new HashSet<>(); // Keeps track of visited locations
    private final Set<Point> revealedLocations = new HashSet<>(); // Keeps trac of locations visible to the player
    private final Map<Point, MapElement> specialLocations = new HashMap<>(); // All special locations
    private Map<Point, Enemy> enemyLocations = new HashMap<>(); // Designate enemies posistions on the map TODO
    private Map<Point, Weapon> weaponLocations = new HashMap<Point, Weapon>();
    private Map<Point, Armor> armorLocations = new HashMap<>();

    private final Set<Point> cityLocations = new HashSet<>(Arrays.asList(

            new Point(15, 11), // Haewen City

            new Point(6, 18),

            new Point(26, 25), // Hube City
            new Point(26, 26),
            new Point(27, 25),
            new Point(27, 26),

            new Point(23, 1), // Waeeg City
            new Point(24, 1)

    ));
    private final Set<Point> hubeCityLocations = new HashSet<>(Arrays.asList(
            new Point(26, 25),
            new Point(26, 26),
            new Point(27, 25),
            new Point(27, 26)
    ));

    private final Set<Point> waeegCityLocations = new HashSet<>(Arrays.asList(
            new Point(23, 1),
            new Point(24, 1)
    ));
    private boolean hubeCityDiscovered;
    private boolean waeegCityDiscovered;

    public void placeEnemiesOnMapLocations() {
        enemyLocations.put(finalBossZlatsLocation, enemyCreator.getEnemiesByName("Hungry Zlats"));
        enemyLocations.put(bossBlobLocation, enemyCreator.getEnemiesByName("BLOB"));
//        enemyLocations.put(bossMossLocation,enemyCreator.getEnemiesByName("Moss the mad")); TODO

        enemyLocations.put(legendaryEnemyHusasanLocation, enemyCreator.getEnemiesByName("HUSASAN"));
//        enemyLocations.put(legendaryEnemyHusseinLocation,enemyCreator.getEnemiesByName("Hussein"));
//        enemyLocations.put(legendaryEnemyHasanLocation,enemyCreator.getEnemiesByName("Hasan"));
//
//        enemyLocations.put(epicEnemyAndersLocation,enemyCreator.getEnemiesByName("Anders the duck"));
//        enemyLocations.put(epicEnemyOttoLocation,enemyCreator.getEnemiesByName("Otto Otto"));
//        enemyLocations.put(epicEnemyElephantLocation,enemyCreator.getEnemiesByName("Elephant"));

//        enemyLocations.put(rareEnemyTigerLocation,enemyCreator.getEnemiesByName("Tiger"));
//        enemyLocations.put(rareEnemyBearLocation,enemyCreator.getEnemiesByName("Bear"));
//        enemyLocations.put(rareEnemyCentaurLocation,enemyCreator.getEnemiesByName("Centaur"));


    }

    public void placeWeaponsOnMapLocations() {
        weaponLocations.put(haewenCityLocation, weaponCreator.getWeaponByName("Common longsword"));
        weaponLocations.put(pointOfInterest5, weaponCreator.getWeaponByName("Sword of Keilier"));
    }

    // TODO SoK ON PoI1!
    public void placeArmorOnMapLocations() {
        armorLocations.put(haewenCityLocation, armorCreator.getArmorByName("Common splint"));
        armorLocations.put(pointOfInterest5, armorCreator.getArmorByName("Splint of Keilier"));
    }

    private final Point playerStartLocationOnMap = new Point(15, 15);

    private final Point haewenCityLocation = new Point(15, 11);
    private final Point logeCityLocation = new Point(6, 18);
    private final Point waeegCityLocationWest = new Point(23, 1);
    private final Point waeegCityLocationEast = new Point(24, 1);
    private final Point hubeCityNorthWestLocation = new Point(26, 25);
    private final Point hubeCityNorthEastLocation = new Point(27, 25);
    private final Point hubeCitySouthWestLocation = new Point(26, 26);
    private final Point hubeCitySouthEastLocation = new Point(27, 26);

    private final Point pointOfInterest1 = new Point(0, 0);
    private final Point pointOfInterest2 = new Point(19, 4);
    private final Point pointOfInterest3 = new Point(10, 8);
    private final Point pointOfInterest4 = new Point(27, 11);
    private final Point pointOfInterest5 = new Point(15, 18);
    private final Point pointOfInterest6 = new Point(5, 24);
    private final Point pointOfInterest7 = new Point(30, 29);

    private final Point suspiciousArea1 = new Point(3, 3);
    private final Point suspiciousArea2 = new Point(24, 5);
    private final Point suspiciousArea3 = new Point(4, 10);
    private final Point suspiciousArea4 = new Point(22, 12);
    private final Point suspiciousArea5 = new Point(10, 18);
    private final Point suspiciousArea6 = new Point(22, 20);
    private final Point suspiciousArea7 = new Point(18, 27);

    private final Point legendaryEnemyHusasanLocation = new Point(0, 17);

    private final Point bossBlobLocation = new Point(3, 28);
    private final Point finalBossZlatsLocation = new Point(30, 0);

    private MapFrame() { // Private constructor to prevent instantiation
        revealedLocations.add(haewenCityLocation); // Initially visible.
        visitedLocations.add(playerStartLocationOnMap); // Initially visible.

        placeEnemiesOnMapLocations();
        placeWeaponsOnMapLocations();
        placeArmorOnMapLocations();

        specialLocations.put(haewenCityLocation, MapElement.CITIES);
        specialLocations.put(logeCityLocation, MapElement.CITIES);
        specialLocations.put(waeegCityLocationWest, MapElement.CITIES);
        specialLocations.put(waeegCityLocationEast, MapElement.CITIES);
        specialLocations.put(hubeCityNorthWestLocation, MapElement.CITIES);
        specialLocations.put(hubeCityNorthEastLocation, MapElement.CITIES);
        specialLocations.put(hubeCitySouthWestLocation, MapElement.CITIES);
        specialLocations.put(hubeCitySouthEastLocation, MapElement.CITIES);

        specialLocations.put(pointOfInterest1, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest2, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest3, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest4, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest5, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest6, MapElement.POINT_OF_INTEREST);
        specialLocations.put(pointOfInterest7, MapElement.POINT_OF_INTEREST);

        specialLocations.put(suspiciousArea1, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea2, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea3, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea4, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea5, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea6, MapElement.SUSPICIOUS_AREA);
        specialLocations.put(suspiciousArea7, MapElement.SUSPICIOUS_AREA);

        specialLocations.put(legendaryEnemyHusasanLocation, MapElement.LEGENDARY_ENEMY);

        specialLocations.put(finalBossZlatsLocation, MapElement.BOSS_ENEMY);
        specialLocations.put(bossBlobLocation, MapElement.BOSS_ENEMY);

        createMapFrame();
    }

    public static MapFrame getInstance() { // Singleton
        if (instance == null) {
            instance = new MapFrame();
        }
        return instance;
    }

    public void createMapFrame() {
        setTitle("Dusty Map");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(550, 550);
        setLocation(1000, 50);
        setLayout(new GridLayout(mapSize, mapSize));
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                JPanel panel = new JPanel();
                Point currentPoint = new Point(x, y);
                MapElement element = specialLocations.getOrDefault(currentPoint, MapElement.UNVISITED);

                if (revealedLocations.contains(currentPoint)) { // COLORS VISIBLE LOCATIONS
                    panel.setBackground(element.getColor());
                } else if (x == 15 & y == 15) {
                    panel.setBackground(MapElement.PLAYER_LOCATION.getColor());
                } else {
                    panel.setBackground(MapElement.UNVISITED.getColor()); // Default unexplored color
                }

                panel.setBorder(BorderFactory.createLineBorder(MapElement.DEFAULT_BORDER.getColor())); // Default border color
                add(panel);
            }
        }
    }

    public void makeMapVisible() {
        setVisible(true);
    }

    public void makeMapInvisible() {
        setVisible(false);
    }

    public String updatePlayerPosition(int playerPositionX, int playerPositionY, int playerLevel) { // TODO DÅRLIG METODE? OPMÆRKOSM PÅ RÆKKEFØLGEN
        Point currentPlayerLocation = new Point(playerPositionX, playerPositionY);
        StringBuilder result = new StringBuilder();

        if (!visitedLocations.contains(currentPlayerLocation)) {
            int randomNumber = random.nextInt(11);
            if (randomNumber >= 5) {
                Enemy enemyToSpawn = decideEnemyBasedOnLevel(playerLevel);
                enemyLocations.put(currentPlayerLocation, enemyToSpawn);
                ui.printCombatInfo(enemyToSpawn.getEnemyColor() + enemyToSpawn.getEnemyName());
                result.append("Combat"); // Combat
                if (result.length() > 0) result.append(", "); //TODO MAKE SMARTER
            }
        }
        if (visitedLocations.contains(haewenCityLocation)) {
            revealNewLocationsFromHaewenCity(); // Boss, cities and points of interest.
        }
        if (visitedLocations.contains(logeCityLocation)) {
            revealNewLocationsFromLogeCity();
        }
        if (visitedLocations.contains(waeegCityLocationWest) || visitedLocations.contains(waeegCityLocationEast)) {
            revealNewLocationsFromWaeegCity();
        }
        if (visitedLocations.contains(hubeCityNorthWestLocation) || visitedLocations.contains(hubeCityNorthEastLocation)
                || visitedLocations.contains(hubeCitySouthWestLocation) || visitedLocations.contains(hubeCitySouthEastLocation)) {
            revealNewLocationsFromHubeCity();
        }
        if (visitedLocations.contains(pointOfInterest3)) {
            revealNewLocationsFromPointOfInterest3();
        }
        if (visitedLocations.contains(suspiciousArea3)) {
            revealNewLocationsFromSuspiciousArea3();
        }
        if (visitedLocations.contains(suspiciousArea5)) {
            revealNewLocationsFromSuspiciousArea5();
        }

        Component[] components = getContentPane().getComponents();
        int playerIndex = playerPositionY * mapSize + playerPositionX;

        for (Point point : visitedLocations) { // Color visited locations.
            int visitedIndex = point.y * mapSize + point.x;
            if (visitedIndex >= 0 && visitedIndex < components.length &&
                    !(visitedIndex >= 0 && visitedIndex < playerPositionY)) {
                JPanel visitedPanel = (JPanel) components[visitedIndex];

                if (cityLocations.contains(point)) {
                    visitedPanel.setBackground(MapElement.CITIES.getColor());
                } else if (specialLocations.containsKey(point)) {
                    visitedPanel.setBackground(MapElement.VISITED_SPECIAL_LOCATION.getColor());
                } else if (visitedIndex != playerIndex) {
                    visitedPanel.setBackground(MapElement.VISITED.getColor());
                }
            }
        }

        if (playerIndex >= 0 && playerIndex < components.length) { // Color player location
            JPanel playerPanel = (JPanel) components[playerIndex];
            playerPanel.setBackground(MapElement.PLAYER_LOCATION.getColor());
        }

        if (enemyLocations.containsKey(currentPlayerLocation)) {
            // bossfight or legendary
        }
        if (weaponLocations.containsKey(currentPlayerLocation) && !visitedLocations.contains(currentPlayerLocation)) {
            Weapon weapon = weaponLocations.get(currentPlayerLocation);
            result.append(ui.printWeaponOnLocation(weapon));
            if (result.length() > 0) result.append(", ");
        }
        if (armorLocations.containsKey(currentPlayerLocation) && !visitedLocations.contains(currentPlayerLocation)) {
            Armor armor = armorLocations.get(currentPlayerLocation);
            result.append(ui.printArmorOnLocation(armor));
        }

        visitedLocations.add(currentPlayerLocation);
        if (result.isEmpty()) {
            result.append("Nothing");
        }
        return result.toString(); //TODO
    }

    private Enemy decideEnemyBasedOnLevel(int playerLevel) {
        int randomNumber = random.nextInt(3);
        if (playerLevel < 5) {
            if (randomNumber == 0) {
                return enemyCreator.getEnemiesByName("Bandit");
            }
            if (randomNumber == 1) {
                return enemyCreator.getEnemiesByName("Dog");
            }
            if (randomNumber == 2) {
                return enemyCreator.getEnemiesByName("Honey badger");
            }
        }
        if (playerLevel > 4 && playerLevel < 10) {
            if (randomNumber == 0) {
                return enemyCreator.getEnemiesByName("Wolf");
            }
            if (randomNumber == 1) {
                return enemyCreator.getEnemiesByName("Zombie");
            }
            if (randomNumber == 2) {
                return enemyCreator.getEnemiesByName("Skeleton");
            }
        }
        if (playerLevel > 9 && playerLevel < 15) {
            if (randomNumber == 0) {
                return enemyCreator.getEnemiesByName("Centaur");
            }
            if (randomNumber == 1) {
                return enemyCreator.getEnemiesByName("Bear");
            }
            if (randomNumber == 2) {
                return enemyCreator.getEnemiesByName("Tiger");
            }
        }
        if (playerLevel > 14) {
            if (randomNumber == 0) {
                return enemyCreator.getEnemiesByName("Elephant");
            }
            if (randomNumber == 1) {
                return enemyCreator.getEnemiesByName("Otto Otto");
            }
            if (randomNumber == 2) {
                return enemyCreator.getEnemiesByName("Anders the duck");
            }
        }
        return enemyCreator.getEnemiesByName("Bandit"); // TODO?
    }

    private void revealNewLocationsFromHaewenCity() {
        revealedLocations.add(logeCityLocation);
        putHubeCityInVisibleLocations();
        putWaeegCityInVisibleLocations();

        revealedLocations.add(finalBossZlatsLocation);

        revealedLocations.add(pointOfInterest3);// Point of interest TODO Quest?

        revealedLocations.add(suspiciousArea3);

        refreshMapVisibility();
    }

    private void revealNewLocationsFromPointOfInterest3() {
        revealedLocations.add(pointOfInterest1); // Location of dead Keilier
        revealedLocations.add(suspiciousArea1);

        refreshMapVisibility();
    }

    private void revealNewLocationsFromSuspiciousArea3() {
        revealedLocations.add(legendaryEnemyHusasanLocation); // Todo Add more legendary enemies
        revealedLocations.add(bossBlobLocation);

        refreshMapVisibility();
    }

    private void revealNewLocationsFromLogeCity() {
        revealedLocations.add(logeCityLocation);
        putWaeegCityInVisibleLocations();
        putHubeCityInVisibleLocations();

        revealedLocations.add(finalBossZlatsLocation);
        revealedLocations.add(bossBlobLocation);

        revealedLocations.add(pointOfInterest6);

        revealedLocations.add(suspiciousArea5);

        refreshMapVisibility();
    }

    private void revealNewLocationsFromSuspiciousArea5() {
        revealedLocations.add(pointOfInterest5);
        refreshMapVisibility();
    }

    private void revealNewLocationsFromWaeegCity() {
        revealedLocations.add(logeCityLocation);
        putWaeegCityInVisibleLocations();
        putHubeCityInVisibleLocations();

        revealedLocations.add(finalBossZlatsLocation);

        revealedLocations.add(pointOfInterest2);

        revealedLocations.add(suspiciousArea2);
        revealedLocations.add(suspiciousArea4);

        refreshMapVisibility();
    }

    private void revealNewLocationsFromHubeCity() { //TODO SIKRE KUN 1 AF HVER
        revealedLocations.add(logeCityLocation); // Loge City
        putWaeegCityInVisibleLocations();
        putHubeCityInVisibleLocations(); // Hube City

        revealedLocations.add(finalBossZlatsLocation);// Final Boss

        revealedLocations.add(pointOfInterest4);
        revealedLocations.add(pointOfInterest7);

        revealedLocations.add(suspiciousArea6);
        revealedLocations.add(suspiciousArea7);

        refreshMapVisibility();
    }

    private void putWaeegCityInVisibleLocations() {
        revealedLocations.add(waeegCityLocationWest);
        revealedLocations.add(waeegCityLocationEast);
        waeegCityDiscovered = true;
    }

    private void refreshMapVisibility() {
        Component[] components = getContentPane().getComponents();
        for (int i = 0; i < components.length; i++) {
            JPanel panel = (JPanel) components[i];
            int x = i % mapSize;
            int y = i / mapSize;
            Point currentPoint = new Point(x, y);
            MapElement element = specialLocations.getOrDefault(currentPoint, MapElement.UNVISITED);

            if (cityLocations.contains(currentPoint)) { //TODO
                panel.setBackground(MapElement.CITIES.getColor());
            } else if (revealedLocations.contains(currentPoint)) { // COLORS VISIBLE LOCATIONS
                panel.setBackground(element.getColor());
            } else if (waeegCityLocations.contains(currentPoint) && waeegCityDiscovered) {
                Border border = placeWaeegCityOnMap(x, y);
                panel.setBorder(border);
                panel.setBackground(MapElement.CITIES.getColor()); // TODO GET ELEMENT INSTEAD FOR ALL
            } else if (hubeCityLocations.contains(currentPoint) && hubeCityDiscovered) { // Instantiate Hube City.
                Border border = placeHubeCityOnMap(x, y);
                panel.setBorder(border);
                panel.setBackground(MapElement.CITIES.getColor()); // Set Hube City color
            } else if (!revealedLocations.contains(currentPoint)) {
                panel.setBackground(MapElement.UNVISITED.getColor()); // Keep unexplored areas gray
            }
        }
    }

    private Border placeWaeegCityOnMap(int x, int y) {
        boolean middleWestBorder = waeegCityLocations.contains(new Point(x + 1, y));
        boolean middleEastBorder = waeegCityLocations.contains(new Point(x - 1, y));
        return BorderFactory.createMatteBorder(
                1, middleEastBorder ? 0 : 1,  // Middle east border
                1, middleWestBorder ? 0 : 1,  // Middle west border
                MapElement.DEFAULT_BORDER.getColor());
    }

    private Border placeHubeCityOnMap(int x, int y) {
        boolean middleSouthBorder = hubeCityLocations.contains(new Point(x, y - 1));
        boolean middleNorthBorder = hubeCityLocations.contains(new Point(x, y + 1));
        boolean middleWestBorder = hubeCityLocations.contains(new Point(x + 1, y));
        boolean middleEastBorder = hubeCityLocations.contains(new Point(x - 1, y));
        return BorderFactory.createMatteBorder(
                middleSouthBorder ? 0 : 1, // Middle south border
                middleEastBorder ? 0 : 1,  // Middle east border
                middleNorthBorder ? 0 : 1, // Middle north border
                middleWestBorder ? 0 : 1,  // Middle west border
                MapElement.DEFAULT_BORDER.getColor());
    }

    //TODO Display names when hovering in map?

    private void putHubeCityInVisibleLocations() {
        revealedLocations.add(new Point(26, 25));
        revealedLocations.add(new Point(26, 26));
        revealedLocations.add(new Point(27, 25));
        revealedLocations.add(new Point(27, 26));
        hubeCityDiscovered = true;
    }

    private void enemyLocations() {
//        enemyPositions.put(finalBossLocation, enemyCreator.getEnemies(zlats));
    }

    public static void main(String[] args) { // Create the map
        SwingUtilities.invokeLater(() -> MapFrame.getInstance().makeMapVisible());
    }

    public void showAllMapLocationsCHEAT(int playerPositionX, int playerPositionY, int playerLevel) {
        revealedLocations.addAll(specialLocations.keySet()); // Add all special locations to visible locations.
        hubeCityDiscovered = true;
        waeegCityDiscovered = true;
        refreshMapVisibility();
        updatePlayerPosition(playerPositionX, playerPositionY, playerLevel); // TODO NOT NEEDED PLAYERLEVEL HERE?!
    }

}