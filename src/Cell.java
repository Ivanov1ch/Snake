/*
// File:             Cell.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      A square cell on the Grid.
*/


import java.awt.*;

public class Cell {

    private int x, y;
    private Color cellColor, wallColor;

    public Cell(int x, int y, Color cellColor, Color wallColor) {
        this.x = x;
        this.y = y;
        this.cellColor = cellColor;
        this.wallColor = wallColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        Color oldColor = g.getColor();
        g.setColor(cellColor);
        g.fillRect(x * 50, y * 50, 50, 50);
        g.setColor(wallColor);
        g.drawRect(x * 50, y * 50, 50, 50);
        g.setColor(oldColor);
    }

    public void setCellColor(Color cellColor){
        this.cellColor = cellColor;
    }

    public boolean containsBlock(Block block){
        return block.getCellX() == x && block.getCellY() == y;
    }
}
