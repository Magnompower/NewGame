package enums;

import java.awt.*;

public enum MapElement {
    GRAY(Color.GRAY),
    CYAN(Color.CYAN),
    RED(Color.RED),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW),
    BLUE(Color.BLUE);

    private final Color color;


    MapElement(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public static Color getColor(int x, int y) {
        if (x == 30 && y == 0 || x == 3 && y == 28) {
            return RED.getColor();
        }

        if (x == 10 && y == 18 || x == 4 && y == 10 || x == 22 && y == 20 || x == 3 && y == 3 ||
                x == 18 && y == 27 || x == 24 && y == 5 || x == 22 && y == 12) {
            return YELLOW.getColor();
        }

        if (x == 15 && y == 8 || x == 26 && y == 26 || x == 27 && y == 26 || x == 26 && y == 25 ||
                x == 27 & y == 25 || x == 6 && y == 18) {
            return GREEN.getColor();
        }
        if (x == 10 && y == 8||x == 5 && y == 24){
            return BLUE.getColor();
        }

        return GRAY.getColor();
    }
}
