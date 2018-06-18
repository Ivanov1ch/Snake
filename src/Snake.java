/*
// File:             Snake.java
// Created:          2018/06/18
// Author:           danIv (Daniel Ivanovich)
// Description:      The class for the Snake, really an ArrayList of Blocks.
*/

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Block> blocks = new ArrayList<>();
    private int length;

    public Snake(int length, Grid grid, Window game){
        this.length = length;

        for(int i = 0; i < length; i++){
            blocks.add(new Block(true, grid));
        }
    }

    public void draw(Graphics g){
        for(Block block : blocks){
            block.draw(g);
        }
    }
}
