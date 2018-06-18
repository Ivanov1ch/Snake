/*
// File:             Game.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      Creates a new Window and runs it.
*/

import java.awt.*;

public class Game {
    public static void main(String[] args) {
        final Color[] GRID_COLORS = {Color.gray, Color.BLACK, Color.BLACK}; //BG, Lines, Border
        Window window = new Window(GRID_COLORS);
        window.start();
    }
}
