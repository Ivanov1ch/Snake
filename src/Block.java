/*
// File:             Block.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      A block on the Grid - either food or a part of the snake.
*/

import java.awt.*;

public class Block {
    private int length, width, cellX, cellY;
    private Color color;
    private boolean partOfSnake;

    public Block(boolean partOfSnake, Grid grid){
        this.partOfSnake = partOfSnake;
        length = grid.getSquareSide();
        width = length;
        if(!partOfSnake){
            cellX = -100;
            cellY = -100;
            this.color = Color.green;
        } else{
            this.color = Color.red;
        }
    }

    public void draw(Graphics g){
        if(cellX != -100 && cellY != -100){
            Color oldColor = g.getColor();
            g.setColor(color);
            g.drawRect(cellX * 50, cellY * 50, (cellX + 1) * 50, (cellY + 1) * 50);
            g.setColor(oldColor);
        }
    }
}
