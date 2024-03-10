package classes;

import enums.MapElement;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public final class MapFrame extends JFrame {
    private static MapFrame instance; // Singleton instance
    private final int mapSize = 31;
    private final Set<Point> visitedPositions = new HashSet<>(); // Keep track of visited positions

    private MapFrame() { // Private constructor to prevent instantiation
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
                panel.setBackground(MapElement.getColor(x, y));
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

        Component[] components = getContentPane().getComponents();
        int index = playerPositionY * mapSize + playerPositionX;

        if (index >= 0 && index < components.length) { // Color the space the payer is
            JPanel panel = (JPanel) components[index];
            panel.setBackground(Color.MAGENTA);
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

    public static void main(String[] args) { // Create the map
        SwingUtilities.invokeLater(() -> {
            MapFrame.getInstance().makeMapVisible();
        });
    }
}