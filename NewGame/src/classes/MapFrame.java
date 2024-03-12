package classes;

import enemies.Enemy;
import enemies.EnemyCreator;
import enums.MapElement;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

public final class MapFrame extends JFrame {
    private static MapFrame instance; // Singleton instance
    private final int mapSize = 31;
    private Map<Point, Enemy> enemyPositions = new HashMap<>(); // Designate enemies posistions on the map TODO
    private final Set<Point> visitedPositions = new HashSet<>(); // Keep track of visited positions
    private final Set<Point> unlockedLocations = new HashSet<>(); // Keep track of visited positions

    private MapFrame() { // Private constructor to prevent instantiation
        visitedPositions.add(new Point(15, 11));
        visitedPositions.add(new Point(15, 15));
        createMapFrame();
    }

    public static MapFrame getInstance() {
        if (instance == null) {
            instance = new MapFrame();
        }
        return instance;
    }

    public void createMapFrame() {

        setTitle("Dusty Map");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(550, 550); // Size
        setLocation(1000, 50); // Location on screen TODO
        setLayout(new GridLayout(mapSize, mapSize));

        // Create the map grid
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                JPanel panel = new JPanel();
                Point currentPoint = new Point(x, y);
                if (visitedPositions.contains(currentPoint) || unlockedLocations.contains(currentPoint)) {
                    panel.setBackground(MapElement.getColor(x, y));
                } else{
                    panel.setBackground(Color.GRAY); //TODO FEJL HER
                }
                    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

    public void updatePlayerPosition(int playerPositionX, int playerPositionY) {
        visitedPositions.add(new Point(playerPositionX, playerPositionY));

        Point haewenCityLocation = new Point(15, 11);

        if (visitedPositions.contains(haewenCityLocation)) {
            unlockNewLocations1(); // Boss, cities and points of interest.
        }


        Component[] components = getContentPane().getComponents();
        int index = playerPositionY * mapSize + playerPositionX;

        if (index >= 0 && index < components.length) { // Color the space the payer is
            JPanel panel = (JPanel) components[index];
            panel.setBackground(Color.LIGHT_GRAY);
        }

        for (Point point : visitedPositions) {
            int visitedX = point.x;
            int visitedY = point.y;
            int visitedIndex = visitedY * mapSize + visitedX;

            if (visitedIndex >= 0 && visitedIndex < components.length &&
                    !(visitedX == playerPositionX && visitedY == playerPositionY)) {
                JPanel visitedPanel = (JPanel) components[visitedIndex];
                visitedPanel.setBackground(Color.LIGHT_GRAY); // Magenta?
            }
        }
    }

    private void unlockNewLocations1() {
        unlockedLocations.add(new Point(6, 18)); // City
        unlockedLocations.add(new Point(26, 25));// Really
        unlockedLocations.add(new Point(26, 26));// Really
        unlockedLocations.add(new Point(27, 26));// Big
        unlockedLocations.add(new Point(27, 25));// City
        unlockedLocations.add(new Point(30, 0));// Final Boss
        unlockedLocations.add(new Point(10, 8));// Point of interest TODO Quest?

        // After unlocking, you need to refresh the map to reflect the new visibility
        refreshMapVisibility();
    }

    private void refreshMapVisibility() {
        Component[] components = getContentPane().getComponents();
        for (int i = 0; i < components.length; i++) {
            int x = i % mapSize;
            int y = i / mapSize;
            JPanel panel = (JPanel) components[i];

            if (unlockedLocations.contains(new Point(x, y))) {
                // Update color for visited or unlocked locations
                panel.setBackground(MapElement.getColor(x, y));
            }
            // Else, you can decide whether to keep them hidden or show them in another default state
        }


    }

    public static void main(String[] args) { // Create the map
        SwingUtilities.invokeLater(() -> {
            MapFrame.getInstance().makeMapVisible();
        });
    }


}