package classes;

import javax.swing.*;
import java.awt.*;

public class MapFrame extends JFrame {
    boolean makeMapVisible = false;
    private int mapSize = 31;
    private int playerPositionX = 15; // starting x-coordinate (middle of the map)
    private int playerPositionY = 15; // starting y-coordinate (middle of the map)

    public MapFrame() {
        setTitle("Dusty Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800); // Adjust the size as needed
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new GridLayout(mapSize, mapSize)); // Grid layout for the map

        // Create the map grid
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                JPanel panel = new JPanel();
                panel.setBackground((Color.gray));
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//                panel.setBorder(BorderFactory.createEmptyBorder(26,26,27,27)); Want to make the city combined TODO

                if (x == playerPositionX && y == playerPositionY) {
                    panel.setBackground(Color.CYAN); // Color the player's location
                }
                if (x == 30 && y == 0) {
                    panel.setBackground(Color.RED);
                }
                if (x == 15 && y == 8) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 10 && y == 18) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 3 && y == 28) {
                    panel.setBackground(Color.RED);
                }
                if (x == 26 && y == 26) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 27 && y == 26) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 26 && y == 25) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 27 & y == 25) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 6 && y == 18) {
                    panel.setBackground(Color.GREEN);
                }
                if (x == 4 && y == 10) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 22 && y == 20) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 16 && y == 23) {
                    panel.setBackground(Color.RED);
                }
                if (x == 3 && y == 3) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 18 && y == 27) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 24 && y == 5) {
                    panel.setBackground(Color.YELLOW);
                }
                if (x == 22 && y == 12)
                    panel.setBackground(Color.YELLOW);
                add(panel);
                if (playerPositionX == 15 && playerPositionY == 8) {
                    if (x == 10 && y == 8) {
                        panel.setBackground(Color.BLUE);
                    }
                    if (x == 5 && y == 24) {
                        panel.setBackground(Color.BLUE);
                    }
                }

            }
        }
        setVisible(true);
    }
    public void moveNorth() {
        playerPositionY++;
        validatePlayerPosition();
    }

    public void moveSouth() {
        playerPositionY--;
        validatePlayerPosition();
    }

    public void moveEast() {
        playerPositionX++;
        validatePlayerPosition();
    }

    public void moveWest() {
        playerPositionX--;
        validatePlayerPosition();
    }

    public void printPlayerPosition() {
        System.out.println("Position: " + ConsoleColors.YELLOW_BRIGHT + "X" + ConsoleColors.RESET + ": " +
                ConsoleColors.YELLOW_BRIGHT + playerPositionX + ConsoleColors.CYAN_BRIGHT + " Y" +
                ConsoleColors.RESET + ": " + ConsoleColors.CYAN_BRIGHT + playerPositionY);
    }

    public void validatePlayerPosition() {
        if (playerPositionX < 0) {
            playerPositionX = 0;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further west!" + ConsoleColors.RESET);
        } else if (playerPositionX > 40) {
            playerPositionX = 40;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further east!" + ConsoleColors.RESET);
        } else if (playerPositionY < 0) {
            playerPositionY = 0;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further south!" + ConsoleColors.RESET);
        } else if (playerPositionY > 40) {
            playerPositionY = 40;
            System.out.println(ConsoleColors.CYAN_BRIGHT + "You can't move further north!" + ConsoleColors.RESET);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MapFrame::new); // Create the map frame on the Event Dispatch Thread
    }
}