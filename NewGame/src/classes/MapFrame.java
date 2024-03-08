package classes;

import enums.MapElement;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class MapFrame extends JFrame {
    boolean makeMapVisible;
    private final int mapSize = 31;
    private final Set<Point> visitedPositions = new HashSet<>(); // Keep track of visited positions

    public MapFrame() {
        setTitle("Dusty Map");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 800); // Adjust the size as needed
        setLocation(1000, 1000); // Center the frame on the screen TODO
        setLayout(new GridLayout(mapSize, mapSize)); // Grid layout for the map

        // Create the map grid
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                JPanel panel = new JPanel();
                panel.setBackground(MapElement.getColor(x, y));
                if (MapElement.getColor(x, y).equals(MapElement.GREEN)) {
                    panel.setBorder(null); // MAYBE REMOVES CITYBORDER TODO
                }
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(panel);
            }
        }
        setMapVisibillity(); // WORKING?? TODO
    }

    public void setMapVisibillity() {
        setVisible(makeMapVisible);
    }

    public void updatePlayerPosition(int playerPositionX, int playerPositionY) {
        visitedPositions.add(new Point(playerPositionX, playerPositionY));

        Component[] components = getContentPane().getComponents();
        int index = playerPositionY * mapSize + playerPositionX;

        if (index >= 0 && index < components.length) {
            JPanel panel = (JPanel) components[index];
            panel.setBackground(Color.CYAN);
        }

        for (Point point : visitedPositions) {
            int visitedX = point.x;
            int visitedY = point.y;
            int visitedIndex = visitedY * mapSize + visitedX;

            if (visitedIndex >= 0 && visitedIndex < components.length &&
                    !(visitedX == playerPositionX && visitedY == playerPositionY)) {
                JPanel visitedPanel = (JPanel) components[visitedIndex];
                visitedPanel.setBackground(Color.MAGENTA); // Light grey?
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MapFrame::new); // Create the map frame on the Event Dispatch Thread
    }
}