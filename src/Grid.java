/*
// File:             Grid.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The grid that is drawn on the screen every frame.
*/

import java.awt.*;

public class Grid {
    private Color[] colors;
    private Window game;
    private int height, length;

    public Grid(Window window, Color[] gridColors){
        this.game = window;
        height = window.getHeight();
        length = height;

        colors = gridColors;
    }

    public void drawGrid(Graphics g){
        drawBG(g);
        drawLines(g);
        drawBorder(g);
    }

    private void drawBG(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(colors[0]);
        g.fillRect(0, 0, length, height);
        g.setColor(oldColor);
    }

    private void drawLines(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(colors[1]);
        for(int i = 1; i <= length / 50; i++){
            g.drawLine(50 * i, 0, 50 * i, height);
            g.drawLine(0, 50 * i, length, 50 * i);
        }
        g.setColor(oldColor);
    }

    private void drawBorder(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(colors[2]);
        g.drawLine(0, 0, length, 0);
        g.drawLine(0, 0, 0, height);
        g.drawLine(0, height, length, height);
        g.drawLine(length, 0 ,length, height);
        g.setColor(oldColor);
    }

    public int getSquareSide(){
        return length / 50;
    }
}
