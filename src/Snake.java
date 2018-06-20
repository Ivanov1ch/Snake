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
    private int length, direction; //0 = Right, 90 = Up, etc.
    private Block head;
    private Grid grid;

    public Snake(int length, Grid grid) {
        this.length = length;
        this.grid = grid;
        this.direction = 90; //Start going up

        for (int i = 0; i < this.length; i++) {
            blocks.add(new Block(true, grid));
        }

        head = blocks.get(0);

        //Setup block location
        int cellsInSide = grid.getNumCellsOnSide();

        for (int y = cellsInSide; y > cellsInSide - this.length; y--) {
            blocks.get(length - (cellsInSide - y + 1)).placeBlock(cellsInSide / 2 - 1, y - 1);
        }
    }

    public void draw(Graphics g) {
        for (Block block : blocks) {
            block.draw(g);
        }
    }

    public void setDirection(int direction) {
        if(Math.abs(direction - this.direction) != 180) //Don't allow 180 degree turns
            this.direction = direction;
    }

    public void move() {
        //Move the head in direction, and then move each one to take the place of its previous
        Cell headCellLocation = head.getCellLocation(grid);
        head.move(direction);

        Cell moveLocation = null;

        for(int i = 1; i < blocks.size(); i++){
            if(i == 1){
                moveLocation = blocks.get(i).getCellLocation(grid);
                blocks.get(i).moveToCell(headCellLocation);
            } else{
                Cell oldMoveLocation = moveLocation;
                moveLocation = blocks.get(i).getCellLocation(grid);
                blocks.get(i).moveToCell(oldMoveLocation);
            }
        }
    }

    public boolean isGameOver(){
        //Check for overlap

        ArrayList<Cell> occupiedCells = new ArrayList<>();

        for(Block block : blocks){
            occupiedCells.add(block.getCellLocation(grid));
        }

        boolean hasOverlaps = false;

        for(int i = 0; i < occupiedCells.size(); i++){
            Cell selectedCell = occupiedCells.get(i);

            for(int j = 0; j < occupiedCells.size(); j++){
                if(j == i) continue;

                if(selectedCell.getX() == occupiedCells.get(j).getX() && selectedCell.getY() == occupiedCells.get(j).getY()){
                    hasOverlaps = true;
                    break;
                }
            }
        }

        if(hasOverlaps)
            return true;

        //Check for out of bounds

        boolean outOfBounds = false;

        if(head.getCellX() < 0 || head.getCellX() >= grid.getNumCellsOnSide())
            outOfBounds = true;
        else if (head.getCellY() < 0 || head.getCellY() >= grid.getNumCellsOnSide())
            outOfBounds = true;

        return outOfBounds;
    }

    public Block getHead(){return head;}

    public void addBlock(Block block){
        blocks.add(block);
    }

    public ArrayList<Block> getBlocks(){return blocks;}
}
