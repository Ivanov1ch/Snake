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
    private int numCellsOnSide;
    private Cell[][] grid;

    public Grid(Window window, Color[] gridColors) {
        this.game = window;
        numCellsOnSide = window.getHeight() / 50;

        grid = new Cell[numCellsOnSide][numCellsOnSide];

        colors = gridColors;

        setupCells();
    }

    private void setupCells() {
        for (int i = 0; i < numCellsOnSide; i++) {
            for (int j = 0; j < numCellsOnSide; j++) {
                grid[i][j] = new Cell(i, j, colors[0], colors[1]);
            }
        }
    }


    public void drawGrid(Graphics g) {
        drawBG(g);
        drawCells(g);
        drawBorder(g);
    }

    private void drawBG(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(colors[0]);
        g.fillRect(0, 0, numCellsOnSide * 50, numCellsOnSide * 50);
        g.setColor(oldColor);
    }

    private void drawCells(Graphics g) {
        for (Cell[] column : grid) {
            if (column != null) {
                for (Cell cell : column) {
                    if (cell != null) {
                        cell.draw(g);
                    }
                }
            }
        }

    }

    private void drawBorder(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(colors[2]);
        g.drawRect(0, 0, numCellsOnSide * 50, numCellsOnSide * 50);
        g.setColor(oldColor);
    }

    public void drawOverlappingGridLines(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(colors[1]);
        for (int x = 0; x < numCellsOnSide; x++) {
            g.drawLine(x * 50, 0, x * 50, game.getHeight());
            g.drawLine(0, x * 50, game.getWidth(), x * 50);

        }
        g.setColor(oldColor);

    }

    public int getSquareSide() {
        return numCellsOnSide / 50;
    }

    public int getNumCellsOnSide() {
        return numCellsOnSide;
    }

    public Color[] getColors(){
        return colors;
    }

    public Cell[][] getGrid(){return grid;}
}
