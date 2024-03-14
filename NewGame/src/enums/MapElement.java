package enums;

import java.awt.*;

public enum MapElement {
    PLAYER_LOCATION(Color.PINK),
    VISITED(Color.LIGHT_GRAY),
    VISITED_SPECIAL_LOCATION((new Color(155,255,255))),
    UNVISITED(Color.GRAY),
    CITIES(Color.GREEN),
    POINT_OF_INTEREST(Color.BLUE),
    SUSPICIOUS_AREA(Color.YELLOW),
    LEGENDARY_ENEMY(new Color(244,164,96)),
    BOSS_ENEMY(Color.RED),
    DEFAULT_BORDER(Color.BLACK);

    private final Color color;

    MapElement(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
