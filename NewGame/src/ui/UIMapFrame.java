package ui;

import map_logic.MapFrame;

import java.util.Scanner;

public class UIMapFrame {

    MapFrame mapFrame = MapFrame.getInstance();
    Scanner scanner = new Scanner(System.in);


    public void promptUpdatePlayerPosition(int playerPositionX, int playerPositionY, int playerLevel) {
        mapFrame.updatePlayerPosition(playerPositionX, playerPositionY, playerLevel);
    }

    public void promptMakeMapVisible() {
        mapFrame.makeMapInvisible();
    }

    public void promptMakeMapInvisible() {
        mapFrame.makeMapInvisible();
    }
}
