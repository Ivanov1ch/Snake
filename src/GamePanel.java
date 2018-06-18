/*
// File:             GamePanel.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The panel that runs the game and deals with keyboard input.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel {
    private Timer timer;
    private Window window;
    private int width, height;
    private final int REFRESH_RATE = 5;
    private Color[] gridColors;
    private Grid grid;

    public GamePanel(Window window, Color[] gridColors) {
        this.window = window;
        this.height = window.getHeight();
        this.width = window.getWidth();

        this.gridColors = gridColors;
        setBackground(gridColors[0]);

        setPreferredSize(new Dimension(width, height));

        timer = new javax.swing.Timer(REFRESH_RATE, new AnimationListener());
        timer.start();
        addKeyListener(new UserKeyboardListener());

        grid = new Grid(window, gridColors);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.drawGrid(g);
    }

    private class AnimationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

    public class UserKeyboardListener implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }
    }
}
