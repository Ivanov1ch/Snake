/*
// File:             Block.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      A block on the Grid - either food or a part of the snake.
*/

import java.awt.*;

public class Block {
    private int length, cellX, cellY;
    private Color color;
    private boolean partOfSnake;

    public Block(boolean partOfSnake, Grid grid) {
        this.partOfSnake = partOfSnake;
        length = grid.getSquareSide();
        if (!partOfSnake) {
            this.color = Color.green;
        } else {
            this.color = Color.red;
        }
    }

    public void draw(Graphics g) {
        if (cellX != -100 && cellY != -100) {
            Color oldColor = g.getColor();
            g.setColor(color);
            g.fillRect(cellX * 50, cellY * 50, 50, 50);
            g.setColor(oldColor);
        }
    }

    public void move(int direction) {
        /*
        cellX += Math.cos(Math.toRadians(direction));
        cellY += -Math.sin(Math.toRadians(direction)); //Increase in y means going "down" on the screen, so we have to reverse it
        */

        if (direction == 0)
            cellX++;
        else if (direction == 90)
            cellY--;
        else if (direction == 180)
            cellX--;
        else
            cellY++;
    }

    public void moveToCell(Cell cell) {
        cellX = cell.getX();
        cellY = cell.getY();
    }

    public void placeBlock(int x, int y) {
        cellX = x;
        cellY = y;
    }

    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    public Cell getCellLocation(Grid grid) {
        return new Cell(cellX, cellY, grid.getColors()[0], grid.getColors()[1]);
    }

    public void pickedUp(Snake snake){
        color = Color.red;
        partOfSnake = true;
        snake.addBlock(this);
    }

    public void setColor(Color color){
        this.color = color;
    }
}
