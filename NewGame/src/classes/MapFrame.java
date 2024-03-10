package classes;

import enums.MapElement;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class MapFrame extends JFrame {
    private final int mapSize = 31;
    private final Set<Point> visitedPositions = new HashSet<>(); // Keep track of visited positions

//    public MapFrame (){        createMapFrame();}
    public void createMapFrame() {

        setTitle("Dusty Map");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 800); // Size
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