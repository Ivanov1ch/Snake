/*
// File:             GamePanel.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The panel that runs the game and deals with keyboard input.
*/

import javax.swing.*;

public class GamePanel extends JPanel {
    private Window window;
    private int width, height;

    public GamePanel(Window window) {
        this.window = window;
        this.height = window.getHeight();
        this.width = window.getWidth();
    }
}
